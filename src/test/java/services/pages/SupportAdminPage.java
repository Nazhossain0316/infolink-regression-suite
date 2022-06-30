package services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SupportAdminPage {

    WebDriver driver;

    public SupportAdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddTruckButton() {
        WebElement addTruckButton = driver.findElement(By.cssSelector("button#addTruck"));
        addTruckButton.click();
    }

    public void typeInManufacturerField(String valueToType) {
        WebElement inputField = driver.findElement(By.cssSelector("div[role='combobox']>input"));
        inputField.sendKeys(valueToType);
        inputField.sendKeys(Keys.RETURN);
    }

    public void typeInTruckSerialNumber(String serialNumber) {
        WebElement inputField = driver.findElement(By.cssSelector("input#serialNumber"));
        inputField.sendKeys(serialNumber);
    }

    public void typeInTruckName(String truckName) {
        WebElement inputField = driver.findElement(By.cssSelector("input[formcontrolname='name']"));
        inputField.sendKeys(truckName);
    }

    public void selectTruckNameByIndex(int indexForTruckName) {
        WebElement dropDown = driver.findElement(By.cssSelector("lkd-single-select[formcontrolname='equipmentModel'] div[class='ng-select-container'"));
        dropDown.click();

        List<WebElement> options = driver.findElements(By.cssSelector("ng-dropdown-panel div[role='option']"));
        String truckName = options.get(indexForTruckName).getText();

        WebElement inputField = driver.findElement(By.cssSelector("lkd-single-select[formcontrolname='equipmentModel'] input"));
        inputField.sendKeys(truckName);
        inputField.sendKeys(Keys.RETURN);
    }

    public void selectTruckYear(String year) {
        WebElement inputField = driver.findElement(By.cssSelector("lkd-single-select[formcontrolname='year'] input"));
        inputField.sendKeys(year);
        inputField.sendKeys(Keys.RETURN);

    }

    public void selectCustomerByIndex(int index) {
        WebElement dropDown = driver.findElement(By.cssSelector("lkd-single-select[formcontrolname='customer']>ng-select>div"));
        dropDown.click();

        List<WebElement> options = driver.findElements(By.cssSelector("ng-dropdown-panel div[role='option']"));
        String customerName = options.get(index).getText();

        WebElement inputField = driver.findElement(By.cssSelector("lkd-single-select[formcontrolname='customer'] input"));
        inputField.sendKeys(customerName);
        inputField.sendKeys(Keys.RETURN);
    }

    public void selectLocationByIndex(int index) {
        WebElement dropDown = driver.findElement(By.cssSelector("lkd-single-select[formcontrolname='location'] div[class='ng-select-container'"));
        dropDown.click();

        List<WebElement> options = driver.findElements(By.cssSelector("ng-dropdown-panel div[role='option']"));
        String locationName = options.get(index).getText();

        WebElement inputField = driver.findElement(By.cssSelector("lkd-single-select[formcontrolname='location'] input"));
        inputField.sendKeys(locationName);
        inputField.sendKeys(Keys.RETURN);

    }

    public void enterInServiceWeight(String weight) {
        //target the webelement
        WebElement serviceWeightInputField = driver.findElement(By.cssSelector("input[formcontrolname='serviceWeight']"));

        //do operation on webelement
        serviceWeightInputField.sendKeys(weight);
    }

    public void enterInCapacityWeight(String capactiy) {
        //target the webelement
        WebElement serviceCapacityInputField = driver.findElement(By.cssSelector("input[formcontrolname='capacityWeight']"));

        //do operation on webelement
        serviceCapacityInputField.sendKeys(capactiy);
    }

    public void fillInPmIntervalHrs(String numberOfHrs) {
        WebElement pmINputField = driver.findElement(By.cssSelector("input#intervalHourMeterInHours"));
        pmINputField.sendKeys(numberOfHrs);
    }

    public void fillInIntervalDays(String days) {
        WebElement intervalDaysInputField = driver.findElement(By.cssSelector("input#intervalDays"));
        intervalDaysInputField.sendKeys(days);
    }

    public void clickOnNextButton() {
        WebElement nextBtn = driver.findElement(By.cssSelector("button#wizard-next-button"));
        nextBtn.click();
    }

    public void chooseHighImpact() {
        WebElement highImpactChkbox= driver.findElement(By.cssSelector("input#auxHighImpact"));
        highImpactChkbox.click();
    }

    public void fillInFrontToBackHigh(String value) {
        WebElement frontToBackHighInputField = driver.findElement(By.cssSelector("input#powerUnitFBHighX"));
        frontToBackHighInputField.sendKeys(value);
    }

    public void fillInSideToSideHigh(String value) {
        WebElement sideToSideHighInputField= driver.findElement(By.cssSelector("input#powerUnitSSHighY"));
        sideToSideHighInputField.sendKeys(value);
    }

    public void fillInImpulseThreshold(String value) {
        WebElement impulseThresholdInputField= driver.findElement(By.cssSelector("input#powerUnitImpulseLimit"));
        impulseThresholdInputField.sendKeys(value);
    }

    public void fillInFrontToBackHighInMast(String value) {
        WebElement frontToBackHighInMastInputField = driver.findElement(By.cssSelector("input#mastUnitFBHighX"));
        frontToBackHighInMastInputField.sendKeys(value);
    }

    public void fillInSideToSideHighInMast(String value) {
        WebElement sideToSideHighInMastInputField= driver.findElement(By.cssSelector("input#mastUnitSSHighY"));
        sideToSideHighInMastInputField.sendKeys(value);
    }

    public void clickOnSaveButton() {
        WebElement saveBtn = driver.findElement(By.cssSelector("button#wizard-save-button"));
        saveBtn.click();
    }
}
