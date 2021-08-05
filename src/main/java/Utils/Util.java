package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
    /**
     * method that wait an element
     * @param element
     * @param webDriver
     * @return webElement
     */
    static public WebElement WaitElement(By element, WebDriver webDriver){
         return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    static public float PriceFormatToFloat(String price){
        return Float.parseFloat(price.replaceAll(",","").substring(1));
    }

    static public boolean ValidateTwoDecimal(float firstNumber, float secondNumber){
        return firstNumber == secondNumber? true : false;
    }

    static public boolean ValidateThreeDecimal(float firstNumber, float secondNumber, float thirdNumber){
        return firstNumber == secondNumber && firstNumber == thirdNumber && secondNumber == thirdNumber? true : false;
    }
}
