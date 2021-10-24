package jsonplaceholdercucumber;

import POJOs.Comment;
import POJOs.Post;
import POJOs.User;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sercansensulun on 6.10.2021.
 */
public class StepData {
    public User testUser;
    public List<Post> testPosts;
    public List<Comment> testComments;
    public Map<Post, List<Comment>> testPostsWithComments;
    public List<Comment> testCommentsByPathParam;
    public List<Comment> testCommentsByQueryParam;
    public Post.PostBuilder postBuilder;
    public Response postPostResponse;
    public Map<String, User> testUsersMap = new HashMap<>();
}
