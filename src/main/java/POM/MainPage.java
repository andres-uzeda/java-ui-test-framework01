package POM;

import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    protected WebDriver webDriver;

    private By officeMenuItem = By.cssSelector("[href='https://www.microsoft.com/en-us/microsoft-365/microsoft-office']");
    private By windowsMenuItem = By.cssSelector("[href='https://www.microsoft.com/en-us/windows/']");
    private By surfaceMenuItem = By.cssSelector("[href='https://www.microsoft.com/en-us/surface']");
    private By xboxMenuItem = By.cssSelector("[href='https://www.xbox.com/']");
    private By dealsMenuItem = By.cssSelector("[href='https://www.microsoft.com/en-us/store/b/sale?icid=gm_nav_L0_salepage']");
    private By supportMenuItem = By.cssSelector("[href='https://support.microsoft.com/en-us']");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * This method validates that office, window, surface, xbox
     * deals and support menu items are present in the main page
     * @return a main page
     */
    public MainPage ValidateMenuItems(){
        By menuItemArray [] = {
                this.officeMenuItem, this.windowsMenuItem, this.surfaceMenuItem,
                this.xboxMenuItem, this.dealsMenuItem, this.supportMenuItem
        };
        for (By item:menuItemArray) {
            Util.WaitElement(item, webDriver);
        }
        return new MainPage(webDriver);
    }

    /**
     * this method click on windows menu item
     * @return a window page
     */
    public WindowsPage GoToWindows(){
        webDriver.findElement(windowsMenuItem).click();
        return new WindowsPage(webDriver);
    }
}
