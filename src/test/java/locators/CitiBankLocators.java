package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitiBankLocators {


    @FindBy(id = "register_acc")
    public WebElement registerAccount;

    @FindBy(id = "brokrgeAccNumLabel")
    public WebElement brokerageAcctNoOption;

    @FindBy(id = "brokrgeAccNumValue")
    public WebElement brokrgeAccNumValue;

    @FindBy(xpath = "//button[text()='Continue Set Up']")
    public WebElement continueButton;

    @FindBy(id = "txtlastFourSSNDigit")
    public WebElement ssnNumber;

    @FindBy(xpath = "//input[@name='DOBValue']")
    public WebElement dobValue;


}
