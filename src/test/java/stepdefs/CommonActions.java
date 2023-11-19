package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.PropertiesReaderUtils;
import utils.SeleniumDriver;

import java.time.Duration;

public class CommonActions {
    public static ThreadLocal<Scenario> scenarioThreadLocal = new ThreadLocal<>();

    public CommonActions() {
    }

    @Before
    public void setUpScenario(Scenario scenario) {
        scenarioThreadLocal.set(scenario);
        SeleniumDriver.setupDriver(PropertiesReaderUtils.getFieldValue("browserName"),Boolean.parseBoolean(PropertiesReaderUtils.getFieldValue("headless")));
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

    public static void performClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        Actions actions = new Actions(SeleniumDriver.getDriver());
        actions.moveToElement(element).click().build().perform();
    }

    public static void performSendKeys(WebElement element, String value){
        Actions actions = new Actions(SeleniumDriver.getDriver());
        actions.moveToElement(element).click().sendKeys(value).build().perform();
    }

}