package utils;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static utils.DriverFactory.getDriver;

public class Utils {
    /********* TextField ************/

    public void setTextField(WebElement webElement, String text){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.clear();
            webElement.sendKeys(text);
        }catch (Exception e){
            Assert.fail(e.toString());
        }
    }

    public String getValue(WebElement webElement) {
        return webElement.getAttribute("value");
    }

    /********** LinkText **********/

    public void checkIsDisplayed(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.isDisplayed();
        }catch (Exception e){
            Assert.fail(e.toString());
        }
    }

    /*********** Select ***********/

    public boolean assertOptionIsSelected(WebElement webElement){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return webElement.isSelected();

        }catch (Exception e){
            Assert.fail(e.toString());
            return false;
        }
    }

    /*********** General **********/

    public void click(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }catch (Exception e){
            Assert.fail(e.toString());
        }
    }

    public String getText(WebElement webElement){
        return webElement.getText();
    }

    public void assertTextEquals(WebElement webElement, String text){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));

            String elementText = this.getText(webElement);

            Assert.assertEquals(elementText, text);
        }catch (Exception e){
            Assert.fail(e.toString());
        }

    }
}
