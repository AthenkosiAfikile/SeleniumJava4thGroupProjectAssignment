package screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebAutomationAdvancePage {
    WebDriver driver;
    String stringUnitPriceText;
    String UnitPriceWithout_R;
    String ActualQuantityText;
    String stringActualSubtotalWith_R;
    String ActualSubtotalWithout_R;
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

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton_id;
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

    public WebAutomationAdvancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWebAutomationAdvanceTab() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(webAutomationAdvanceTab_id));
        webAutomationAdvanceTab_id.click();
    }

    public void selectDeviceTypeIfBrandNotClickable(String deviceType) {

        if (isElementClickable()) {
            throw new AssertionError("Test failed: brand_id is clickable.");
        } else {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(deviceType_id));
            deviceType_id.sendKeys(deviceType);
        }
    }

    private boolean isElementClickable() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(nextButton_id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectBrand(String brand) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", brand_id);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(brand_id));
        brand_id.sendKeys(brand);
    }

    public void selectStorage(String storageOption) {
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

    public void selectColor(String color) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(colorDropdown_id));

        Select colorSelect = new Select(colorDropdown_id);
        colorSelect.selectByVisibleText(color);
    }

    public void enterQuantity(String quantity) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(quantity_id));
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
    }

    public void enterAddress(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(address_id));
        address_id.sendKeys(address);
    }

    public void extractUnitPrice() {

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

    public void clickNextButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nextButton_id);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(nextButton_id));
        nextButton_id.click();
    }

}
