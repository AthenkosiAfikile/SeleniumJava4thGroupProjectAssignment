package screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class WebAutomationAdvancePage {
    WebDriver driver;
    @FindBy(id = "tab-btn-web")
    WebElement webAutomationAdvanceTab_id;
    @FindBy(id = "deviceType")
    WebElement deviceType_id;
    @FindBy(id = "brand")
    WebElement brand_id;
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
    @FindBy(id = "subtotal-value")
    WebElement subtotalValue_id;
    @FindBy(id = "address")
    WebElement address_id;
    @FindBy(id = "inventory-next-btn")
    WebElement inventoryNextButton_id;

    public WebAutomationAdvancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWebAutomationAdvanceTab() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", webAutomationAdvanceTab_id);

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

    public boolean isStorageSelected(String storageOption) {
        return switch (storageOption) {
            case "64GB" -> {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOf(storage_id));
                yield storage_id.isSelected();
            }
            case "128GB" -> {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOf(storage128GB_id));
                yield storage128GB_id.isSelected();
            }
            case "256GB" -> {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOf(storage256GB_id));
                yield storage256GB_id.isSelected();
            }
            default -> throw new IllegalArgumentException("Invalid storage option: " + storageOption);
        };
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

    public boolean isColorFieldEmpty() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(colorDropdown_id));

        Select colorSelect = new Select(colorDropdown_id);
        String currentColor = colorSelect.getFirstSelectedOption().getText().trim();

        return currentColor.isEmpty() || currentColor.contains("Color");
    }

    public void enterQuantity(String quantity) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(quantity_id));
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
    }

    public String getEnteredQuantity() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(quantity_id));
        return quantity_id.getAttribute("value");
    }

    public String getSubtotalAmount() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(subtotalValue_id));
        return subtotalValue_id.getText().trim();
    }

    public String calculateExpectedSubtotal(String unitPriceString, String quantityString) {
        String priceWithoutCurrency = unitPriceString.replace("R", "");
        double unitPrice = Double.parseDouble(priceWithoutCurrency);

        int quantity = Integer.parseInt(quantityString);

        double total = unitPrice * quantity;

        String formattedTotal = String.format(Locale.US, "%.2f", total);

        return "R" + formattedTotal;
    }

    public void enterAddress(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(address_id));
        address_id.clear();
        address_id.sendKeys(address);
    }


    public boolean isNextButtonClickable() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(nextButton_id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickNextButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nextButton_id);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(nextButton_id));
        nextButton_id.click();
    }
}
