package POJOs;

import lombok.Builder;
import lombok.Getter;

/**
 * @author sercansensulun on 6.10.2021.
 */
@Getter
@Builder
public class User {
    long id;
    String name;
    String surname;
    String email;
    Address address;
    String phone;
    String website;
    Company company;
}
