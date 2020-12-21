package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;
import utils.BaseTest;

public class MyViewPage extends BasePage {

    @FindBy(linkText = "Logout")
    WebElement textLogout;

    WebDriver driver;

    public MyViewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkSuccessfulLogin(){
        utils.checkIsDisplayed(this.textLogout);
    }
}
