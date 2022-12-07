package runners;


import baserunner.BaseRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "stepdefs",
        plugin = {"pretty","json:target/cucumber.json","html:target/cucumber.html"},
        monochrome = true,
        features = "src/test/resources/Youtube",
        tags = "@youtube90")
public class YoutubeRunner extends BaseRunner {

    YoutubeRunner(){
        super("src/test/resources/Youtube");
    }
}
