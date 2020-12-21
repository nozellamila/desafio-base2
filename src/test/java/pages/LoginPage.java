package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;
import utils.Utils;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "secure_session")
    WebElement checkSecureSession;

    @FindBy(xpath = "//input[@class='button']")
    WebElement btnLogin;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setTxtUsername(String username) {
        utils.setTextField(this.txtUsername, username);
    }

    public void setTxtPassword(String password) {
        utils.setTextField(this.txtPassword,password);
    }

    public void clickBtnLogin() {
        utils.clickButton(this.btnLogin);
    }
}
