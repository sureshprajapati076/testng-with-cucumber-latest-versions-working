package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.PropertiesReaderUtils;
import utils.SeleniumDriver;

public class CommonActions {
    public static ThreadLocal<Scenario> scenarioThreadLocal = new ThreadLocal<>();

    public CommonActions() {
    }

    @Before
    public void setUpScenario(Scenario scenario) {
        scenarioThreadLocal.set(scenario);
        SeleniumDriver.setupDriver(PropertiesReaderUtils.getFieldValue("browserName"));
    }

    @AfterStep
    public void screenshotIfFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            SeleniumDriver.takeScreenshot();
        }
    }

    @After
    public void quitDriver() {
        SeleniumDriver.closeDriver();
    }
}
