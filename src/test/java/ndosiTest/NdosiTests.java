package ndosiTest;

import extentReport.Listener;
import org.junit.jupiter.api.Assertions;
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
        webAutomationAdvPage.selectDeviceTypeIfBrandNotClickable("Phone");
        takesScreenshots.takesSnapShot(driver, "Device Type Selected");
    }

    @Test(dependsOnMethods = "selectDeviceTypeIfBrandNotClickableTests")
    public void selectBrandTests() {
        webAutomationAdvPage.selectBrand("Apple");
        takesScreenshots.takesSnapShot(driver, "Brand Selected");
    }

    @Test(dependsOnMethods = "selectBrandTests")
    public void selectStorageTests() {
        webAutomationAdvPage.selectStorage("128GB");
        takesScreenshots.takesSnapShot(driver, "Storage Selected");
    }
    @Test(dependsOnMethods = "selectStorageTests")
    public void testColorSelectionDoesNotEnableNextButton() {

        if (webAutomationAdvPage.isColorFieldEmpty()) {
            Assertions.assertFalse(webAutomationAdvPage.isNextButtonClickable(),
                    "FAIL: Next button should NOT be clickable when Color is empty.");

            System.out.println("Color is empty. Selecting 'Black'.");
            webAutomationAdvPage.selectColor("White");

            boolean isNextButtonNowClickable = webAutomationAdvPage.isNextButtonClickable();
            Assertions.assertFalse(isNextButtonNowClickable,
                    "FAIL: Next button BECAME clickable after only selecting 'Black'. " +
                            "Quantity/Address is likely still missing.");

            System.out.println("Test Passed: Next button is correctly NOT clickable after selecting only color.");

        } else {
            System.out.println("Color field already selected. Skipping test.");
        }
    }

//    @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }
}