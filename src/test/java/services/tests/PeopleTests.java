package services.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import services.pages.LandingPage;
import services.pages.LoginPage;
import services.pages.PeoplePage;
import services.utilities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PeopleTests extends TestBase{

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void teardown() {
        if(driver!=null){
            driver.quit();
        }
    }

    @Test
    public void addNewUserToPeople(){
        //Sign in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userEmail, userPassword);

        //Click on People Tile
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickTileByVisibleText("People");

        PeoplePage peoplePage = new PeoplePage(driver);

        //Create a new User
        User user = new User(
                User.WEB_USER,
                "John",
                "Middlename",
                "Smith",
                "45242",
                "English (United States)",
                "UTC -04:00 America/New_York (EDT)",
                User.IMPERIAL);

        peoplePage.clickAddUserButton();
        peoplePage.selectUserTypeRadioButton(user.getUserType());
        peoplePage.clickNextButton();
        peoplePage.fillInUserDetails(user);
        peoplePage.clickNextButton();

        String assignedLocation = "NZ";
        peoplePage.searchAssignedLocation(assignedLocation);

        String locationNameToSelect="Foodstuffs Field Test Site";
        peoplePage.selectLocationByName(locationNameToSelect);
        peoplePage.clickNextButton();

        //insert email.address
        String userEmailAddress = "automation@email.com";
        peoplePage.insertEmailAddress(userEmailAddress);

        String webRole = "Sales Support";
        peoplePage.selectWebRole(webRole);

        ArrayList<String> applicationsToGrantAccess = new ArrayList<>();
        applicationsToGrantAccess.add("Access Security");
        applicationsToGrantAccess.add("Crown Digital Toolbox");

        peoplePage.selectApplicationCheckBoxes(applicationsToGrantAccess);
        peoplePage.clickNextButton();

        peoplePage.showAccessSecurityReportTypeOptions();
        peoplePage.fillAccessSecurityReportTypes("Emergency Mode Usage", "DY");
        peoplePage.fillAccessSecurityReportTypes("Inspection History", "M");

        peoplePage.clickNextButton();

        peoplePage.selectInspectionFailuresNotifications(true, false);
        peoplePage.selectEmergencyModeNotification(false, true);

        peoplePage.clickNextButton();
        peoplePage.validateUserDetailsInSummary(user);
    }

}
