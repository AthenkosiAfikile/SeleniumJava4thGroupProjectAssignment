package ndosiTest;

import screens.*;
import utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.TakesScreenshots;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    HomePage homePage= PageFactory.initElements(driver,HomePage.class);
    LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
    LandingPage landingPage= PageFactory.initElements(driver, LandingPage.class);
    RegistrationPage registrationPage= PageFactory.initElements(driver, RegistrationPage.class);
    WebAutomationAdvancePage webAutomationAdvPage= PageFactory.initElements(driver, WebAutomationAdvancePage.class);
    ExtrasAndPricingPage extrasAndPricing= PageFactory.initElements(driver, ExtrasAndPricingPage.class);
    AddToCartPage addToCart = PageFactory.initElements(driver, AddToCartPage.class);
    Add2ndItemToCartPage add2ndItem = PageFactory.initElements(driver, Add2ndItemToCartPage.class);
    ReviewCartPage reviewCartPage = PageFactory.initElements(driver, ReviewCartPage.class);
    TakesScreenshots takesScreenshots = new TakesScreenshots();

}
