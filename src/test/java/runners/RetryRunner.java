package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import stepdefs.RetrySteps;

@CucumberOptions(plugin = {"pretty",
        "json:target/cucumber-report/cucumber.json",
        "rerun:target/rerun.txt",
}, monochrome = true, dryRun = false, glue = "stepdefs", features = "src/test/resources/retry",
        tags = "@Retry")
public class RetryRunner extends AbstractTestNGCucumberTests {

    public RetryRunner() {
        RetrySteps.forceFailStep = true;
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
