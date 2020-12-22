package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

public class IssuePage extends BasePage {

    @FindBy(xpath = "//table[3]/tbody/tr[3]/td[1]")
    WebElement issueId;

    @FindBy(xpath = "//small/a[1]")
    WebElement firstRecentlyVisited;

    WebDriver driver;

    public IssuePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText(){
        return utils.getText(this.issueId);
    }

    public void assertSearchedIssueIsRecentlyVisited(String issue){
        utils.assertTextEquals(this.firstRecentlyVisited, issue);
    }
}
