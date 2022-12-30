package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageaction.DatePickerActions;

public class DatePickerSteps {

    DatePickerActions actions= new DatePickerActions();

    @Given("When user is in makemytrip home page {string} in {string} browser")
    public void when_user_is_in_makemytrip_home_page_in_browser(String url, String browser) {
        actions.openUrl(url,browser);
    }
    @When("User clicks login modal to hide modal")
    public void user_clicks_login_modal_to_hide_modal() {
       actions.hideLoginModal();
    }
    @And("User clicks round-trip option")
    public void user_clicks_round_trip_option() {
       actions.clickRoundTrip();
    }
    @And("User clicks departure date option")
    public void user_clicks_departure_date_option() {
        actions.clickDepartureDate();

    }
    @And("User enters {string} and {string}")
    public void user_enters_and(String departureDate, String returnDate) {
        actions.selectDepartureAndReturnDate(departureDate,returnDate);
    }
    @Then("User clicks search button")
    public void user_clicks_search_button() {
        actions.clickSearchButton();
    }
    
    // Below steps are for Experian site

    @Given("When user is in experian home page {string} in {string} browser")
    public void when_user_is_in_experian_home_page_in_browser(String url, String browser) {
        actions.openUrl(url,browser);
    }
    @When("User press ESC key to hide login modal")
    public void user_press_esc_key_to_hide_login_modal() {
        actions.hideLoginModalExperian();
    }
    @When("User clicks checkin date")
    public void user_clicks_checkin_date() {
        actions.clickCheckInDateExperian();
    }
    @When("User selects {string} and {string}")
    public void user_selects_and(String checkIn, String checkOut) {
        actions.selectCheckInCheckOutDate(checkIn,checkOut);
    }
    @Then("User clicks ok button")
    public void user_clicks_ok_button() {
        actions.clickOkayButton();
    }

}
