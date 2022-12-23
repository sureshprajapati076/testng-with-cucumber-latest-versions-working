package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;
import stepdefs.BeforeActions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class SeleniumDriver {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static final ThreadLocal<SoftAssert> threadLocalSoftAssert = new ThreadLocal<>();

    public static void setUpSoftAssert() {
        if (getSoftAssert() == null) {
            threadLocalSoftAssert.set(new SoftAssert());
        }
    }

    public static SoftAssert getSoftAssert() {
        return threadLocalSoftAssert.get();
    }

    public static void quitSoftAssert() {
        threadLocalSoftAssert.set(null);
    }


    private SeleniumDriver(String browser) {
        WebDriver webDriver1 = createDriver(browser);
        threadLocalDriver.set(webDriver1);
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setupDriver(String browser) {
        if (getDriver() == null) new SeleniumDriver(browser);
    }

    public static void closeDriver() {

        if (threadLocalDriver.get() != null) {
           // getDriver().close();
            getDriver().quit();
            threadLocalDriver.set(null);
        }
    }


    private WebDriver createDriver(String browser) {
        boolean headlessOption = Boolean.parseBoolean(System.getProperty("headless"));
        WebDriver webDriver;

        if(PropertiesReaderUtils.getFieldValue("remoteSeleniumEnabled").equalsIgnoreCase("true")) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setPlatformName(Platform.LINUX.name());
                options.setHeadless(headlessOption);
                webDriver = new RemoteWebDriver(options);
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
                webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();
                options.setPlatformName(Platform.LINUX.name());
                options.setHeadless(headlessOption);
                webDriver = new RemoteWebDriver(options);
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
                webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            } else {
                FirefoxOptions options = new FirefoxOptions();
                options.setPlatformName(Platform.LINUX.name());
                options.setHeadless(headlessOption);
                webDriver = new RemoteWebDriver(options);
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
                webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            }
        }else{
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(headlessOption);
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        }
        return webDriver;
    }

    public static void attachScreenshotToReport(String name) {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            String fileName = name + ".png";
            //FileUtils.copyFile(scrFile, new File(fileName));

            //if we need to attach file to scenario for reporting.
            BeforeActions.scenarioThreadLocal.get().attach(Files.readAllBytes(Paths.get(scrFile.getAbsolutePath())), "image/png", fileName);
            System.out.println("Screenshot taken!");
        } catch (IOException ex2) {
            ex2.printStackTrace();
        }
    }


    //Below method takes screenshot and save to output-screenshots folder for debug
    public static void takeScreenshot() {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

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
}
