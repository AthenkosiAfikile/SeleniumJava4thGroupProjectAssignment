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
        loginPage.enterEmailAddress("user@gmail.com");
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

        boolean isNextButtonNowClickable = webAutomationAdvPage.isNextButtonClickable();
        Assertions.assertFalse(isNextButtonNowClickable,
                "FAIL: Next button BECAME clickable after only selecting storage. " +
                        "Quantity/Color is likely still missing.");

        System.out.println("Test Passed: Next button is correctly NOT clickable after selecting only storage.");
        takesScreenshots.takesSnapShot(driver, "Web Automation Adv Page");
    }

    @Test(dependsOnMethods = "clickWebAutomationAdvButtonTests")
    public void selectDeviceTypeIfBrandNotClickableTests() {
        webAutomationAdvPage.selectDeviceTypeIfBrandNotClickable("Phone");

        boolean isNextButtonNowClickable = webAutomationAdvPage.isNextButtonClickable();
        Assertions.assertFalse(isNextButtonNowClickable,
                "FAIL: Next button BECAME clickable after only selecting storage. " +
                        "Quantity/Color is likely still missing.");

        System.out.println("Test Passed: Next button is correctly NOT clickable after selecting only storage.");
        takesScreenshots.takesSnapShot(driver, "Device Type Selected");
    }

    @Test(dependsOnMethods = "selectDeviceTypeIfBrandNotClickableTests")
    public void selectBrandTests() {
        webAutomationAdvPage.selectBrand("Apple");

        boolean isNextButtonNowClickable = webAutomationAdvPage.isNextButtonClickable();
        Assertions.assertFalse(isNextButtonNowClickable,
                "FAIL: Next button BECAME clickable after only selecting Brand. " +
                        "Quantity/Color is likely still missing.");

        System.out.println("Test Passed: Next button is correctly NOT clickable after selecting only storage.");
        takesScreenshots.takesSnapShot(driver, "Brand Selected");
    }

    @Test(dependsOnMethods = "selectBrandTests")
    public void testStorageSelectionAndNextButtonState() {

        final String TARGET_STORAGE = "64GB";

        if (!webAutomationAdvPage.isStorageSelected(TARGET_STORAGE)) {
            Assertions.assertFalse(webAutomationAdvPage.isNextButtonClickable(),
                    "FAIL: Next button should NOT be clickable before selecting storage.");

            System.out.println("Storage " + TARGET_STORAGE + " is not selected. Selecting it now.");
            webAutomationAdvPage.selectStorage(TARGET_STORAGE);
            boolean isNextButtonNowClickable = webAutomationAdvPage.isNextButtonClickable();

            Assertions.assertFalse(isNextButtonNowClickable,
                    "FAIL: Next button BECAME clickable after only selecting storage. " +
                            "Quantity/Color is likely still missing.");

            System.out.println("Test Passed: Next button is correctly NOT clickable after selecting only storage.");

        } else {
            System.out.println("Storage " + TARGET_STORAGE + " already selected. Skipping test.");
        }
    }

    @Test(dependsOnMethods = "testStorageSelectionAndNextButtonState")
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

    @Test(dependsOnMethods = "testColorSelectionDoesNotEnableNextButton")
    public void testQuantityValidationAndNextButtonState() {
        webAutomationAdvPage.getEnteredQuantity();
        Assertions.assertEquals("1", webAutomationAdvPage.getEnteredQuantity(),
                "FAIL: Quantity field is NOT empty on page load.");

        webAutomationAdvPage.enterQuantity("0");
        Assertions.assertFalse(webAutomationAdvPage.isNextButtonClickable(),
                "FAIL: Next button is clickable with Quantity 0 (should be disabled).");
        System.out.println("Test 1 Passed: Next button correctly disabled for Quantity 0.");

        webAutomationAdvPage.enterQuantity("11");
        Assertions.assertFalse(webAutomationAdvPage.isNextButtonClickable(),
                "FAIL: Next button is clickable with Quantity 11 (should be disabled).");
        System.out.println("Test 2 Passed: Next button correctly disabled for Quantity 11.");


        webAutomationAdvPage.enterQuantity("3");
        Assertions.assertFalse(webAutomationAdvPage.isNextButtonClickable(),
                "FAIL: Next button is NOT clickable with valid Quantity 1. All mandatory fields " +
                        "must be filled.");
        System.out.println("Test 3 Passed: Next button correctly enabled for Quantity 3.");
    }

    @Test(dependsOnMethods = "testQuantityValidationAndNextButtonState")
    public void testSubtotalCalculation() {

        final String UNIT = "R400.00";
        final String TEST_QUANTITY = "3";

        final String EXPECTED_SUBTOTAL = webAutomationAdvPage.calculateExpectedSubtotal(UNIT, TEST_QUANTITY);

        System.out.println("Expected Subtotal calculated: " + EXPECTED_SUBTOTAL);

        webAutomationAdvPage.enterQuantity(TEST_QUANTITY);

        String actualSubtotal = webAutomationAdvPage.getSubtotalAmount();
        Assertions.assertEquals(EXPECTED_SUBTOTAL, actualSubtotal,
                "FAIL: Subtotal calculation is incorrect. " +
                        "Expected: " + EXPECTED_SUBTOTAL + ", Actual: " + actualSubtotal);

        System.out.println("Test Passed: Subtotal calculated correctly for Quantity " + TEST_QUANTITY + ".");
    }

    @Test(dependsOnMethods = "testSubtotalCalculation")
    public void enterAddressTests() {
        webAutomationAdvPage.enterAddress("123 Test St, Test City");

        Assertions.assertTrue(webAutomationAdvPage.isNextButtonClickable(),
                "FAIL: Next button is NOW clickable. All mandatory fields " +
                        "are filled.");
        System.out.println("Test Passed: The test to enter the Address passed.");
        takesScreenshots.takesSnapShot(driver, "Address Entered");
    }

    @Test(dependsOnMethods = "enterAddressTests")
    public void clickNextButtonTests() {
        webAutomationAdvPage.clickNextButton();
        System.out.println("Next button clicked to proceed to the next step.");
        takesScreenshots.takesSnapShot(driver, "After Clicking Next Button");
    }

//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}