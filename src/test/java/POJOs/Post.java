package POJOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * @author sercansensulun on 6.10.2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
public class Post {
    long id;
    long userId;
    String title;
    String body;

}
