package wrapper;

import POJOs.Post;
import POJOs.User;
import enumeration.ApiParam;
import enumeration.ApiResource;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author sercansensulun on 24.10.2021.
 */
public class ServiceWrapper implements Wrapper{

    @Override
    public User getUserByUsername(String username) {
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
        Assert.assertEquals(1, testUsers.size());
        return testUsers.get(0);
    }

    @Override
    public List<Post> getPostsCreatedByUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .param(ApiParam.USERID.getName(), user.getId())
                .get(ApiResource.POSTS.getName())
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<List<Post>>() {
                });
    }
}
