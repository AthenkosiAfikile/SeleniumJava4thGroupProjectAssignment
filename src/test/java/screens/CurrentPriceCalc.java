package screens;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrentPriceCalc {
    WebDriver driver;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue_id;


    public CurrentPriceCalc(WebDriver driver) {
        this.driver = driver;
    }


}
