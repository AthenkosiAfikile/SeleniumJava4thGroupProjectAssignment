package screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart {
    WebDriver driver;

    @FindBy(id = "add-to-cart-btn")
    WebElement addToCartButton_id;
 @FindBy(id = "cart-title")
    WebElement cartTitle_id;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddToCartButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton_id);
        addToCartButton_id.click();
    }
    public void verifyItemAddedToCart() {
        cartTitle_id.isDisplayed();
    }
}
