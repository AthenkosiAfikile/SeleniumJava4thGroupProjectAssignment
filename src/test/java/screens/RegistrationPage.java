package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegistrationPage {
    WebDriver driver;

    @FindBy(id = "register-firstName")
    WebElement firstNameField_id;
    @FindBy(id = "register-lastName")
    WebElement lastNameField_id;
    @FindBy(id = "register-email")
    WebElement emailField_id;
    @FindBy(id = "register-password")
    WebElement passwordField_id;
    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordField_id;
    @FindBy(id = "register-submit")
    WebElement registerButton_id;
    @FindBy(id = "signup-toggle")
    WebElement signUpLink_id;
    @FindBy(id = "registration-heading")
    WebElement registrationPageTitle_id;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignUpLink() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(signUpLink_id));
        signUpLink_id.click();
    }

    public void verifyRegistrationPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(registrationPageTitle_id));
        registrationPageTitle_id.isDisplayed();
    }

    public void enterFirstName(String firstName) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(firstNameField_id));
        firstNameField_id.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(lastNameField_id));
        lastNameField_id.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(emailField_id));
        emailField_id.clear();
        emailField_id.sendKeys(email);
    }

    public void BadEmailFormatAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void enterPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(passwordField_id));
        passwordField_id.clear();
        passwordField_id.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(confirmPasswordField_id));
        confirmPasswordField_id.clear();
        confirmPasswordField_id.sendKeys(confirmPassword);
    }

    public void PasswordAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void PasswordMismatchAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(registerButton_id));
        registerButton_id.click();
    }

    public void SuccessfulRegistrationAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
