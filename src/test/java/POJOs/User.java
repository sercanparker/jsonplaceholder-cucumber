package POJOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * @author sercansensulun on 6.10.2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Builder
public class User {
    long id;
    String name;
    String surname;
    String username;
    String email;
    Address address;
    String phone;
    String website;
    Company company;
}
