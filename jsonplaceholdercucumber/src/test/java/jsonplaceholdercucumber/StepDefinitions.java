package jsonplaceholdercucumber;

import environment.Environment;
import environment.LocalEnvironment;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.io.IOException;

public class StepDefinitions {

    protected StepData stepData;
    protected Environment environment;

    public StepDefinitions(StepData stepData) throws IOException {
        this.stepData = stepData;
        this.environment = new LocalEnvironment();
    }

    @Before
    public void beforeEachScenario() {
        //setup scenario here.
        RestAssured.baseURI = environment.getBaseURI();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

}
