package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import stepdefs.RetrySteps;


@CucumberOptions(plugin = {"pretty",
        "json:target/cucumber-report/cucumber.json",
        "rerun:target/rerun.txt"
}, monochrome = true, dryRun = false, glue = "stepdefs", features = "@target/rerun.txt"
        )
public class FailedRetryRunner extends AbstractTestNGCucumberTests {

    public FailedRetryRunner(){
        RetrySteps.forceFailStep=false;
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
