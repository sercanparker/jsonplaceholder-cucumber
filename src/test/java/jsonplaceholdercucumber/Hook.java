package jsonplaceholdercucumber;

import environment.Environment;
import environment.LocalEnvironment;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.io.IOException;

/**
 * @author sercansensulun on 6.10.2021.
 */
public class Hook {

    private Environment environment;

    public Hook() throws IOException {
        this.environment = new LocalEnvironment();
    }

    @Before
    public void beforeEachScenario() {
        //setup scenario here.
        RestAssured.baseURI = environment.getBaseURI();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
