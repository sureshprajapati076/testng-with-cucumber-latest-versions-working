package stepdefs;


import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YoutubeSteps {


    WebDriver webDriver=null;

    @Before
    public void setupDriver(){

        System.setProperty("webdriver.chrome.driver","C:/Users/sures/Documents/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        webDriver.get("https://youtube.com");

    }

    @Given("User is in youtube {string} homepage")
    public void user_is_in_youtube_homepage(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("User enters text {string} in search box")
    public void user_enters_text_in_search_box(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("User Click search Button")
    public void user_Click_search_Button() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("Verify user sees results")
    public void verify_user_sees_results() {
        // Write code here that turns the phrase above into concrete actions
        webDriver.quit();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
