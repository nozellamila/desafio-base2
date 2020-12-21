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


    public String getText(WebElement webElement) {
        return webElement.getAttribute("value");
    }

    /********* Button ************/

    public void clickButton(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }catch (Exception e){
            Assert.fail(e.toString());
        }
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
}
