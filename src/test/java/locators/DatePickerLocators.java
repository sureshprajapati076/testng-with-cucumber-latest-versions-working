package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;

public class DatePickerLocators {


    @FindBy(xpath = "//div[@class='loginModal displayBlock modalLogin dynHeight personal']")
    public WebElement loginModal;

    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    public WebElement roundTrip;

    @FindBy(xpath="//label[@for='departure']")
    public WebElement departureDate;

    @FindBy(xpath="//div[@class='DayPicker-Months']")
    public WebElement dayPickerMonths;

    public By dayPickerSingleMonth = By.xpath(".//div[@class='DayPicker-Month']");

    public By yearMonthTitle = By.className("DayPicker-Caption");

    public String dayPickerDay = ".//div[@class='DayPicker-Body']//div[@class='DayPicker-Day' and not(contains(@class,'DayPicker-Day--disabled'))]//*[text()='DAYOFMONTH']";

    @FindBy(xpath="//span[@aria-label='Next Month']")
    public WebElement nextMonth;

    @FindBy(xpath = "//a[normalize-space()='Search']")
    public WebElement searchButton;
}
