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
}
