package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebAutomationAdvancePage {
    WebDriver driver;

    @FindBy(id= "tab-btn-web")
    WebElement webAutomationAdvanceTab_id;

    public WebAutomationAdvancePage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyWebAutomationAdvancePageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOf(webAutomationAdvanceTab_id));
        webAutomationAdvanceTab_id.isDisplayed();
        webAutomationAdvanceTab_id.click();
    }
    public void selectDevice(){

    }
}
