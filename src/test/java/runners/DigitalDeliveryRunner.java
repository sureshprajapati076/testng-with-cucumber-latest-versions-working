package runners;


import baserunner.BaseRunnerBrowserTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty",
        "timeline:target/cucumber-timeline/",
        "json:target/cucumber-report/cucumber.json",
        "junit:target/cucumber-report/report-xml.xml",
        "html:target/html-report/html-cucumber.html",
        "rerun:target/rerun.txt"
}, monochrome = true, dryRun = false, glue = "stepdefs", features = {"src/test/resources/digitaldelivery"},
        tags = "@DigitalDelivery")
public class DigitalDeliveryRunner extends BaseRunnerBrowserTest {


    // mvn clean -D"cucumber.filter.tags"="@DigitalDelivery" -D"buildrunner"="DigitalDeliveryRunner.java" verify
}

