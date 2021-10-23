package environment;

import java.io.IOException;

/**
 * @author sercansensulun on 12.10.2021.
 */
public class DynamicApiEnvironmentManager implements ApiEnvironment {

    private final ApiEnvironment delegate;

    public DynamicApiEnvironmentManager() throws IOException {
        String environment = System.getProperty("environment");
        if ("local".equals(environment.toLowerCase())) {
            delegate = new LocalApiEnvironment();
        } else if ("remote".equals(environment.toLowerCase())) {
            delegate = new RemoteApiEnvironment();
        } else {
            delegate = new LocalApiEnvironment();
        }
    }

    @Override
    public String getBaseURI() {
        return delegate.getBaseURI();
    }
}
