package screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static screens.WebAutomationAdvancePage.*;


public class ExtrasAndPricing {
    WebDriver driver;

    String getStringWarrantyPriceWith_R;
    String stringWarrantyPriceWithout_R;
    String stringShippingPriceStringWith_R;
    String stringTotalPriceString;
    String stringTotalPriceWithout_R;

    static Double expectedTotalPrice;
    static Double actualTotalPrice;
    static Double warrantyPrice;
    static Double shippingPrice;
    static Double finalDevicePrice;
    static Double discount;

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
    @FindBy(id = "breakdown-warranty-value")
    WebElement breakdownWarrantyValue_id;
    @FindBy(id = "breakdown-shipping-value")
    WebElement breakdownShippingValue_id;

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

        getStringWarrantyPriceWith_R = breakdownWarrantyValue_id.getText();
        System.out.println("Warranty price with R: " +getStringWarrantyPriceWith_R);

        stringWarrantyPriceWithout_R = getStringWarrantyPriceWith_R.replace("R", "");
        System.out.println("Warranty price without R: " +stringWarrantyPriceWithout_R);

        warrantyPrice = Double.parseDouble(stringWarrantyPriceWithout_R);
        System.out.println("Warranty price value:" + warrantyPrice);

        stringShippingPriceStringWith_R = breakdownShippingValue_id.getText();
        System.out.println("Shipping price with R: " + stringShippingPriceStringWith_R);

        String stringShippingPriceWithout_R = stringShippingPriceStringWith_R.replace("R", "");
        System.out.println("Shipping price without R: " + stringShippingPriceWithout_R);

        shippingPrice = Double.parseDouble(stringShippingPriceWithout_R);
        System.out.println("Shipping price value: " + shippingPrice);

        finalDevicePrice = ExpectedSubtotal + warrantyPrice + shippingPrice;
        System.out.println("Final device price (warrantyPrice + shippingPrice) without discount: " + finalDevicePrice);

        discount = finalDevicePrice * 0.1;
        System.out.println("Discount: " + discount);

        expectedTotalPrice = finalDevicePrice - discount;
        System.out.println("Expected Total price with a discount: " + expectedTotalPrice);

        stringTotalPriceString = breakdownTotalValue_id.getText();
        System.out.println("Total price from breakdown with R: " + stringTotalPriceString);

        stringTotalPriceWithout_R = stringTotalPriceString.replace("R", "");
        System.out.println("Total price from breakdown without R: " + stringTotalPriceWithout_R);

        actualTotalPrice = Double.parseDouble(stringTotalPriceWithout_R);
        System.out.println("Actual Total price from breakdown: " + actualTotalPrice);

        Assert.assertEquals(expectedTotalPrice, actualTotalPrice,
                "Total price after discount does not match expected total price.");

    }

    public void clickBackToInventoryButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(backToInventoryButton_id));
        backToInventoryButton_id.click();
    }

}
