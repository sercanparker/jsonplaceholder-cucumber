package environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sercansensulun on 6.10.2021.
 */
public class LocalApiEnvironment implements ApiEnvironment {

    private static final String PROPERTIES_FILE_NAME = "properties/environment.properties";

    private Properties properties;

    public LocalApiEnvironment() throws IOException {
        this.properties = new Properties();
        BufferedReader reader = new BufferedReader(new FileReader(PROPERTIES_FILE_NAME));
        properties.load(reader);
    }

    @Override
    public String getBaseURI() {
        return properties.getProperty("base.uri");
    }

}
