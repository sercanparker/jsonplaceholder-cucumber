package jsonplaceholdercucumber;

import wrapper.ServiceWrapper;
import wrapper.Wrapper;

public class StepDefinitions {

    protected StepData stepData;

    protected Wrapper serviceWrapper;

    public StepDefinitions(StepData stepData, ServiceWrapper serviceWrapper) {
        this.stepData = stepData;
        this.serviceWrapper = serviceWrapper;
    }

}
