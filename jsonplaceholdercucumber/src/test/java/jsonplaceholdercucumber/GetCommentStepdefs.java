package jsonplaceholdercucumber;

import POJOs.Comment;
import POJOs.Post;
import POJOs.User;
import enumeration.ApiParam;
import enumeration.ApiResource;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sercansensulun on 6.10.2021.
 */
public class GetCommentStepdefs extends StepDefinitions {

    public GetCommentStepdefs(StepData stepData) {
        super(stepData);
    }

    @Then("e-mail formats are correct in the comments")
    public void eMailFormatsAreCorrectInTheComments() {
        stepData.testComments.forEach(
                comment -> {
                    Assert.assertTrue(String.format("%s should be e-mail format.", comment.getEmail()), EmailValidator.getInstance().isValid(comment.getEmail()));
                }
        );
    }

    @Given("there is an user has {string} username")
    public void thereIsAnUserHasUsername(String username) {
        List<User> testUsers = given()
                .contentType(ContentType.JSON)
                .when()
                .param(ApiParam.USERNAME.getName(), username)
                .get(ApiResource.USERS.getName())
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<List<User>>() {
                });
        User testUser = testUsers.get(0);

        Assert.assertEquals(1, testUsers.size());
        Assert.assertEquals(String.format("Given %s username should be exist to execute test.", username), username, testUser.getUsername());
        stepData.testUser = testUser;
    }

    @And("there are posts written by test user")
    public void thereArePostsWrittenByTestUser() {
        User testUser = stepData.testUser;
        List<Post> posts = given()
                .contentType(ContentType.JSON)
                .when()
                .param(ApiParam.USERID.getName(), testUser.getId())
                .get(ApiResource.POSTS.getName())
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<List<Post>>() {
                });

        Assert.assertTrue(posts.size() > 0);
        stepData.testPosts = posts;
    }

    @Then("name values are not empty in the comments")
    public void nameValuesAreNotEmptyInTheComments() {
        stepData.testComments.forEach(
                comment -> {
                    Assert.assertTrue(String.format("%s name should not be empty.", comment.getName()), StringUtils.isNotEmpty(comment.getName()));
                }
        );
    }

    @Then("all id values are different from each other in the comments")
    public void allIdValuesAreDifferentFromEachOtherInTheComments() {
        List<Long> distinctCommentIds = stepData.testComments.stream().map(Comment::getId).distinct().collect(Collectors.toList());
        Assert.assertEquals(stepData.testComments.size(), distinctCommentIds.size());
    }

    @Then("all postId values are same and matched with the post in the comments")
    public void allPostIdValuesAreSameAndMatchedWithThePostInTheComments() {
        stepData.testPostsWithComments.forEach(
                (post, comments) -> {
                    comments.forEach(
                            comment -> Assert.assertEquals(post.getId(), comment.getPostId())
                    );
                }
        );
    }

    @Then("body values are not empty in the comments")
    public void bodyValuesAreNotEmptyInTheComments() {
        stepData.testComments.forEach(
                comment -> {
                    Assert.assertTrue(String.format("%s body should not be empty.", comment.getBody()), StringUtils.isNotEmpty(comment.getBody()));
                }
        );
    }

    @When("all comments are retrieved for each post by path param")
    public void allCommentsAreRetrievedForEachPostByPathParam() {
        List<Comment> comments = new ArrayList<>();
        stepData.testPosts.forEach(
                post -> {
                    List<Comment> commentList = given()
                            .contentType(ContentType.JSON)
                            .when()
                            .pathParam("postId", post.getId())
                            .get(ApiResource.POSTS.getName() + "/{postId}/" + ApiResource.COMMENTS.getName())
                            .then()
                            .statusCode(200)
                            .extract()
                            .as(new TypeRef<List<Comment>>() {
                            });
                    comments.addAll(commentList);
                }
        );

        Assert.assertTrue("There should be comment to test.", comments.size() > 0);
        stepData.testCommentsByPathParam = comments;
    }

    @And("all comments are retrieved for each post by query param")
    public void allCommentsAreRetrievedForEachPostByQueryParam() {
        List<Comment> comments = new ArrayList<>();
        Map<Post, List<Comment>> postsWithComments = new HashMap<>();
        stepData.testPosts.forEach(
                post -> {
                    List<Comment> commentList = given()
                            .contentType(ContentType.JSON)
                            .when()
                            .param(ApiParam.POSTID.getName(), post.getId())
                            .get(ApiResource.COMMENTS.getName())
                            .then()
                            .statusCode(200)
                            .extract()
                            .as(new TypeRef<List<Comment>>() {
                            });
                    comments.addAll(commentList);
                    postsWithComments.put(post, commentList);
                }
        );

        Assert.assertTrue("There should be comment to test.", comments.size() > 0);
        stepData.testComments = comments;
        stepData.testCommentsByQueryParam = comments;
        stepData.testPostsWithComments = postsWithComments;
    }

    @Then("comments are the same retrieved by path and query param.")
    public void commentsAreTheSameRetrievedByPathAndQueryParam() {
        assertThat(stepData.testCommentsByPathParam).usingRecursiveFieldByFieldElementComparator().usingElementComparatorIgnoringFields().isEqualTo(stepData.testCommentsByQueryParam);
    }
}
