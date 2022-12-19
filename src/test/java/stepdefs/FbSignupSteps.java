package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageaction.FaceBookActions;
import utils.SeleniumDriver;


public class FbSignupSteps {

    FaceBookActions pageAction = new FaceBookActions();
    public static Scenario scenario;

    @Before
    public void setUpScenario(Scenario scenario){
        this.scenario=scenario;
    }

    @Given("User is in facebook {string} homepage")
    public void user_is_in_facebook_homepage(String url) {
        // Write code here that turns the phrase above into concrete actions

        pageAction.openUrl(url);
   //     Assert.fail();

    }

    @And("User clicks signup button")
    public void user_clicks_signup_button() throws InterruptedException {
        pageAction.clickSignup();
    }

    @Then("Verify user sees signup page")
    public void verify_user_sees_signup_page() {
        // Write code here that turns the phrase above into concrete actions

    }

    @After
    public void quitDriver() {
        SeleniumDriver.closeDriver();
    }

    @AfterStep
    public void takeScreenshotForFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("FAILED SCENARIO");
            // For failure test case: screenshot would be taken care by @Listners annotation using TestNG
        }
    }


}
