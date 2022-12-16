package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumWebDriver_EasyVersion {

    public static ThreadLocal<WebDriver> threadLocal =  new ThreadLocal<>();

    private SeleniumWebDriver_EasyVersion(){

    }

    public static WebDriver getDriver(){
        if(threadLocal.get()==null){
            WebDriver webDriver=new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            threadLocal.set(webDriver);
        }
        return threadLocal.get();
    }

    public static void quitDriver(){
        if(threadLocal.get()!=null) {
            threadLocal.get().quit();
            threadLocal.set(null);
        }
    }

}
