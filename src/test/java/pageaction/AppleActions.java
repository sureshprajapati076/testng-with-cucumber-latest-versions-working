package pageaction;

import locators.AppleLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumDriver;

public class AppleActions {

    WebDriver driver;
    AppleLocators locators;

    public AppleActions(){
        driver = SeleniumDriver.getDriver();
        locators = new AppleLocators();
        PageFactory.initElements(driver,locators);
    }


    public void openUrl(String url) {
        driver.get(url);
    }

    public void clickiPad() {
        locators.iPadButton.click();
    }

    public void clickBuyButton() {
        locators.buyButton.click();
    }

    public void clickColor(String color) {
        locators.colorChoice.click();
    }

    public void clickStorage(String size) {
        locators.storageSize.click();
    }

    public void clickConnectivity(String connetivity) {
        locators.wifi.click();
    }

    public void clickNoEngraving() {
        locators.noEngraving.click();
    }

    public void clickNoApplePen() {
        locators.noApplePen.click();
    }

    public void clickNoUSBC() {
        locators.noUSBC.click();
    }

    public void clickNoKeyboard() {
        locators.noKeyboard.click();
    }

    public void clickNotradeIn() {
        locators.noTradeIn.click();
    }

    public void clickBuyNow() {
        locators.buyNow.click();
    }

    public void clickNoAppleCare() {
        locators.noAppleCare.click();
    }

    public void clickAddtoBagButton() {
        locators.addToBag.click();
    }
}
