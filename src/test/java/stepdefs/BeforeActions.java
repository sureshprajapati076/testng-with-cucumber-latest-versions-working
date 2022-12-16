package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeActions {
    public static ThreadLocal<Scenario> scenarioThreadLocal =  new ThreadLocal<>();

    public BeforeActions(){}

    @Before
    public void setUpScenario(Scenario scenario){
        scenarioThreadLocal.set(scenario);
    }
}
