package screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static screens.WebAutomationAdvancePage.unitPrice;


public class ExtrasAndPricing {
    WebDriver driver;

    @FindBy(id = "shipping-option-express")
    WebElement expressShippingOption_id;
    @FindBy(id = "warranty-1yr")
    WebElement oneYearWarrantyOption_id;
    @FindBy(id = "discount-code")
    WebElement discountCodeField_id;

    @FindBy(id = "inventory-back-btn")
    WebElement backToInventoryButton_id;
    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton_id;
    @FindBy(id = "breakdown-total-value")
    WebElement breakdownTotalValue_id;

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
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", discountCodeField_id);
        discountCodeField_id.sendKeys(code);
    }

    public void clickApplyDiscountButton() {
        applyDiscountButton_id.click();
    }

    public void verifyDiscountApplied() {
        Double discount = unitPrice * 0.1;
        System.out.println("Discount price is: " + discount);

        double discountedUnitPrice = unitPrice - discount;
        System.out.println("Unit price without a discount: " + discountedUnitPrice);

        double totalPrice = Double.parseDouble(breakdownTotalValue_id.getText().replace("$", ""));
        System.out.println("Total price from breakdown: " + totalPrice);


//        Double totalPrice = discountedUnitPrice + 20.0 + 50.0; // shipping + warranty
//        System.out.println("Total price after discount, shipping and warranty: " + totalPrice);
    }

    public void clickBackToInventoryButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(backToInventoryButton_id));
        backToInventoryButton_id.click();
    }

}
