package pageaction;

import locators.CitiBankLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumDriver;

public class CitiBankActions {

    WebDriver webDriver;
    CitiBankLocators pageLocator;

    private void setUpDriver(String browser){
        SeleniumDriver.setupDriver(browser);
        webDriver = SeleniumDriver.getDriver();
        pageLocator = new CitiBankLocators();
        PageFactory.initElements(webDriver, pageLocator);
    }
    public void openUrl(String url, String browser) {
        setUpDriver(browser);
        webDriver.get(url);
        waitNsec(30);
        SeleniumDriver.takeScreenshot();
        SeleniumDriver.attachScreenshotToReport("HomePage");
    }

    public void clickOnRegister() {
        performClick(pageLocator.registerAccount);
    }

    public void selectBrokeargeOption() {
        performClick(pageLocator.brokerageAcctNoOption);
    }

    public void enterAcctNo(String acctNo) {
        performSendKeys(pageLocator.brokrgeAccNumValue, acctNo);
    }

    private void performClick(WebElement element){
        waitNsec(2);
        element.click();
    }
    private void performSendKeys(WebElement element, String value){
        waitNsec(2);
        element.sendKeys(value);
    }

    public void clickContinue() {
        performClick(pageLocator.continueButton);
    }

    private void waitNsec(int n){
        try {
            Thread.sleep(n*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterSsn(String ssn) {
        waitNsec(2);
        performSendKeys(pageLocator.ssnNumber, ssn);
    }

    public void enterDob(String dob) {
        waitNsec(2);
        performSendKeys(pageLocator.dobValue, dob);
    }
}
