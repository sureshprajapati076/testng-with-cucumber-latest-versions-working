package pageaction;

import locators.DatePickerLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefs.CommonActions;
import utils.SeleniumDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatePickerActions {

    WebDriver webDriver;
    DatePickerLocators pageLocator;

    public DatePickerActions() {
        webDriver = SeleniumDriver.getDriver();
        pageLocator = new DatePickerLocators();
        PageFactory.initElements(webDriver, pageLocator);
    }

    public void openUrl(String url, String browser) {
        webDriver.get(url);
        waitNsec(3);
    }

    public void hideLoginModal() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(pageLocator.loginModal)).click();
    }

    public void clickRoundTrip() {
        CommonActions.performClick(pageLocator.roundTrip);
    }

    public void clickDepartureDate() {
        CommonActions.performClick(pageLocator.departureDate);
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
                CommonActions.performClick(webDriver.findElement(By.xpath(pageLocator.rightDayPickerDay.replace("DAYOFMONTH", depDay))));
                break;
            } else if (pageLocator.leftMonthYearHeading.getText().equalsIgnoreCase(dateDeparture)) {
                CommonActions.performClick(webDriver.findElement(By.xpath(pageLocator.leftDayPickerDay.replace("DAYOFMONTH", depDay))));
                break;
            }
            CommonActions.performClick(pageLocator.nextMonth);
        }


        //select return Date.. check on right month first and check on left month
        while (true) {
            waitNsec(1);
            if (pageLocator.rightMonthYearHeading.getText().equalsIgnoreCase(dateReturn)) {
                CommonActions.performClick(webDriver.findElement(By.xpath(pageLocator.rightDayPickerDay.replace("DAYOFMONTH", retDay))));
                break;
            } else if (pageLocator.leftMonthYearHeading.getText().equalsIgnoreCase(dateReturn)) {
                CommonActions.performClick(webDriver.findElement(By.xpath(pageLocator.leftDayPickerDay.replace("DAYOFMONTH", retDay))));
                break;
            }
            CommonActions.performClick(pageLocator.nextMonth);
        }
    }

    public void clickSearchButton() {
        SeleniumDriver.takeScreenshot();
        CommonActions.performClick(pageLocator.searchButton);
        waitNsec(3);
    }

    private void waitNsec(long n) {
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
        CommonActions.performClick(pageLocator.dateSelection);
    }

    public void selectCheckInCheckOutDate(String checkInDate, String checkOutDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDate checkInLocalDate = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOutLocalDate = LocalDate.parse(checkOutDate, formatter);

        if (checkInLocalDate.isBefore(LocalDate.now()) || checkInLocalDate.isAfter(LocalDate.now().plusMonths(17)) || checkOutLocalDate.isBefore(checkInLocalDate)) {
            Assert.fail("Check In Date/Check Out Date incorrect, Allowed Range is 17 months from today for check in/out");
        }

        String checkInMonthYear = Stream.of(checkInDate.split(" "))
                .filter(x -> !x.contains(","))
                .collect(Collectors.joining(" "));
        String checkOutMonthYear = Stream.of(checkOutDate.split(" "))
                .filter(x -> !x.contains(","))
                .collect(Collectors.joining(" "));

        checkInDate = Stream.of(checkInDate.split(" "))
                .map(x -> x.matches("^[a-zA-Z]*$") ? x.substring(0, 3) : x) // using First three Chars for Month as per website
                .map(x -> x.startsWith("0") ? x.replace("0", "") : x) // for Day of month if user happen to enter 02 then it will remove 0, since xpath in website uses single digit for day representation
                .collect(Collectors.joining(" "));
        checkOutDate = Stream.of(checkOutDate.split(" "))
                .map(x -> x.matches("^[a-zA-Z]*$") ? x.substring(0, 3) : x)
                .map(x -> x.startsWith("0") ? x.replace("0", "") : x)
                .collect(Collectors.joining(" "));

        Map<String, String> dateMap = new LinkedHashMap<>();
        dateMap.put(checkInDate, checkInMonthYear);
        dateMap.put(checkOutDate, checkOutMonthYear);

        dateMap.forEach((fullDate, monthYear) -> {
            while (pageLocator.monthYearTitle.stream().map(WebElement::getText).noneMatch(mmYYHeading -> mmYYHeading.equalsIgnoreCase(monthYear))) {
                CommonActions.performClick(pageLocator.getNextMonth);
            }
            CommonActions.performClick(webDriver.findElement(By.xpath(pageLocator.selectDate.replace("CHECK_IN_OUT_DATE", fullDate))));
        });

    }

    public void clickOkayButton() {
        CommonActions.performClick(pageLocator.okButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
