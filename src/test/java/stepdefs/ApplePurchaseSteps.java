package stepdefs;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageaction.AppleActions;

public class ApplePurchaseSteps {

    AppleActions actions = new AppleActions();

    @Given("User is in apple home page {string}")
    public void user_is_in_apple_home_page(String url) {
       actions.openUrl(url);
    }
    @When("User clicks iPad link in banner")
    public void user_clicks_i_pad_link_in_banner() {
        actions.clickiPad();
    }
    @And("User clicks buy button")
    public void user_clicks_buy_button() {
        actions.clickBuyButton();
    }
    @And("User selects color {string}")
    public void user_selects_color(String color) {
       actions.clickColor(color);

    }
    @And("User selects storage {string}")
    public void user_selects_storage(String size) {
       actions.clickStorage(size);
    }
    @And("User selects connectivity {string}")
    public void user_selects_connectivity(String connetivity) {
        actions.clickConnectivity(connetivity);
    }
    @And("User selects no engraving")
    public void user_selects_no_engraving() {
        actions.clickNoEngraving();
    }
    @And("User selects no apple Pen")
    public void user_selects_no_apple_pen() {
       actions.clickNoApplePen();

    }
    @And("User selects no USB C")
    public void user_selects_no_usb_c() {
        actions.clickNoUSBC();
    }
    @And("User selects no Keyboard")
    public void user_selects_no_keyboard() {
        actions.clickNoKeyboard();
    }
    @And("User selects no trade in")
    public void user_selects_no_trade_in() {
        actions.clickNotradeIn();
    }
    @And("User selects buy")
    public void user_selects_buy() {
        actions.clickBuyNow();
    }
    @And("User selects no apple care")
    public void user_selects_no_apple_care() {
        actions.clickNoAppleCare();
    }
    @And("User selects Add to bag button")
    public void user_selects_add_to_bag_button() {
        actions.clickAddtoBagButton();
    }
    @Then("Verify ipad is added to bag")
    public void verify_ipad_is_added_to_bag() throws InterruptedException {
        System.out.println("ALL DONE");
        Thread.sleep(10000);
    }

    @BeforeStep
    public void beforeStep() throws InterruptedException {
        Thread.sleep(2000);
    }
}
