package screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ExtrasAndPricing {
    WebDriver driver;

    @FindBy(id = "shipping-option-express")
    WebElement expressShippingOption_id;
    @FindBy(id = "warranty-1yr")
    WebElement oneYearWarrantyOption_id;
    @FindBy(id = "discount-code")
    WebElement discountCodeField_id;

    public ExtrasAndPricing(WebDriver driver) {
        this.driver = driver;
    }

    public void selectExpressShippingOption() {
        expressShippingOption_id.click();
    }

    public void selectOneYearWarrantyOption() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", oneYearWarrantyOption_id);

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(oneYearWarrantyOption_id));
        oneYearWarrantyOption_id.click();
    }

    public void enterDiscountCode(String code) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", discountCodeField_id);
        discountCodeField_id.sendKeys(code);
    }

}
