package services.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties props;
    public static String baseUrl;
    public static String userEmail;
    public static String userPassword;

    @BeforeClass
    public static void setProps() {
        ConfigReader();
        if(props.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        }
        baseUrl = props.getProperty("baseUrl");
        userEmail = props.getProperty("userEmail");
        userPassword = props.getProperty("userPassword");
    }

    public static void ConfigReader() {
        try {
            File src = new File(System.getProperty("user.dir") + "/src/test/resources/"+System.getProperty("env")+".properties");
            FileInputStream fis = new FileInputStream(src);
            props = new Properties();
            props.load(fis);
            System.out.println("Property class loaded");
        } catch (Exception e) {
            System.out.println("Exception is" + e.getMessage());
        }
    }


    @AfterClass
    public static void closeApplication()
    {
        driver.quit();
    }
}
