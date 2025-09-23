package ndosiTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

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
        enterEmailAddressTests();
        enterPasswordTests();
        takesScreenshots.takesSnapShot(driver, "Login Page with Email and Password");
    }

    @Test(dependsOnMethods = "enterEmailAddressWithPasswordAfterCleanTest")
    public void clickLoginButtonAfterCleanEmailFieldTests() {
        loginPage.clickLoginButton();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}