package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class AppleLocators {

    @FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-ipad']")
    public WebElement iPadButton;
    @FindBy(xpath = "//div[@class='text-content']//a[@aria-label='Buy iPad 10.9-inch'][normalize-space()='Buy']")
    public WebElement buyButton;
    @FindBy(xpath = "(//label//img[@class='form-selector-swatch'])[2]")
    public WebElement colorChoice;
    @FindBy(xpath = "//label[@class='form-selector-label']/span[contains(text(),'64')]")
    public WebElement storageSize;
    @FindBy(xpath = "//span[@class='form-selector-title' and contains(text(),'Wi-Fi') and not(contains(text(),'Cellular'))]")
    public WebElement wifi;
    @FindBy(xpath = "//span[contains(text(),'No engraving')]")
    public WebElement noEngraving;
    @FindBy(xpath = "//button[@data-autom='acc_pencil_first_section_noaccessory']")
    public WebElement noApplePen;
    @FindBy(xpath = "//span[contains(text(),'No USB-C to Apple Pencil Adapter')]")
    public WebElement noUSBC;
    @FindBy(xpath = "//button[@class='rf-inlineaccessorylot-button']//span[@class='column large-12']//span[@class='rf-accessorybutton-left-label']")
    public WebElement noKeyboard;
    @FindBy(xpath = "//span[contains(text(),'No trade-in')]")
    public WebElement noTradeIn;
    @FindBy(xpath = "//span[normalize-space()='Buy']")
    public WebElement buyNow;
    @FindBy(xpath = "(//span[text()='No AppleCare+'])[1]")
    public WebElement noAppleCare;
    @FindBy(xpath = "//button[@title='Add to Bag']")
    public WebElement addToBag;

}
