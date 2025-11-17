package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ReviewCartPage {
    WebDriver driver;

    @FindBy(id = "cart-title")
    WebElement cartTitle_id;

    @FindBy(id = "id=cart-item-remove-1763422494948.7532")
    WebElement removeItem_id;
    @FindBy(id = "cart-item-total-1763416413060.2793")
    WebElement cartItemTotal_id;
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

    public void verifyGrandTotalFromCart() {
        String stringCartItemTotal = cartItemTotal_id.getText();
        System.out.println("Actual Cart Item Total after removal: " + stringCartItemTotal);
    }

}
