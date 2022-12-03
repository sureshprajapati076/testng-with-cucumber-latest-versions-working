package runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.*;

@CucumberOptions(
        glue = "stepdefs",
        plugin = {"pretty"},
        monochrome = true,
        features = "src/test/resources/Youtube",
        tags = "@youtube")
public class YoutubeRunner extends AbstractTestNGCucumberTests {



    @BeforeSuite
    public void beforeSuite() throws IOException {
        System.out.println("BEFORE SUITE EXECUTED!");
        System.out.println("HI");
/*
        File featureFile= new File("src/test/resources/Youtube/YouTube.feature");
        BufferedWriter writer = null;
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(featureFile),"UTF-8"));

        writer.write("Feature: YouTube Feature Dec 2022\n" +
                "\n" +
                "  @youtube\n" +
                "  Scenario Outline: Search text Automation in youtube\n" +
                "    Given User is in youtube \"<homepage>\" homepage\n" +
                "    When User enters text \"<searchText>\" in search box\n" +
                "    And User Click search Button\n" +
                "    Then Verify user sees results\n" +
                "\n" +
                "    Examples:\n" +
                "      |homepage|searchText|\n" +
                "      |https://youtube.com|Electronics|\n" +
                "\n" +
                "\n" +
                "  @youtube\n" +
                "  Scenario Outline: Search text Automation in youtube Ditital\n" +
                "    Given User is in youtube \"<homepage>\" homepage\n" +
                "    When User enters text \"<searchText>\" in search box\n" +
                "    And User Click search Button\n" +
                "    Then Verify user sees results\n" +
                "\n" +
                "    Examples:\n" +
                "      | homepage            | searchText |\n" +
                "      | https://youtube.com | Digital    |");

        writer.close();

 */
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
