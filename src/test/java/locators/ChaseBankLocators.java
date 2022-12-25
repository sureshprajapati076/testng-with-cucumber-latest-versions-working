package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChaseBankLocators {
    @FindBy(id = "PremiumToggle")
    public WebElement premiumOption;

    @FindBy(xpath = "//a[@data-lh-name='openNowSapphireTop']")
    public WebElement openNow;

    @FindBy(css = "#existingChaseCustomerOptionId")
    public WebElement shadow;

    @FindBy(css ="#NEXT-nav-ctr-btn")
    public WebElement nextButton;

}
