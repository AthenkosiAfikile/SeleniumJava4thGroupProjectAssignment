package ndosiTest;

import screens.HomePage;
import screens.LandingPage;
import screens.LoginPage;
import screens.RegistrationPage;
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
    TakesScreenshots takesScreenshots = new TakesScreenshots();

}
