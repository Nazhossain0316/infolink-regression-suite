package services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTileByVisibleText(String visibleText) {
        //Get list of visible tiles
        List<WebElement> tiles = driver.findElements(By.cssSelector("div.icon-cards>div.icon-card--wrapper>div[role='button']"));
        List<WebElement> desiredButton = new ArrayList<>();

        //Check to see which button corresponds with the visibleText argument
        for (WebElement singleTile : tiles) {
            if (singleTile.findElement(By.cssSelector("div.icon-card-title")).getText().toUpperCase().contains(visibleText.toUpperCase())) {
                desiredButton.add(singleTile);
                break;
            }
        }

        //Click the tile if it's present; show console warning if not present
        if (desiredButton.size() < 1) {
            System.out.println("\nThe tile '" + visibleText + "' could not be found on the Landing page!");
        } else {
            desiredButton.get(0).click();
        }
    }
}
