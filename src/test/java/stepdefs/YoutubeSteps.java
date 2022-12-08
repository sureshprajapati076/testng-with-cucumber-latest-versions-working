package stepdefs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.PropertiesReaderUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class YoutubeSteps {


    WebDriver webDriver = null;

    SoftAssert softAssert = new SoftAssert();

    @Before
    public void setupDriver() {

        //  System.setProperty("webdriver.chrome.driver","C:/Users/sures/Documents/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        Boolean headlessOption=Boolean.valueOf(System.getProperty("headless"));
        options.setHeadless(headlessOption);
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        webDriver.get("https://citibank.com");


//      Document document = Jsoup.parse(webDriver.getPageSource());
//      Elements elements = document.selectXpath("//*[@id='signInBtn']");


        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

        try {
            String fileName = "output-screenshots/Screenshot_" + LocalDateTime.now().toString().replace(":", "-") + ".png";
            FileUtils.copyFile(scrFile, new File(fileName));

            //if we need to attach file to scenario for reporting.
            // scenario.attach(Files.readAllBytes(Paths.get(scrFile.getAbsolutePath())),"image/png",fileName);
            System.out.println("Screenshot taken!");
        } catch (IOException ex2) {
            ex2.printStackTrace();
        }

    }

    @Given("User is in youtube {string} homepage")
    public void user_is_in_youtube_homepage(String string) {
        // Write code here that turns the phrase above into concrete actions

        //  Assert.assertEquals(string,"https://youtube.com","URL is not Youtube related");

        //   softAssert.assertEquals(string,"https://youtube.com1","did not match url");


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

        softAssert.assertTrue(false, "forced failing case");

    }

    @Then("Verify user sees results")
    public void verify_user_sees_results() {
        // Write code here that turns the phrase above into concrete actions
        //    webDriver.quit();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //   softAssert.assertAll();

    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println(scenario.getSourceTagNames());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId());
    }


}
