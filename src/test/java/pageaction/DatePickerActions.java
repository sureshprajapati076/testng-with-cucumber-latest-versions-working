package pageaction;

import locators.CitiBankLocators;
import locators.DatePickerLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DatePickerActions {

    WebDriver webDriver;
    DatePickerLocators pageLocator;

    private void setUpDriver(String browser){
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

    public void hideLoginModal(){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(pageLocator.loginModal)).click();
    }

    public void clickRoundTrip() {
        pageLocator.roundTrip.click();
    }

    public void clickDepartureDate() {
        pageLocator.departureDate.click();
    }

    public void selectDepartureAndReturnDate(String departureDate, String returnDate1) {


//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
//
//        LocalDate deptDate = LocalDate.parse(departureDate,formatter);
//
//        LocalDate retDate = LocalDate.parse(returnDate1,formatter);
//
//        String dateDeparture=deptDate.getMonth().toString()+deptDate.getYear();
//        String depDay=String.format("%2s",deptDate.getDayOfMonth());
//
//        String returnDate=retDate.getMonth().toString()+retDate.getYear();
//        String retDay=String.format("%2s",retDate.getDayOfMonth());




        String dateDeparture="January2023";
        String depDay="20";
        String returnDate="July2023";
        String retDay="25";

        boolean departureFlag=false, arrivalFlag=false;

        while(true){

            List<WebElement> months= pageLocator.dayPickerMonths.findElements(pageLocator.dayPickerSingleMonth);

            WebElement leftMonth=months.get(0);
            WebElement rightMonth=months.get(1);

            if(rightMonth.findElement(pageLocator.yearMonthTitle).getText().equalsIgnoreCase(dateDeparture)){
                for (WebElement day : rightMonth.findElements(pageLocator.dayPickerDay)) {
                    if (day.getText().equalsIgnoreCase(depDay)) {
                        day.click();
                        departureFlag=true;
                        break;
                    }
                }
            }else if(leftMonth.findElement(pageLocator.yearMonthTitle).getText().equalsIgnoreCase(dateDeparture)){

                for (WebElement day : leftMonth.findElements(pageLocator.dayPickerDay)) {
                    if (day.getText().equalsIgnoreCase(depDay)) {
                        day.click();
                        departureFlag=true;
                        break;
                    }
                }
            }



            if(rightMonth.findElement(pageLocator.yearMonthTitle).getText().equalsIgnoreCase(returnDate)){
                for (WebElement day : rightMonth.findElements(pageLocator.dayPickerDay)) {
                    if (day.getText().equalsIgnoreCase(retDay)) {
                        day.click();
                        arrivalFlag=true;
                        break;
                    }
                }
            }else if(leftMonth.findElement(pageLocator.yearMonthTitle).getText().equalsIgnoreCase(returnDate)){

                for (WebElement day : leftMonth.findElements(pageLocator.dayPickerDay)) {
                    if (day.getText().equalsIgnoreCase(retDay)) {
                        day.click();
                        arrivalFlag=true;
                        break;
                    }
                }
            }

            waitNsec(5);
           if(!(departureFlag && arrivalFlag))
                pageLocator.nextMonth.click();
           else
               break;

        }
    }

    public void clickSearchButton() {
        pageLocator.searchButton.click();
        waitNsec(30);
    }

    private void waitNsec(int n){
        try {
            Thread.sleep(n*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}