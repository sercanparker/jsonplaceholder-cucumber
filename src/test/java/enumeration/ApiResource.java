package enumeration;

/**
 * @author sercansensulun on 6.10.2021.
 */
public enum ApiResource {
    USERS("users"),
    COMMENTS("comments"),
    POSTS("posts");

    private final String name;

    ApiResource(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
