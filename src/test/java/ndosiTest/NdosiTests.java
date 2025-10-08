package ndosiTest;

import extentReport.Listener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


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
    public void clickLoginWithoutCredentialsTest() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginWithoutCredentialsTest")
    public void missingRequiredFieldsAlert() {
        loginPage.missingRequiredFieldsAlert();
        takesScreenshots.takesSnapShot(driver, "Missing Required Fields Alert Accepted");
    }

    @Test(dependsOnMethods = "missingRequiredFieldsAlert")
    public void enterEmailAddressTests() {
        loginPage.enterEmailAddress("testuser@gmail.com");
    }

    @Test(dependsOnMethods = "enterEmailAddressTests")
    public void incorrectPasswordTest() {
        loginPage.enterPassword("123");
        takesScreenshots.takesSnapShot(driver, "Login Page with Incorrect Password");
    }

    @Test(dependsOnMethods = "incorrectPasswordTest")
    public void clickLoginWithInvalidPasswordTest() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginWithInvalidPasswordTest")
    public void acceptLoginAlertTest() {
        loginPage.loginFailedAcceptLoginAlert();
        takesScreenshots.takesSnapShot(driver, "Login Alert Accepted");
    }

    @Test(dependsOnMethods = "acceptLoginAlertTest")
    public void enterPasswordTests() {
        loginPage.clearPassword();
        loginPage.enterPassword("Test@1234");
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyLandingPageIsDisplayedTests() {
        landingPage.verifyLandingPageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Landing Page");
    }
    @Test(dependsOnMethods = "verifyLandingPageIsDisplayedTests")
    public void verifyHeadingHaveUsernameTests() {
        landingPage.verifyHeadingHaveUsername("Test");
        takesScreenshots.takesSnapShot(driver, "Heading with Username");
    }
    @Test(dependsOnMethods = "verifyHeadingHaveUsernameTests")
    public void clickLogoutButtonTests() {
        landingPage.clickLogoutButton();
    }
    @Test(dependsOnMethods = "clickLogoutButtonTests")
    public void verifyLoginPageIsDisplayedAfterLogoutTests() {
        loginPage.verifyLoginPageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Login Page After Logout");
    }
    @Test(dependsOnMethods = "verifyLoginPageIsDisplayedAfterLogoutTests")
    public void loginAgainWithCredentialsTest() {
        enterEmailAddressTests();
        enterPasswordTests();
        clickLoginButtonTests();
        verifyLandingPageIsDisplayedTests();
    }
    @Test(dependsOnMethods = "loginAgainWithCredentialsTest")
    public void clickWebAutomationAdvButtonTests() {
        webAutomationAdvPage.clickWebAutomationAdvanceTab();
        takesScreenshots.takesSnapShot(driver, "Web Automation Adv Page");
    }
    @Test(dependsOnMethods = "clickWebAutomationAdvButtonTests")
    public void selectDeviceTypeIfBrandNotClickableTests() {
        webAutomationAdvPage.selectDeviceTypeIfBrandNotClickable("Laptop");
        takesScreenshots.takesSnapShot(driver, "Device Type Selected");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}