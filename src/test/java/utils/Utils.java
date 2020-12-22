package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void selectOptionCategory(String option){
        if(option != null && option != ""){
            By locator = By.xpath("//option[contains(text(), '" + option + "')]");
            WebElement webElement;

            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                webElement = getDriver().findElement(locator);
                webElement.click();
            }catch (Exception e){
                Assert.fail(e.toString());
            }
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

    public boolean checkIsDisplayed(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return webElement.isDisplayed();
        }catch (Exception e){
            Assert.fail(e.toString());
            return false;
        }
    }

    public boolean assertMessage(String text) {
        Boolean retorno = getDriver().getPageSource().contains(text);
        return retorno;
    }

}
