package jsonplaceholdercucumber;

import POJOs.Comment;
import POJOs.Post;
import POJOs.User;

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
}
