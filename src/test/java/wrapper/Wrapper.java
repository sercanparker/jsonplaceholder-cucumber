package wrapper;

import POJOs.Post;
import POJOs.User;

import java.util.List;

/**
 * @author sercansensulun on 24.10.2021.
 */
public interface Wrapper {

    User getUserByUsername(String username);

    List<Post> getPostsCreatedByUser(User user);
}
