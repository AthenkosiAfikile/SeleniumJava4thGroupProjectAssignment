package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement loginPageTitle_id;
    @FindBy(id = "login-email")
    WebElement emailField_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(loginPageTitle_id));
        loginPageTitle_id.isDisplayed();
    }

    public void enterEmailAddress(String email) {
        emailField_id.sendKeys(email);

    }

}

