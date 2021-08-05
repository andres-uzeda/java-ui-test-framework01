package POM;

import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    protected WebDriver webDriver;

    private By cancelPopMessageOption = By.cssSelector("#R1MarketRedirect-1 > button");
    private By productPriceLabel = By.cssSelector("span[aria-disabled='false']");
    private By addCartButton = By.id("buttonPanel_AddToCartButton");

    public ProductDetailsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * method that cancel a window pop up
     * @return store page
     */
    public ProductDetailsPage ClickOnCancelMessage(){
        Util.WaitElement(cancelPopMessageOption, webDriver);
        webDriver.findElement(cancelPopMessageOption).click();
        return new ProductDetailsPage(webDriver);
    }

    /**
     * method that obtains a number
     * @return float number
     */
    public float ObtainProductPrice(){
        return Util.PriceFormatToFloat(webDriver.findElement(productPriceLabel).getText());
    }

    /**
     * method that click on add cart button
     * @return cart page
     */
    public CartPage ClickOnAddCart(){
        webDriver.findElement(addCartButton).click();
        return new CartPage(webDriver);
    }
}
