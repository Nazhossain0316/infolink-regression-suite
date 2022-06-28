package services.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import services.pages.ImpactMeterPage;
import services.pages.LandingPage;
import services.pages.LoginPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;

public class ImpactMeterTests extends TestBase {

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

    @Test()
    public void verifyGridColumnsAreAllVisible() {
        //Sign in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userEmail, userPassword);

        //Click on Impact Meter Tile
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickTileByVisibleText("Impact Meter");

        //Click Alarms from the TopNav
        ImpactMeterPage impactMeterPage = new ImpactMeterPage(driver);
        impactMeterPage.clickOnAlarms();

        //Validate grid columns are all visible
        List<String> expectColumnValues = Arrays.asList(
                "Status",
                "Closed By",
                "Category",
                "Equipment (Serial)",
                "Operator",
                "Location",
                "Front to Back",
                "Side to Side",
                "Impulse",
                "Impact Sensor",
                "Impact Date",
                "Comments",
                "Access Point"
        );

        List<String> actualColumnValues = impactMeterPage.getListOfVisibleColumnNames();

        for (String expectedItem : actualColumnValues) {
            assertTrue(actualColumnValues.contains(expectedItem), expectedItem + " column was not found");
        }
    }

    @Test()
    public void searchOperatorInAlarm(){
        //Login to infolink
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userEmail,userPassword);

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickTileByVisibleText("Impact Meter");

        ImpactMeterPage impactMeterPage = new ImpactMeterPage(driver);
        impactMeterPage.clickOnAlarms();

        String searchTerm = "Test";
        impactMeterPage.searchTerm(searchTerm);

        int rowNumber = 1;
        String visibleText =  impactMeterPage.getRowText(rowNumber);

        assertTrue(visibleText.contains(searchTerm),
                "The search term did not show '"+searchTerm+"'");
    }
}
