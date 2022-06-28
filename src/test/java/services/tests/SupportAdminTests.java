package services.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import services.pages.LandingPage;
import services.pages.LoginPage;
import services.pages.SupportAdminPage;

import java.util.concurrent.TimeUnit;

public class SupportAdminTests extends TestBase {

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
    public void addNewTruckTest(){
        //Login to infolink
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userEmail,userPassword);

        //click on Support Admin
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickTileByVisibleText("Support Admin");

        //CLick on the Add Trucks button
        SupportAdminPage supportAdminPage = new SupportAdminPage(driver);
        supportAdminPage.clickOnAddTruckButton();

        //fill in form
        supportAdminPage.typeInManufacturerField("Crown Equipment Corporation");
        supportAdminPage.typeInTruckSerialNumber("1234567890");
        supportAdminPage.typeInTruckName("AwesomeTruck");

        supportAdminPage.selectTruckNameByIndex(0);
        supportAdminPage.selectTruckYear("2016");
        supportAdminPage.selectCustomerByIndex(0);


    }


}
