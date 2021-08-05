import POM.CartPage;
import POM.MainPage;
import POM.ProductDetailsPage;
import POM.StorePage;
import Utils.Util;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestVerifyAProduct {
    WebDriver driver;
    MainPage mainPage;
    StorePage storePage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage ;

    @BeforeTest
    public void SetUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.microsoft.com/en-us/");
        mainPage = new MainPage(driver);
        storePage = new StorePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void FirstApproachTest() throws InterruptedException {
        float firstPrice = mainPage.
                ValidateMenuItems().
                GoToWindows().
                clickOnWindows10MenuItem().
                PrintAllSubMenuValues().
                ClickOnSearch().
                Search("Visual Studio").
                ClickOnCancelMessage().
                PrintSoftwareElements().
                ObtainPriceFirstElement();
        float secondPrice = storePage.
                NavigateToDetailsPage().
                ClickOnCancelMessage().
                ObtainProductPrice();
        Assert.assertTrue(Util.ValidateTwoDecimal(firstPrice,secondPrice));
        float thirdPrice = productDetailsPage.
                ClickOnAddCart().
                ObtainPrice();
        Assert.assertTrue(Util.ValidateThreeDecimal(firstPrice,secondPrice,thirdPrice));
        float quantityPrice = cartPage.SelectItemQuantity(20).ObtainQuantityTotalPrice();
        Assert.assertTrue(Util.ValidateTwoDecimal(quantityPrice,(thirdPrice*20)));
    }

    @AfterTest
    public void AfterSteps(){
        driver.quit();
    }
}
