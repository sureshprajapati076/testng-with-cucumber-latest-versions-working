package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RetrySteps {


    public static boolean forceFailStep=false;

    @Given("User is in somewhere1")
    public void user_is_in_somewhere1() {
        Assert.assertTrue(true);
    }
    @When("User clicks somewhere1")
    public void user_clicks_somewhere1() {
        Assert.assertTrue(true);
    }
    @Then("verify something1")
    public void verify_something1() {
        Assert.assertTrue(true);
    }

    @Given("User is in somewhere2")
    public void user_is_in_somewhere2() {
        Assert.assertTrue(true);
    }
    @When("User clicks somewhere2")
    public void user_clicks_somewhere2() {
        if(forceFailStep)
            Assert.fail();
        else
            Assert.assertTrue(true);
    }
    @Then("verify something2")
    public void verify_something2() {
        Assert.assertTrue(true);
    }
}
