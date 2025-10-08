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

    @FindBy(id= "deviceType")
    WebElement deviceType_id;
    @FindBy(id= "brand")
    WebElement brand_id;



    public WebAutomationAdvancePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickWebAutomationAdvanceTab() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOf(webAutomationAdvanceTab_id));
        webAutomationAdvanceTab_id.click();
    }
    public void selectDeviceTypeIfBrandNotClickable(String deviceType) {

        if (isElementClickable(brand_id)) {
            throw new AssertionError("Test failed: brand_id is clickable.");
        } else {
            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOf(deviceType_id));
            deviceType_id.sendKeys(deviceType);
        }
    }

    private boolean isElementClickable(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void selectBrand(String brand) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOf(brand_id));
        brand_id.sendKeys(brand);
    }


}
