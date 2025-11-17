package ndosiTest;

import extentReport.Listener;
import org.testng.annotations.*;

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
        loginPage.enterEmailAddress("breakathi@gmail.com");
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
    }

    @Test(dependsOnMethods = "acceptLoginAlertTest")
    public void enterPasswordTests() {
        loginPage.clearPassword();
        loginPage.enterPassword("!Athenkosi2001");
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
        landingPage.verifyHeadingHaveUsername("Athenkosi");
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
    }

    @Test(dependsOnMethods = "clickWebAutomationAdvButtonTests")
    public void selectDeviceTypeIfBrandNotClickableTests() {
        webAutomationAdvPage.selectDeviceTypeIfBrandNotClickable("Phone");
    }

    @Test(dependsOnMethods = "selectDeviceTypeIfBrandNotClickableTests")
    public void selectBrandTests() {
        webAutomationAdvPage.selectBrand("Apple");
    }

    @Test(dependsOnMethods = "selectBrandTests")
    public void testStorageSelectionAndNextButtonState() {
        webAutomationAdvPage.selectStorage("128GB");
    }

    @Test(dependsOnMethods = "testStorageSelectionAndNextButtonState")
    public void testColorSelectionDoesNotEnableNextButton() {
        webAutomationAdvPage.selectColor("Black");
    }

    @Test(dependsOnMethods = "testColorSelectionDoesNotEnableNextButton")
    public void testQuantityValidationAndNextButtonState() {
        webAutomationAdvPage.enterQuantity("2");
    }

    @Test(dependsOnMethods = "testQuantityValidationAndNextButtonState")
    public void enterAddressTests() {
        webAutomationAdvPage.enterAddress("123 Test St, Test City");
    }

    @Test(dependsOnMethods = "enterAddressTests")
    public void extractUnitPriceTests() {
        webAutomationAdvPage.extractUnitPrice();
    }

    @Test(dependsOnMethods = "extractUnitPriceTests")
    public void clickNextButtonTests() {
        webAutomationAdvPage.clickNextButton();
    }

    @Test(dependsOnMethods = "clickNextButtonTests")
    public void verifyExtrasAndPricingPageIsDisplayedTests() {
        extrasAndPricing.selectExpressShippingOption();
    }

    @Test(dependsOnMethods = "verifyExtrasAndPricingPageIsDisplayedTests")
    public void selectOneYearWarrantyOptionTests() {
        extrasAndPricing.selectOneYearWarrantyOption();
    }

    @Test(dependsOnMethods = "selectOneYearWarrantyOptionTests")
    public void enterDiscountCodeTests() {
        extrasAndPricing.enterDiscountCode("SAVE10");
    }

    @Test(dependsOnMethods = "enterDiscountCodeTests")
    public void clickApplyDiscountButtonTests() {
        extrasAndPricing.clickApplyDiscountButton();
    }

    @Test(dependsOnMethods = "clickApplyDiscountButtonTests")
    public void verifyDiscountAppliedTests() {
        extrasAndPricing.verifyDiscountApplied();
    }

    @Test(dependsOnMethods = "verifyDiscountAppliedTests")
    public void clickBackToInventoryButtonTests() {
        extrasAndPricing.clickBackToInventoryButton();
        webAutomationAdvPage.clickNextButton();
    }
    @Test(dependsOnMethods = "clickBackToInventoryButtonTests")
    public void addToCartTests() {
        addToCart.clickAddToCartButton();
    }
    @Test(dependsOnMethods = "addToCartTests")
    public void verifyItemAddedToCartTests() {
        addToCart.verifyItemAddedToCart();
    }

//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}