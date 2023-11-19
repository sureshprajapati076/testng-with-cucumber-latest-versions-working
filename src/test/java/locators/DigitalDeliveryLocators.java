package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DigitalDeliveryLocators {

    @FindBy(xpath = "//input[@id='cds-input-0']")
    public WebElement ssnBox;
    @FindBy(xpath = "//button[@class='cds-button continue-btn cds-button-df cds-button-primary']")
    public WebElement continueButton;
    @FindBy(xpath = "//button[@id='nextBtn']")
    public WebElement sendCode;
    @FindBy(xpath = "//input[@id='cds-input-1']")
    public WebElement token;
    @FindBy(xpath = "//button[@id='nextBtn']")
    public WebElement otpTokenContinue;


    @FindBy(xpath = "//h4[contains(text(),'Next')]")
    public WebElement headings;
    @FindBy(xpath = "//p[contains(text(),'Once you receive')]")
    public WebElement firstParagraph;
    @FindBy(xpath = "//p[contains(text(),'In the meantime')]")
    public WebElement secondParagraph;

    @FindBy(xpath = "//h4[contains(text(),'miss out')]")
    public WebElement secondHeading;

    @FindBy(xpath = "//p[contains(text(),'Be sure to enroll')]")
    public WebElement secondHeadingFirstParagraph;

    @FindBy(xpath = "//p[contains(text(),'Note')]")
    public WebElement secondHeadingSecondParagraph;

    @FindBy(xpath = "//p[contains(text(),'Add your new card')]")
    public WebElement secondHeadingThirdParagraph;

    @FindBy(xpath = "//button[@class='cds-cta exit-button cds-cta-lg cds-cta-primary cds-cta-priority']")
    public WebElement gotoAtnT;

}
