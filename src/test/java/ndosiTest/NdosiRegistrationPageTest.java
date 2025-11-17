package ndosiTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NdosiRegistrationPageTest extends Base {

    @Test
    public void verifyHomePageIsDisplayedTests() {
        homePage.verifyHomePageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Home Page");
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTests")
    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterial();
        takesScreenshots.takesSnapShot(driver, "Learning Material Page");
    }

    @Test(dependsOnMethods = "clickLearningMaterialTests")
    public void verifyLoginPageIsDisplayedTests() {
        loginPage.verifyLoginPageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Login Page");
    }
    @Test(dependsOnMethods = "verifyLoginPageIsDisplayedTests")
    public void BadEmailFormatAlertTest(){
        registrationPage.clickSignUpLink();
        registrationPage.verifyRegistrationPageIsDisplayed();
        registrationPage.enterFirstName("Test");
        registrationPage.enterLastName("User");
        registrationPage.enterEmail("user@gmail"); // Bad email format
        registrationPage.enterPassword("Test@123");
        registrationPage.enterConfirmPassword("Test@123");
        registrationPage.clickRegisterButton();
        registrationPage.BadEmailFormatAlert();
        takesScreenshots.takesSnapShot(driver, "Bad Email Format Alert");

    }
    @Test(dependsOnMethods = "BadEmailFormatAlertTest")
    public void PasswordAlertTest(){
        registrationPage.enterEmail("user@gmail.com");
        registrationPage.enterPassword("");
        registrationPage.enterConfirmPassword("112323");
        registrationPage.clickRegisterButton();
        registrationPage.PasswordAlert();
        takesScreenshots.takesSnapShot(driver, "Password Alert");
    }
    @Test(dependsOnMethods = "PasswordAlertTest")
    public void PasswordMismatchAlertTest(){
        registrationPage.enterPassword("Test@1234");
        registrationPage.enterConfirmPassword("Test@1");
        registrationPage.clickRegisterButton();
        registrationPage.PasswordMismatchAlert();
        takesScreenshots.takesSnapShot(driver, "Password Mismatch Alert");
    }
    @Test(dependsOnMethods = "PasswordMismatchAlertTest")
    public void successfulRegistrationTest(){
        registrationPage.enterConfirmPassword("Test@1234");
        registrationPage.clickRegisterButton();
        registrationPage.SuccessfulRegistrationAlert();
        takesScreenshots.takesSnapShot(driver, "Successful Registration");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
