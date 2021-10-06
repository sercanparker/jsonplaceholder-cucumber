package POJOs;

import lombok.Builder;
import lombok.Getter;

/**
 * @author sercansensulun on 6.10.2021.
 */
@Getter
@Builder
public class Comment {
    long id;
    long postId;
    String name;
    String email;
    String body;
}
