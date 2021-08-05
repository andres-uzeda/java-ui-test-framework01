package POM;

import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StorePage {
    protected WebDriver webDriver;

    private By cancelPopMessageOption = By.cssSelector("#R1MarketRedirect-1 > button");
    private By listOfSoftwareElements = By.xpath("//*[@id=\"coreui-productplacement-30l7ywa\"]/div[3]/div/div/ul/li");

    public StorePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * method that cancel a window pop up
     * @return store page
     */
    public StorePage ClickOnCancelMessage(){
        Util.WaitElement(cancelPopMessageOption, webDriver);
        webDriver.findElement(cancelPopMessageOption).click();
        return new StorePage(webDriver);
    }

    /**
     * method that prints three elements
     * @return store page
     */
    public StorePage PrintSoftwareElements(){
        List<WebElement> windows10MenuList = webDriver.findElements(listOfSoftwareElements);
        System.out.println("Software Elements:");
        int count = 3;
        for (WebElement item: windows10MenuList) {
            System.out.println(item.getText());
            if(count == 0){
                break;
            }
            count--;
        }
        return new StorePage(webDriver);
    }

    /**
     * method that obtain the first element
     * @return float number
     */
    public float ObtainPriceFirstElement(){
        String firstElement = webDriver.findElement(listOfSoftwareElements).getText();
        String[] parts = firstElement.split(" ");
        return Util.PriceFormatToFloat(parts[5]);
    }

    /**
     * method that navigate to details page
     * @return product detail page
     */
    public ProductDetailsPage NavigateToDetailsPage(){
        webDriver.findElement(listOfSoftwareElements).click();
        return new ProductDetailsPage(webDriver);
    }
}
