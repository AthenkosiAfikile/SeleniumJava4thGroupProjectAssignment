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
        loginPage.enterEmailAddress("makes@gmail.com");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}