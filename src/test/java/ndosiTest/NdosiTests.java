package ndosiTest;

import extentReport.Listener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.LoginPage;


@Listeners(Listener.class)
public class NdosiTests extends Base {

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
    public void enterEmailAddressTests() {
        loginPage.enterEmailAddress("aab@ndosi.com");
    }

    @Test(dependsOnMethods = "enterEmailAddressTests")
    public void incorrectPasswordTest() {
        loginPage.enterPassword("123");
        takesScreenshots.takesSnapShot(driver, "Login Page with Incorrect Password");
    }

    @Test(dependsOnMethods = "incorrectPasswordTest")
    public void clickLoginWithInvalidInvalidPasswordTest() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginWithInvalidInvalidPasswordTest")
    public void acceptLoginAlertTest() {
        loginPage.loginFailedAcceptLoginAlert();
        takesScreenshots.takesSnapShot(driver, "Login Alert Accepted");
    }

    @Test(dependsOnMethods = "acceptLoginAlertTest")
    public void clearPasswordTest() {
        loginPage.clearPassword();
    }

    @Test(dependsOnMethods = "clearPasswordTest")
    public void enterPasswordTests() {
        loginPage.enterPassword("1234567890");
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void missingRequiredFieldsAlert() {
        loginPage.missingRequiredFieldsAlert();
        takesScreenshots.takesSnapShot(driver, "Missing Required Fields Alert Accepted");
    }

    @Test(dependsOnMethods = "missingRequiredFieldsAlert")
    public void enterEmailAddressWithPasswordAfterCleanTest() {
        enterPasswordTests();
        takesScreenshots.takesSnapShot(driver, "Login Page with Email and Password");
    }

    @Test(dependsOnMethods = "enterEmailAddressWithPasswordAfterCleanTest")
    public void clickLoginButtonAfterCleanEmailFieldTests() {
        loginPage.clickLoginButton();
    }
    @Test(dependsOnMethods = "clickLoginButtonAfterCleanEmailFieldTests")
    public void invalidCredentialsAlertTest() {
        loginPage.InvalidCredentialsAlert();
        takesScreenshots.takesSnapShot(driver, "Invalid Credentials Alert Accepted");
    }
    @Test(dependsOnMethods = "invalidCredentialsAlertTest")
    public void cleanEmailFieldTest() {
        loginPage.clearEmailTextField();
        loginPage.enterEmailAddress("testuser");
    }
    @Test(dependsOnMethods = "cleanEmailFieldTest")
    public void enterPasswordAfterCleanEmailFieldTest() {
        loginPage.enterPassword("password123");
        takesScreenshots.takesSnapShot(driver, "Login Page with Corrected Email and Password");
    }
    @Test(dependsOnMethods = "enterPasswordAfterCleanEmailFieldTest")
    public void clickLoginButtonWithCorrectedCredentialsTests() {
        loginPage.clickLoginButton();
    }
    @Test(dependsOnMethods = "clickLoginButtonWithCorrectedCredentialsTests")
    public void verifyLandingPageIsDisplayedTests() {
        landingPage.verifyLandingPageIsDisplayed();
    }
    @Test(dependsOnMethods = "verifyLandingPageIsDisplayedTests")
    public void verifyHeadingHaveUsernameTests() {
        landingPage.verifyHeadingHaveUsername("Test");
        takesScreenshots.takesSnapShot(driver, "Landing Page with Username");
    }
    @Test(dependsOnMethods = "verifyHeadingHaveUsernameTests")
    public void clickLogoutButtonTests() {
        landingPage.clickLogoutButton();
        takesScreenshots.takesSnapShot(driver, "Logged Out and Back to Home Page");
    }

    @Test(dependsOnMethods = "clickLogoutButtonTests")
    public void logInAgainTests() {
        loginPage.verifyLoginPageIsDisplayed();
        loginPage.enterEmailAddress("testuser");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        takesScreenshots.takesSnapShot(driver, "Navigated Back to Login Page");
    }

//    @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }
}