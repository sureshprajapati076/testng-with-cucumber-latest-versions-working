package stepdefs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.PropertiesReaderUtils;

import java.time.Duration;

public class YoutubeSteps {


    WebDriver webDriver=null;

    SoftAssert softAssert = new SoftAssert();

    @Before
    public void setupDriver(){

     //   System.setProperty("webdriver.chrome.driver","C:/Users/sures/Documents/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        webDriver.get("https://youtube.com");

    }

    @Given("User is in youtube {string} homepage")
    public void user_is_in_youtube_homepage(String string) {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertEquals(string,"https://youtube.com","URL is not Youtube related");

        softAssert.assertEquals(string,"https://youtube.com1","did not match url");



        //softAssert.assertAll();

    }

    @When("User enters text {string} in search box")
    public void user_enters_text_in_search_box(String string) {
        // Write code here that turns the phrase above into concrete actions

        System.out.println(PropertiesReaderUtils.getFieldValue("dataproviderfile"));
        System.out.println(PropertiesReaderUtils.getFieldValue("dataproviderlocation"));

    }

    @When("User Click search Button")
    public void user_Click_search_Button() {
        // Write code here that turns the phrase above into concrete actions

        softAssert.assertTrue(false,"forced failing case");

    }

    @Then("Verify user sees results")
    public void verify_user_sees_results() {
        // Write code here that turns the phrase above into concrete actions
        webDriver.quit();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        softAssert.assertAll();

    }

    @AfterStep
    public void afterStep(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println("CURRENT THREAD: "+Thread.currentThread().getId());
    }


}
