package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatePickerLocators {


    @FindBy(xpath = "//div[@class='loginModal displayBlock modalLogin dynHeight personal']")
    public WebElement loginModal;

    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    public WebElement roundTrip;

    @FindBy(xpath = "//label[@for='departure']")
    public WebElement departureDate;

    @FindBy(xpath = "(//*[@class='DayPicker-Caption'])[1]")
    public WebElement leftMonthYearHeading;

    @FindBy(xpath = "(//*[@class='DayPicker-Caption'])[2]")
    public WebElement rightMonthYearHeading;

    public String leftDayPickerDay = "(//div[@class='DayPicker-Body'])[1]//div[@class='DayPicker-Day']//*[text()='DAYOFMONTH']";
    public String rightDayPickerDay = "(//div[@class='DayPicker-Body'])[2]//div[@class='DayPicker-Day']//*[text()='DAYOFMONTH']";


    /*

    BELOW are detailed one above is simplified one

    @FindBy(xpath="(//div[@class='DayPicker-Month'])[1]//*[@class='DayPicker-Caption']")
    public WebElement leftMonthYearHeading;

    @FindBy(xpath="(//div[@class='DayPicker-Month'])[2]//*[@class='DayPicker-Caption']")
    public WebElement rightMonthYearHeading;

    public String leftDayPickerDay = "(//div[@class='DayPicker-Month'])[1]//div[@class='DayPicker-Body']//div[@class='DayPicker-Day' and not(contains(@class,'DayPicker-Day--disabled'))]//*[text()='DAYOFMONTH']";
    public String rightDayPickerDay = "(//div[@class='DayPicker-Month'])[2]//div[@class='DayPicker-Body']//div[@class='DayPicker-Day' and not(contains(@class,'DayPicker-Day--disabled'))]//*[text()='DAYOFMONTH']";


     */
    @FindBy(xpath = "//span[@aria-label='Next Month']")
    public WebElement nextMonth;

    @FindBy(xpath = "//a[normalize-space()='Search']")
    public WebElement searchButton;

    // NOTE: to select element inside another element. xpath should be started with .//  if used only // then it will search over all page instead of within element
    // eg.
    //  WebElement parentElement = driver.findElement(By.xpath("//div[@id='abc']));
    //  WebElement childElement = parentElement.findElements(By.xpath(".//div[@class='xyz']"));


    //BELOW ARE FOR EXPERIAN SITE


    @FindBy(xpath = "//button[@id='d1-btn']")
    public WebElement dateSelection;

    @FindBy(xpath = "//h2[@class='uitk-date-picker-month-name uitk-type-medium']")
    public List<WebElement> monthYearTitle;

    public String selectDate = "//button[@aria-label='CHECK_IN_OUT_DATE']";

    @FindBy(xpath = "//div[@class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-date-picker-menu-pagination-container']//button[2]")
    public WebElement getNextMonth;

    @FindBy(xpath = "//button[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")
    public WebElement okButton;


}
