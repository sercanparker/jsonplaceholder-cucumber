package enumeration;

/**
 * @author sercansensulun on 6.10.2021.
 */
public enum ApiParam {
    USERNAME("username"),
    USERID("userId"),
    POSTID("postId");

    private final String name;

    ApiParam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
