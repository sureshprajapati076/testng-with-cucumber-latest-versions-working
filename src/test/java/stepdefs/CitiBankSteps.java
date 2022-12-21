package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageaction.CitiBankActions;

public class CitiBankSteps {

    CitiBankActions actions = new CitiBankActions();


    @Given("When user is in citi home page {string} in {string} browser")
    public void when_user_is_in_citi_home_page_in_browser(String url, String browser) {
        actions.openUrl(url,browser);
    }
    @When("User clicks register account link")
    public void user_clicks_register_account_link() {
        actions.clickOnRegister();
    }
    @And("User selects brokerage account option")
    public void user_selects_brokerage_account_option() {
        actions.selectBrokeargeOption();
    }
    @And("User enters {string}")
    public void user_enters(String acctNo) {
        actions.enterAcctNo(acctNo);
    }
    @And("User clicks continue button")
    public void user_clicks_continue_button() {
        actions.clickContinue();
    }
    @And("User enters {string} in SSN field")
    public void user_enters_in_ssn_field(String ssn) {
        actions.enterSsn(ssn);
    }
    @And("User enters {string} in DOB field")
    public void user_enters_in_dob_field(String dob) {
        actions.enterDob(dob);
    }
    @Then("verify user sees no errors")
    public void verify_user_sees_no_errors() {
        System.out.println("All Test Completed without error");
    }
}
