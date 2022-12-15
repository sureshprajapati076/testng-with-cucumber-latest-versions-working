package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FaceBookLocators {

    @FindBy(how = How.XPATH, using = "//a[text()='Create new account']")
    public WebElement signup;

    @FindBy(how = How.XPATH, using = "//input[@name='sex']")
    public List<WebElement> gender;

    @FindBy(id = "month")
    public WebElement month;
}
