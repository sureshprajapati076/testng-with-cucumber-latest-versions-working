package runners;



import baserunner.BaseRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.*;

@CucumberOptions(
        glue = "stepdefs",
        plugin = {"pretty"},
        monochrome = true,
        features = "src/test/resources/Youtube",
        tags = "@youtube")
public class YoutubeRunner extends BaseRunner {

    YoutubeRunner(){
        super("src/test/resources/Youtube");
    }
}
