package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

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


    private SeleniumDriver() {
        WebDriver webDriver1 = createDriver();
        threadLocalDriver.set(webDriver1);
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setupDriver() {
        if (getDriver() == null) new SeleniumDriver();
    }

    public static void closeDriver() {

        if (threadLocalDriver.get() != null) {
            getDriver().close();
            getDriver().quit();
            threadLocalDriver.set(null);
        }
    }


    private WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        Boolean headlessOption = Boolean.valueOf(System.getProperty("headless"));
        options.setHeadless(headlessOption);
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        return webDriver;
    }
}
