package screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement loginPageTitle_id;
    @FindBy(id = "login-email")
    WebElement emailField_id;

    @FindBy(id = "login-password")
    WebElement passwordField_id;

    @FindBy(id = "login-submit")
    WebElement loginButton_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(loginPageTitle_id));
        loginPageTitle_id.isDisplayed();
    }

    public void enterEmailAddress(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loginPageTitle_id));
        emailField_id.click();
        emailField_id.sendKeys(email);

    }

    public void enterPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loginPageTitle_id));
        passwordField_id.sendKeys(password);
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loginPageTitle_id));
        loginButton_id.click();
    }

    public void clearPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(passwordField_id));
        passwordField_id.clear();
    }

    public void loginFailedAcceptLoginAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void missingRequiredFieldsAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
