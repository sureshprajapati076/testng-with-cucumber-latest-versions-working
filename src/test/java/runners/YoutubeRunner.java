package runners;


import baserunner.BaseRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "stepdefs",
        plugin = {"pretty"},
        monochrome = true,
        features = "src/test/resources/Youtube",
        tags = "@youtube90   or   @youtube91 or @youtube92")
public class YoutubeRunner extends BaseRunner {

    YoutubeRunner(){
        super("src/test/resources/Youtube");
    }
}
