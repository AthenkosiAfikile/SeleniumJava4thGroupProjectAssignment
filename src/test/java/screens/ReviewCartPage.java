package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ReviewCartPage {
    WebDriver driver;

    public static double calculatedTotal = 0.0;
    public static String stringCartItemTotal;
    public static String grandTotalText;
    @FindBy(id = "cart-title")
    WebElement cartTitle_id;
    @FindBy(id = "id=cart-item-remove-1763422494948.7532")
    WebElement removeItem_id;
    @FindBy(xpath = "//div[starts-with(@id, 'cart-item-total-') " +
            "and contains(@data-testid, 'cart-item-total-')]")
    WebElement cartItemTotal_id;
    @FindBy(id = "//div[starts-with(@id, 'cart-item-total-') " +
            "and contains(@data-testid, 'cart-item-total-')]")
    WebElement cartItemTotal2_id;
    @FindBy(id = "cart-grand-total-value")
    WebElement cartGrandTotal_id;



    public ReviewCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyReviewCartPageIsDisplayed() {
        String actualCartTitle = cartTitle_id.getText();
        String expectedCartTitle = "Cart (2 items)";
        Assert.assertEquals(actualCartTitle, expectedCartTitle, "Review Cart Page is not displayed.");
    }

    public void removeItemFromCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(removeItem_id));
        removeItem_id.click();
    }

    public void verifyGrandTotalMatchesItemTotals() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> itemTotals = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[starts-with(@id, 'cart-item-total-') and contains(@data-testid, 'cart-item-total-')]")
        ));

        wait.until(ExpectedConditions.visibilityOf(cartGrandTotal_id));
        grandTotalText = cartGrandTotal_id.getText().replace("R", "").trim();
        double grandTotalValue = Double.parseDouble(grandTotalText);

        for (int i = 0; i < itemTotals.size(); i++) {
            String itemTotalText = itemTotals.get(i).getText().replace("R", "").trim();
            double itemTotalValue = Double.parseDouble(itemTotalText);
            calculatedTotal += itemTotalValue;
            System.out.println("Item " + (i + 1) + " Total: " + itemTotalValue);
        }

        System.out.println("Calculated Total: " + calculatedTotal);
        System.out.println("Grand Total: " + grandTotalValue);
        Assert.assertEquals(calculatedTotal, grandTotalValue, "Grand total does not match the sum of item totals.");
    }

}
