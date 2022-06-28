package services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ImpactMeterPage {

    WebDriver driver;

    public ImpactMeterPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getListOfVisibleColumnNames() {
        List<WebElement> allColumnElements = driver.findElements(By.cssSelector(".liftkit-grid-cell"));
        List<String> allVisibleColumnNames = new ArrayList<>();

        for (int i = 1; i < allColumnElements.size(); i++) {
            allVisibleColumnNames.add(allColumnElements.get(i).getText());
        }
        return allVisibleColumnNames;
    }

    public void clickOnAlarms() {
        List<WebElement> allNavBarItems = driver.findElements(By.cssSelector("lk-navbar-menu-item"));
        for (WebElement singleItem : allNavBarItems) {
            if (singleItem.getText().equals("Alarms")) {
                singleItem.click();
                break;
            }
        }
    }

    public void searchTerm(String searchTerm) {
        WebElement searchField = driver.findElement(By.cssSelector("input.multiselect-field"));
        searchField.sendKeys(searchTerm);

        WebElement magnifier = driver.findElement(By.cssSelector("button.multiselect-search-filter__search-btn"));
        magnifier.click();
    }

    public String getRowText(int rowNumber) {
        WebElement row = driver.findElement(By.cssSelector("tbody>tr:nth-child(" + rowNumber + ")"));
        String rowText = row.getText();
        return rowText;

    }
}
