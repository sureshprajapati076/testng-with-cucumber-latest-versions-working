package stepdefs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageaction.DigitalDelliveryActions;
import utils.SeleniumDriver;

import java.time.LocalTime;

public class DigitalDeliverySteps {

    DigitalDelliveryActions actions = new DigitalDelliveryActions();


    @Given("When user clicks vanity url {string}")
    public void when_user_clicks_vanity_url(String url) {
        actions.openUrl(url);

    }
    @When("User provides valid {string} and clicks Next")
    public void user_provides_valid_and_clicks_next(String ssn) {
       actions.inputSSnAndClickNext(ssn);
    }
    @And("User clicks Send Code")
    public void user_clicks_send_code() {
       actions.sendCode();
    }
    @And("User enters valid otp {string} and clicks Next")
    public void user_enters_valid_otp_and_clicks_next(String otp) {
        actions.enterValidTokenAndClicknext(otp);
    }
    @Then("User sees Credit Card Details")
    public void user_sees_credit_card_details() {
        actions.validateContent();
    }


    @AfterStep
    public void beforeStep() throws InterruptedException {
        System.out.println("BEFORE EACH STEP WAITING");
        Thread.sleep(30000);
        SeleniumDriver.attachScreenshotToReport("DigitalDelivery_"+ LocalTime.now().toString().replace(":",""));
    }
}
