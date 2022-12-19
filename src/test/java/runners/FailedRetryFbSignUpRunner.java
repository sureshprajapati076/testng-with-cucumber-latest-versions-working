package runners;


import baserunner.BaseRunnerBrowser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(plugin = {"pretty",
        "timeline:target1/cucumber-timeline/",
        "json:target1/cucumber-report/cucumber.json",
        "junit:target1/cucumber-report/report-xml.xml",
        "html:target1/html-report/html-cucumber.html",
        "rerun:target1/rerun.txt"
}, monochrome = true, dryRun = false, glue = "stepdefs", features = "@target/rerun.txt",
        tags = "@signup")
public class FailedRetryFbSignUpRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
