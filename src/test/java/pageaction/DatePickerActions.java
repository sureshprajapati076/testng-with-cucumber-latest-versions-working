package pageaction;

import locators.DatePickerLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.SeleniumDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    // Below are for Experian Site

    public void hideLoginModalExperian() {
        new Actions(webDriver).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void clickCheckInDateExperian() {
        pageLocator.dateSelection.click();
    }

    public void selectCheckInCheckOutDate(String checkInDate, String checkOutDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate checkInLocalDate = LocalDate.parse(checkInDate,formatter);
        LocalDate checkOutLocalDate = LocalDate.parse(checkOutDate,formatter);

        if(checkInLocalDate.isBefore(LocalDate.now()) || checkInLocalDate.isAfter(LocalDate.now().plusMonths(16)) || checkOutLocalDate.isBefore(checkInLocalDate)){
            Assert.fail("Check In Date/Check Out Date incorrect, Allowed Range is 16 months from today for check in/out");
        }

        String checkInMonthYear = Stream.of(checkInDate.split(" ")).filter(x -> !x.contains(",")).collect(Collectors.joining(" "));
        String checkOutMonthYear = Stream.of(checkOutDate.split(" ")).filter(x -> !x.contains(",")).collect(Collectors.joining(" "));

        checkInDate = Stream.of(checkInDate.split(" ")).map(x -> x.matches("^[a-zA-Z]*$") ? x.substring(0, 3) : x).collect(Collectors.joining(" "));

        checkOutDate = Stream.of(checkOutDate.split(" ")).map(x -> x.matches("^[a-zA-Z]*$") ? x.substring(0, 3) : x).collect(Collectors.joining(" "));

        while (!pageLocator.leftMonthYearTitle.getText().equalsIgnoreCase(checkInMonthYear)) {
            pageLocator.getNextMonth.click();
        }

        webDriver.findElement(By.xpath(pageLocator.selectDate.replace("CHECK_IN_DATE", checkInDate))).click();

        while (!( pageLocator.leftMonthYearTitle.getText().equalsIgnoreCase(checkOutMonthYear) || pageLocator.rightMonthYearTitle.getText().equalsIgnoreCase(checkOutMonthYear))) {
            pageLocator.getNextMonth.click();
        }

        webDriver.findElement(By.xpath(pageLocator.selectDate.replace("CHECK_IN_DATE", checkOutDate))).click();

    }

    public void clickOkayButton() {
        pageLocator.okButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
