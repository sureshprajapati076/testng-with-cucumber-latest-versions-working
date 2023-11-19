package pageaction;

import locators.DigitalDeliveryLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepdefs.CommonActions;
import utils.SeleniumDriver;

public class DigitalDelliveryActions {

    WebDriver driver;
    DigitalDeliveryLocators locators;

    public DigitalDelliveryActions(){
        driver = SeleniumDriver.getDriver();
        locators = new DigitalDeliveryLocators();
        PageFactory.initElements(driver,locators);
    }


    public void openUrl(String url) {
        driver.get(url);
    }


    public void inputSSnAndClickNext(String ssn) {
        CommonActions.performSendKeys(locators.ssnBox,ssn);
        CommonActions.performClick(locators.continueButton);
    }

    public void sendCode() {
        CommonActions.performClick(locators.sendCode);
    }

    public void enterValidTokenAndClicknext(String otp) {
        CommonActions.performSendKeys(locators.token,otp);
        CommonActions.performClick(locators.otpTokenContinue);
    }

    public void validateContent() {
      //  Assert.assertEquals(locators.headings.getText(),"What’s Next");
       // Assert.assertEquals(locators.firstParagraph.getText(),"Once you receive your card in the mail and activate it, you’ll have access to your full credit limit of $3500.0.");
        Assert.assertEquals(locators.secondParagraph.getText(),"In the meantime, you can use your temporary digital card at ATT.com.");
        Assert.assertEquals(locators.secondHeading.getText(),"Don’t miss out on AT&T wireless bill credits!");
        Assert.assertEquals(locators.secondHeadingFirstParagraph.getText(),"Be sure to enroll your AT&T consumer postpaid wireless account in paperless billing and AutoPay with your new card as the saved payment method. Enrollment makes you eligible to earn a statement credit on your card account towards your AT&T wireless bill every billing cycle with qualified spend on your AT&T Points Plus Card.");
        Assert.assertEquals(locators.secondHeadingSecondParagraph.getText(),"Note: You may use your temporary digital card as the AutoPay payment method for your AT&T wireless bill. When you receive your card and activate it, we’ll update AT&T with your permanent card details so AutoPay is not interrupted.");
        Assert.assertEquals(locators.secondHeadingThirdParagraph.getText(),"Add your new card to your AT&T wireless account today!");
        /*

        What’s Next
Once you receive your card in the mail and activate it, you’ll have access to your full credit limit of $3500.0.
In the meantime, you can use your temporary digital card at ATT.com.
Don’t miss out on AT&T wireless bill credits!
Be sure to enroll your AT&T consumer postpaid wireless account in paperless billing and AutoPay with your new card as the saved payment method. Enrollment makes you eligible to earn a statement credit on your card account towards your AT&T wireless bill every billing cycle with qualified spend on your AT&T Points Plus Card.
Note: You may use your temporary digital card as the AutoPay payment method for your AT&T wireless bill. When you receive your card and activate it, we’ll update AT&T with your permanent card details so AutoPay is not interrupted.
Add your new card to your AT&T wireless account today!

         */



        CommonActions.performClick(locators.gotoAtnT);

        waitNseconds(5);

        Assert.assertEquals("https://www.att.com/", driver.getCurrentUrl());

    }

    public void waitNseconds(int n){
        try{
            Thread.sleep(n*1000);
        }
        catch (InterruptedException ignored){

        }
    }
}
