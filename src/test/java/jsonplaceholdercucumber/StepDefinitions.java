package jsonplaceholdercucumber;

import environment.DynamicApiEnvironmentManager;

public class StepDefinitions {

    protected StepData stepData;
    private DynamicApiEnvironmentManager dynamicApiEnvironmentManager;

    public StepDefinitions(StepData stepData) {
        this.stepData = stepData;
    }

    public StepDefinitions(StepData stepData, DynamicApiEnvironmentManager dynamicApiEnvironmentManager){
        this.stepData = stepData;
        this.dynamicApiEnvironmentManager = dynamicApiEnvironmentManager;
    }

}
