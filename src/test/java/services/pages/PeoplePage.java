package services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import services.utilities.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PeoplePage {

    WebDriver driver;

    public PeoplePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInUserDetails(User user) {
        fillInFirstNameField(user.getFirstName());
        fillInMiddleNameField(user.getMiddleName());
        fillInLastNameField(user.getLastName());
        fillInEmployeeNumber(user.getEmployeeNumber());
        selectLanguage(user.getLanguage());
        //selectTimeZone(user.getTimeZone()); Using default timeZone for now
        selectUnitOfMeasure(user.getUnitOfMeasure());
    }

    public void clickNextButton() {
        WebElement nextBtn = driver.findElement(By.cssSelector("button#next"));
        nextBtn.click();
    }

    public void selectUnitOfMeasure(String unitOfMeasure) {
        Select select = new Select(driver.findElement(By.cssSelector("select[name='measurementPref']")));
        select.selectByVisibleText(unitOfMeasure);
    }

    public void selectTimeZone(String timeZone) {
        //toDo: The cssSelector for the dropdown is unable to make a selection. Need to do more investigating
    }

    private void selectLanguage(String language) {
        Select select = new Select(driver.findElement(By.cssSelector("select[formcontrolname='locale']")));
        select.selectByVisibleText(language);
    }

    private void fillInEmployeeNumber(String employeeNumber) {
        WebElement employeeNumberField = driver.findElement(By.cssSelector("input#employeeNumber"));
        employeeNumberField.sendKeys(employeeNumber);
    }

    private void fillInLastNameField(String lastName) {
        WebElement lastNameField = driver.findElement(By.cssSelector("input#lastName"));
        lastNameField.sendKeys(lastName);
    }

    public void fillInMiddleNameField(String middleName) {
        WebElement middleNameField = driver.findElement(By.cssSelector("input#middleName"));
        middleNameField.sendKeys(middleName);
    }

    public void fillInFirstNameField(String firstName) {
        WebElement firstNameField = driver.findElement(By.cssSelector("input#firstName"));
        firstNameField.sendKeys(firstName);
    }

    public void selectUserTypeRadioButton(String userType) {
        WebElement radioBtn = null;

        switch (userType) {
            case "Operator":
                radioBtn = driver.findElement(By.cssSelector("input[value='equipment']"));
                break;

            case "Web User":
                radioBtn = driver.findElement(By.cssSelector("input[value='web']"));
                break;

            case "Web User and Operator":
                radioBtn = driver.findElement(By.cssSelector("input[value='both']"));
                break;
        }
        radioBtn.click();
    }

    public void clickAddUserButton() {
        WebElement addUserBtn = driver.findElement(By.cssSelector("button#createUser"));
        addUserBtn.click();
    }

    public void searchAssignedLocation(String assignedLocation) {
        WebElement search = driver.findElement(By.cssSelector("input[formcontrolname='multiselectField']"));
        search.sendKeys(assignedLocation);

        WebElement searchBtn = driver.findElement(By.cssSelector("button.multiselect-search-filter__search-btn"));
        searchBtn.click();
    }

    public ArrayList<String> getListOfNamesInLocationsGrid() {
        List<WebElement> rowElements = driver.findElements(By.cssSelector("tr.liftkit-grid-data-row"));
        ArrayList<String> namesOfLocations = new ArrayList<>();

        for (WebElement rowElement : rowElements) {
            namesOfLocations.add(rowElement.findElement(By.cssSelector("td:nth-child(2)")).getText());
        }

        return namesOfLocations;
    }

    public void selectLocationByName(String locationNameToSelect) {
        List<WebElement> rowElements = driver.findElements(By.cssSelector("tr.liftkit-grid-data-row"));

        for (WebElement rowElement : rowElements) {
            String nameOfLocation = rowElement.findElement(By.cssSelector("td:nth-child(2)")).getText();
            if (nameOfLocation.equals(locationNameToSelect)) {
                WebElement checkBoxForLocation = rowElement.findElement(By.cssSelector("input[type='checkbox']"));
                checkBoxForLocation.click();
                break;
            }
        }
        ;
    }

    public void insertEmailAddress(String userEmailAddress) {
        WebElement emailInputField = driver.findElement(By.cssSelector("#email"));
        emailInputField.sendKeys(userEmailAddress);
    }

    public void selectWebRole(String webRole) {
        Select dropDown = new Select(driver.findElement(By.cssSelector("select[name='webRole']")));
        dropDown.selectByVisibleText(webRole);
    }

    public void selectApplicationCheckBoxes(ArrayList<String> applicationsToGrantAccess) {
        List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("li.checkbox"));
        for (WebElement checkBox : allCheckBoxes) {
            if (applicationsToGrantAccess.contains(checkBox.findElement(By.cssSelector("span")).getText())) {
                checkBox.findElement(By.cssSelector("input")).click();
            }
        }
    }

    public void fillAccessSecurityReportTypes(String reportType, String frequency) {
        //reportType = name of the report
        // frequency = String with Letters of the desired frequency. Example "DY" for Daily and Yearly Options. "MY" for monthly and YEarly. "D" for only Daily
        List<WebElement> allROwsOfReportTypes = driver.findElements(By.cssSelector("tbody>tr"));

        for (WebElement row : allROwsOfReportTypes) {
            if (row.findElement(By.cssSelector("td:nth-child(1)>div")).getText().equals(reportType)) {
                if (frequency.contains("D")) {
                    row.findElement(By.cssSelector("td:nth-child(2) input")).click();
                }
                if (frequency.contains("M")) {
                    row.findElement(By.cssSelector("td:nth-child(3) input")).click();

                }
                if (frequency.contains("Y")) {
                    row.findElement(By.cssSelector("td:nth-child(4) input")).click();
                }
            }
            break;
        }
    }

    public void showAccessSecurityReportTypeOptions() {
        List<WebElement> allVisibleTabs = driver.findElements(By.cssSelector("app-scheduled-report-edit-card"));

        for (WebElement row : allVisibleTabs) {
            if (row.findElement(By.cssSelector("h3")).getText().equals("Access Security")) {
                row.findElement(By.cssSelector("lk-card-arrow")).click();
                break;
            }
        }
    }

    public void selectInspectionFailuresNotifications(boolean website, boolean email) {
        if(website){
            driver.findElement(By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(2) input")).click();
        }
        if(email){
            driver.findElement(By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(3) input")).click();
        }
    }

    public void selectEmergencyModeNotification(boolean website, boolean email) {
        if(website){
            driver.findElement(By.cssSelector("tbody>tr:nth-child(2)>td:nth-child(2) input")).click();
        }
        if(email){
            driver.findElement(By.cssSelector("tbody>tr:nth-child(2)>td:nth-child(3) input")).click();
        }
    }

    public void validateUserDetailsInSummary(User user) {
        //verify First Name
        //verify MiddleName
        //verify LastName

        //verify Employee Number

        //veify Unit of Measure

    }
}
