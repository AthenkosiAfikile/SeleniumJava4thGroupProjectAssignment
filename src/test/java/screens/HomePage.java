package screens;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "overview-section")
    WebElement homePageTitle_id;

    @FindBy(id = "nav-btn-practice")
    WebElement learningMaterialButton_id;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyHomePageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(homePageTitle_id));
        homePageTitle_id.isDisplayed();
    }

    public void clickLearningMaterial() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(homePageTitle_id));
        learningMaterialButton_id.click();
    }


}
