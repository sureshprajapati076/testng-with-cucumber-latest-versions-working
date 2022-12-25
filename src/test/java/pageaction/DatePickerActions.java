package pageaction;

import locators.DatePickerLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.SeleniumDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerActions {

    WebDriver webDriver;
    DatePickerLocators pageLocator;

    private void setUpDriver(String browser) {
        SeleniumDriver.setupDriver(browser);
        webDriver = SeleniumDriver.getDriver();
        pageLocator = new DatePickerLocators();
        PageFactory.initElements(webDriver, pageLocator);
    }

    public void openUrl(String url, String browser) {
        setUpDriver(browser);
        webDriver.get(url);
        waitNsec(3);
    }

    public void hideLoginModal() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(pageLocator.loginModal)).click();
    }

    public void clickRoundTrip() {
        pageLocator.roundTrip.click();
    }

    public void clickDepartureDate() {
        pageLocator.departureDate.click();
    }

    public void selectDepartureAndReturnDate(String departureDate, String returnDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate deptDate = LocalDate.parse(departureDate, formatter);
        LocalDate retDate = LocalDate.parse(returnDate, formatter);

        if (LocalDate.now().isAfter(deptDate) || deptDate.isAfter(retDate)) {
            System.out.println("Date is not correct");
            Assert.fail();
        }

        String dateDeparture = deptDate.getMonth().toString() + deptDate.getYear();
        String depDay = String.valueOf(deptDate.getDayOfMonth());

        String dateReturn = retDate.getMonth().toString() + retDate.getYear();
        String retDay = String.valueOf(retDate.getDayOfMonth());

        //select departure Date.. check on right month first and check on left month
        while (true) {
            waitNsec(1);
            if (pageLocator.rightMonthYearHeading.getText().equalsIgnoreCase(dateDeparture)) {
                webDriver.findElement(By.xpath(pageLocator.rightDayPickerDay.replace("DAYOFMONTH", depDay))).click();
                break;
            } else if (pageLocator.leftMonthYearHeading.getText().equalsIgnoreCase(dateDeparture)) {
                webDriver.findElement(By.xpath(pageLocator.leftDayPickerDay.replace("DAYOFMONTH", depDay))).click();
                break;
            }
            pageLocator.nextMonth.click();
        }


        //select return Date.. check on right month first and check on left month
        while (true) {
            waitNsec(1);
            if (pageLocator.rightMonthYearHeading.getText().equalsIgnoreCase(dateReturn)) {
                webDriver.findElement(By.xpath(pageLocator.rightDayPickerDay.replace("DAYOFMONTH", retDay))).click();
                break;
            } else if (pageLocator.leftMonthYearHeading.getText().equalsIgnoreCase(dateReturn)) {
                webDriver.findElement(By.xpath(pageLocator.leftDayPickerDay.replace("DAYOFMONTH", retDay))).click();
                break;
            }
            pageLocator.nextMonth.click();
        }
    }

    public void clickSearchButton() {
        SeleniumDriver.takeScreenshot();
        pageLocator.searchButton.click();
        waitNsec(3);
    }

    private void waitNsec(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
