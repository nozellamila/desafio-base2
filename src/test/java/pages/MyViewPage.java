package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;
import utils.BaseTest;

public class MyViewPage extends BasePage {

    @FindBy(linkText = "Logout")
    WebElement textLogout;

    @FindBy(linkText = "My View")
    WebElement textMyView;

    @FindBy(xpath = "//option[contains(text(), 'All Projects')]")
    WebElement firstOptionSelectProject;

    @FindBy(xpath = "//option[contains(text(), 'Mila Nozella´s Project')]")
    WebElement optionMilasProject;

    @FindBy(name = "bug_id")
    WebElement issueSearch;

    WebDriver driver;

    public MyViewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMyView(){ utils.click(textMyView);}

    public void setIssueSearch(String text){ utils.setTextField(this.issueSearch, text + Keys.ENTER); }

    public void selectMilasProject(){ utils.click(this.optionMilasProject); }

    public void assertSuccessfulLogin(){ utils.checkIsDisplayed(this.textLogout); }

    public boolean assertDefaultProjectIsSelected(){ return utils.assertOptionIsSelected(this.firstOptionSelectProject); }

    public boolean assertMessage(WebDriver driver, String text){ return driver.getPageSource().contains(text); }
}
