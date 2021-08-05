package POM;

import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WindowsPage {
    protected WebDriver webDriver;

    private By windows10MenuItem = By.cssSelector("#c-shellmenu_54");
    private By windows10ListItems = By.xpath("//*[@id=\"uhf-g-nav\"]/ul/li[2]/div/ul/li");
    private By searchButton = By.id("search");
    private By searchHeaderInput = By.id("cli_shellHeaderSearchInput");

    public WindowsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * method that click on windows menu item
     * @return windows page
     */
    public WindowsPage clickOnWindows10MenuItem(){
        Util.WaitElement(windows10MenuItem,webDriver);
        webDriver.findElement(windows10MenuItem).click();
        return new WindowsPage(webDriver);
    }

    /**
     * method that print all submenu values
     * @return windows page
     */
    public WindowsPage PrintAllSubMenuValues(){
        List<WebElement> windows10MenuList = webDriver.findElements(windows10ListItems);
        System.out.println("Elements in the dropdown:");
        for (WebElement item: windows10MenuList) {
            System.out.println(item.getText());
        }
        return new WindowsPage(webDriver);
    }

    /**
     * method that click on in the search option
     * @return windows page
     */
    public WindowsPage ClickOnSearch(){
        webDriver.findElement(searchButton).click();
        return new WindowsPage(webDriver);
    }

    /**
     * method that insert a string in a search input
     * @param value
     * @return windows page
     */
    public StorePage Search(String value){
        webDriver.findElement(searchHeaderInput).sendKeys(value);
        webDriver.findElement(searchHeaderInput).sendKeys(Keys.RETURN);
        return new StorePage(webDriver);
    }
}
