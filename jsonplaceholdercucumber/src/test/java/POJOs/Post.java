package POJOs;

import lombok.Builder;
import lombok.Getter;

/**
 * @author sercansensulun on 6.10.2021.
 */
@Builder
@Getter
public class Post {
    long id;
    long userId;
    String title;
    String body;

}
