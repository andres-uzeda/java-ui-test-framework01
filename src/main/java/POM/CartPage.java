package POM;

import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage {
    protected WebDriver webDriver;

    private By priceLabel = By.cssSelector("span > span[aria-hidden=\"true\"]");
    private By itemQuantityOption = By.cssSelector("select[aria-label='Visual Studio Professional Subscription  Quantity selection']");

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Float ObtainPrice(){
        Util.WaitElement(priceLabel, webDriver);
        return Util.PriceFormatToFloat(webDriver.findElement(priceLabel).getText());
    }

    /**
     * method that select a number of items
     * @param number
     * @return cart page
     */
    public CartPage SelectItemQuantity(int number){
        Select se = new Select(webDriver.findElement(itemQuantityOption));
        se.selectByValue(String.valueOf(number));
        return new CartPage(webDriver);
    }

    /**
     * method that obtains total price, use thread in order to wait calculate async
     * @return cart page
     */
    public float ObtainQuantityTotalPrice() throws InterruptedException {
        Thread.sleep(4000);
        List<WebElement> allQuantities = webDriver.findElements(priceLabel);
        return Util.PriceFormatToFloat(allQuantities.get(1).getText());
    }
}
