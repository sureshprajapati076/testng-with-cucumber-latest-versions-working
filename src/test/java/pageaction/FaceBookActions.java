package pageaction;

import locators.FaceBookLocators;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.SeleniumDriver;

public class FaceBookActions {
    WebDriver webDriver;
    FaceBookLocators pageLocator;

    private void setUpDriver(String browser){
        SeleniumDriver.setupDriver(browser);
        webDriver = SeleniumDriver.getDriver();
        pageLocator = new FaceBookLocators();
        PageFactory.initElements(webDriver, pageLocator);
    }

    public void openUrl(String url,String browser) {
        setUpDriver(browser);
        webDriver.get(url);
        SeleniumDriver.takeScreenshot();
        SeleniumDriver.attachScreenshotToReport("HomePage");
    }

    public void clickSignup() throws InterruptedException {
        Thread.sleep(2000);
        pageLocator.signup.click();
        Thread.sleep(2000);
        System.out.println("FEMALE: is selected: " + pageLocator.gender.get(0).isSelected());
        pageLocator.gender.get(0).click();
        Thread.sleep(2000);
        System.out.println("FEMALE: is selected: " + pageLocator.gender.get(0).isSelected());
        Thread.sleep(2000);
        Select mySelect = new Select(pageLocator.month);
        mySelect.getOptions().forEach(x -> System.out.println(x.getText()));
        mySelect.selectByVisibleText("Jul");
        SeleniumDriver.takeScreenshot();
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
        System.out.println("BROWSER NAME: "+cap.getBrowserName());
        Assert.assertTrue(true);
    }
}
