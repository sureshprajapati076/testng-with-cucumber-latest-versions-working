package pageaction;

import locators.ChaseBankLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumDriver;

public class ChaseBankActions {


    WebDriver webDriver;
    ChaseBankLocators pageLocator;

    private void setUpDriver(String browser){
        SeleniumDriver.setupDriver(browser);
        webDriver = SeleniumDriver.getDriver();
        pageLocator = new ChaseBankLocators();
        PageFactory.initElements(webDriver, pageLocator);
    }
    public void openUrl(String url, String browser) {
        setUpDriver(browser);
        webDriver.get(url);
        waitNsec(2);
        SeleniumDriver.takeScreenshot();
        SeleniumDriver.attachScreenshotToReport("HomePage");
    }

    public void selectPremium() {
        pageLocator.premiumOption.click();
    }

    public void clickOpenNow() {
        waitNsec(2);
        pageLocator.openNow.click();
    }

    public void clickNonExistingCustomer() {
        SearchContext shadow = pageLocator.shadow.getShadowRoot();
        waitNsec(3);
        shadow.findElement(By.cssSelector("#existingChaseCustomerOptionId-input-1")).click();
    }

    public void clickNextButton() {
        SearchContext shadow=pageLocator.nextButton.getShadowRoot();
        waitNsec(3);
        shadow.findElement(By.cssSelector(".button__label")).click();
        waitNsec(10);
    }

    private void waitNsec(long n){
        try {
            Thread.sleep(n*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
