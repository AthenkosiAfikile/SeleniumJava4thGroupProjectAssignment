package screens;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LandingPage {
    WebDriver driver;

    @FindBy(id = "practice-heading")
    WebElement landingPageTitle_id;
    @FindBy(id = "logout-button")
    WebElement logoutButton_id;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLandingPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(landingPageTitle_id));
        landingPageTitle_id.isDisplayed();
    }

    public void verifyHeadingHaveUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(landingPageTitle_id));
        String headingText = landingPageTitle_id.getText();
        Assert.assertTrue(headingText.contains(username), "Heading does not contain the expected username.");
    }

    public void clickLogoutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(logoutButton_id));
        logoutButton_id.click();
    }



}

