package runners;


import baserunner.BaseRunnerBrowser;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty",
        "timeline:target/cucumber-timeline/",
        "json:target/cucumber-report/cucumber.json",
        "junit:target/cucumber-report/report-xml.xml",
        "html:target/html-report/html-cucumber.html",
        "rerun:target/rerun.txt"
}, monochrome = true, dryRun = false, glue = "stepdefs", features = {"src/test/resources/chasebank", "src/test/resources/citibank"},
        tags = "@bank")
public class BankRunner extends BaseRunnerBrowser {
}

