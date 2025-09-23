package ndosiTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NdosiTests extends Base {

    @Test
    public void verifyHomePageIsDisplayedTests() {
        homePage.verifyHomePageIsDisplayed();
//        takesScreenshots.takesSnapShot(driver, "Home Page");
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTests")
    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterial();
    }

    @Test(dependsOnMethods = "clickLearningMaterialTests")
    public void verifyLoginPageIsDisplayedTests() {
        loginPage.verifyLoginPageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyLoginPageIsDisplayedTests")
    public void enterEmailAddressTests() {
        loginPage.enterEmailAddress("aab@ndosi.com");
    }

    @Test(dependsOnMethods = "enterEmailAddressTests")
    public void incorrectPasswordTest() {
        loginPage.enterPassword("123");
    }

    @Test(dependsOnMethods = "incorrectPasswordTest")
    public void clickLoginWithInvalidInvalidPasswordTest() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginWithInvalidInvalidPasswordTest")
    public void acceptLoginAlertTest() {
        loginPage.loginFailedAcceptLoginAlert();
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
    }

    @Test(dependsOnMethods = "missingRequiredFieldsAlert")
    public void enterEmailAddressWithPasswordAfterCleanTest() {
        enterEmailAddressTests();
        enterPasswordTests();
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