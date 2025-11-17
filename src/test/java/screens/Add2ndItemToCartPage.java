package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Add2ndItemToCartPage {
    WebDriver driver;
    public static String stringUnitPriceText;
    public static String UnitPriceWithout_R;
    public static String ActualQuantityText;
    public static String stringActualSubtotalWith_R;
    public static String ActualSubtotalWithout_R;
    public static Double unitPrice;
    public static Double ExpectedSubtotal;
    static int quantity;

    @FindBy(id = "tab-btn-web")
    WebElement webAutomationAdvanceTab_id;
    @FindBy(id = "deviceType")
    WebElement deviceType_id;
    @FindBy(id = "brand")
    WebElement brand_id;
    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue_id;
    @FindBy(id = "subtotal-value")
    WebElement subtotalValue_id;
    @FindBy(id = "storage-64GB")
    WebElement storage_id;
    @FindBy(id = "storage-128GB")
    WebElement storage128GB_id;
    @FindBy(id = "storage-256GB")
    WebElement storage256GB_id;
    @FindBy(id = "color")
    WebElement colorDropdown_id;
    @FindBy(id = "quantity")
    WebElement quantity_id;
    @FindBy(id = "address")
    WebElement address_id;
    @FindBy(id = "review-cart-btn")
    WebElement reviewCartButton_id;
    @FindBy(id = "cart-item-remove-1763419470235.1038")
    WebElement remove2ndItem_id;

    public Add2ndItemToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDeviceFor2ndPhone(String deviceType) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(deviceType_id));
        deviceType_id.sendKeys(deviceType);
    }

    public void selectBrandFor2ndPhone(String brand) {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(brand_id));
        brand_id.sendKeys(brand);
    }

    public void selectStorageFor2ndPhone(String storageOption) {
        switch (storageOption) {
            case "64GB" -> {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOf(storage_id));
                storage_id.click();
            }
            case "128GB" -> {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOf(storage128GB_id));
                storage128GB_id.click();
            }
            case "256GB" -> {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOf(storage256GB_id));
                storage256GB_id.click();
            }
            default -> throw new IllegalArgumentException("Invalid storage option: " + storageOption);
        }
    }

    public void selectColorFor2ndPhone(String color) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(colorDropdown_id));

        Select colorSelect = new Select(colorDropdown_id);
        colorSelect.selectByVisibleText(color);
    }

    public void enterQuantityFor2ndPhone(String quantity) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(quantity_id));
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
    }

    public void enterAddressFor2ndPhone(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(address_id));
        address_id.sendKeys(address);
    }

    public void extractUnitPriceFor2ndPhone() {

        stringUnitPriceText = unitPriceValue_id.getText();
        System.out.println("Unit price with R: " + stringUnitPriceText);

        UnitPriceWithout_R = stringUnitPriceText.replace("R", "");
        System.out.println("Unit price without R: " + UnitPriceWithout_R);

        unitPrice = Double.parseDouble(UnitPriceWithout_R);
        System.out.println("Unit price " + unitPrice);

        ActualQuantityText = quantity_id.getAttribute("value");
        System.out.println("Quantity Text: " + ActualQuantityText);

        quantity = Integer.parseInt(ActualQuantityText);
        System.out.println("Quantity value: " + quantity);

        ExpectedSubtotal = unitPrice * quantity;
        System.out.println("Expected subtotal (Unit Price x Quantity value): " + ExpectedSubtotal);

        stringActualSubtotalWith_R = subtotalValue_id.getText();
        System.out.println("Actual subtotal with R: " + stringActualSubtotalWith_R);

        ActualSubtotalWithout_R = stringActualSubtotalWith_R.replace("R", " ");
        System.out.println("Actual subtotal without R: " + ActualSubtotalWithout_R);

        Double actualSubtotal = Double.parseDouble(ActualSubtotalWithout_R);
        System.out.println("Actual subtotal: " + actualSubtotal);

        Assert.assertEquals(ExpectedSubtotal, actualSubtotal,
                "Actual subtotal does not match expected subtotal.");

    }
    public void clickReviewCartButton() {
        reviewCartButton_id.click();
    }
}
