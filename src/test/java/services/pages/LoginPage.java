package services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    By emailInputField = By.id("username");
    By passwordInputField = By.id("password");
    By nextButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void fillInEmailAddress(String emailAddress) {
        WebElement inputField = driver.findElement(emailInputField);
        inputField.sendKeys(emailAddress);
    }

    public void fillInPasswordField(String password) {
        WebElement inputField = driver.findElement(passwordInputField);
        inputField.sendKeys(password);
    }
    public void clickNextBtn() {
        WebElement nextBtn = driver.findElement(nextButton);
        nextBtn.click();
    }

    public void logIn(String userEmail, String userPassword) {
        fillInEmailAddress(userEmail);
        clickNextBtn();
        fillInPasswordField(userPassword);
        clickNextBtn();
    }
}
