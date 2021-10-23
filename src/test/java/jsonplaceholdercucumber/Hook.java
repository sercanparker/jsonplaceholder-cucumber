package jsonplaceholdercucumber;

import environment.DynamicApiEnvironmentManager;
import environment.ApiEnvironment;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

/**
 * @author sercansensulun on 6.10.2021.
 */
public class Hook {

    private ApiEnvironment dynamicEnvironmentManager;

    public Hook(DynamicApiEnvironmentManager dynamicApiEnvironmentManager) {
        this.dynamicEnvironmentManager = dynamicApiEnvironmentManager;
    }

    @Before
    public void beforeEachScenario() {
        //setup scenario here.
        RestAssured.baseURI = dynamicEnvironmentManager.getBaseURI();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
