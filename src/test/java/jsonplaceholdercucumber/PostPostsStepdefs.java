package jsonplaceholdercucumber;

import POJOs.Post;
import enumeration.ApiResource;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import wrapper.ServiceWrapper;

import static io.restassured.RestAssured.given;

/**
 * @author sercansensulun on 24.10.2021.
 */
public class PostPostsStepdefs extends StepDefinitions {

    public PostPostsStepdefs(StepData stepData, ServiceWrapper serviceWrapper) {
        super(stepData, serviceWrapper);
        stepData.postBuilder = Post.builder();
    }

    @And("{string} title is entered for the post")
    public void titleIsEnteredForThePost(String title) {
        stepData.postBuilder.title(title);
    }

    @And("{string} body is entered for the post")
    public void bodyIsEnteredForThePost(String body) {
        stepData.postBuilder.body(body);
    }

    @When("POST request is send with the post")
    public void postRequestIsSendWithThePost() {
        Post post = stepData.postBuilder.build();
        stepData.postPostResponse = given()
                .contentType(ContentType.JSON)
                .body(post)
                .when()
                .post(ApiResource.POSTS.getName())
                .thenReturn();
    }

    @Then("post is created successfully")
    public void postIsCreatedSuccessfully() {
        Response postResponse = stepData.postPostResponse;
        Post post = postResponse.getBody().as(Post.class);
        Assert.assertEquals(201, postResponse.getStatusCode());
        Assert.assertTrue(post.getId() > 0);
    }

    @And("test userId is entered for the post")
    public void testUserIdIsEnteredForThePost() {
        stepData.postBuilder.userId(stepData.testUser.getId());
    }
}
