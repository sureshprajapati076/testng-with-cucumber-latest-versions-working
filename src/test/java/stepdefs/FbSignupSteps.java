package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageaction.FaceBookActions;


public class FbSignupSteps {

    FaceBookActions pageAction = new FaceBookActions();
    public static Scenario scenario;

    @Before
    public void setUpScenario(Scenario scenario) {
        FbSignupSteps.scenario = scenario;
    }

    @Given("User is in facebook {string} homepage in {string}")
    public void user_is_in_facebook_homepage(String url, String browser) {
        // Write code here that turns the phrase above into concrete actions

        pageAction.openUrl(url, browser);
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

}
