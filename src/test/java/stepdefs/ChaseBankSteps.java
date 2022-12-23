package stepdefs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageaction.ChaseBankActions;
import utils.SeleniumDriver;

public class ChaseBankSteps {
    ChaseBankActions actions = new ChaseBankActions();

    @Given("User is in home chase home page {string} in {string}")
    public void user_is_in_home_chase_home_page_in(String url, String browser) {
        actions.openUrl(url,browser);
    }
    @And("User clicks Premium option")
    public void user_clicks_premium_option() {
       actions.selectPremium();
    }
    @And("User clicks Open Now")
    public void user_clicks_open_now() {
       actions.clickOpenNow();
    }
    @And("User clicks No in existing customer")
    public void user_clicks_no_in_existing_customer() {
      actions.clickNonExistingCustomer();
    }
    @And("User clicks Next button")
    public void user_clicks_next_button() {
      actions.clickNextButton();
    }

    @AfterStep
    public void screenshotIfFailed(Scenario scenario){
        if(scenario.isFailed()){
            SeleniumDriver.takeScreenshot();
        }
    }

}
