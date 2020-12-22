package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

public class IssuesPage extends BasePage {

    @FindBy(xpath = "//table[3]/tbody/tr[3]/td[1]")
    WebElement issueId;

    @FindBy(xpath = "//small/a[1]")
    WebElement firstRecentlyVisited;

    @FindBy(linkText = "Report Issue")
    WebElement textReportIssue;

    @FindBy(name = "summary")
    WebElement inputSummary;

    @FindBy(name = "description")
    WebElement inputDescription;

    @FindBy(xpath = "//td[2]/select/option[contains(text(), 'Mila Nozella´s Project')]")
    WebElement selectReportProject;

    @FindBy(className = "button")
    WebElement btnSubmitReport;

    @FindBy(className = "button")
    WebElement btnSelectProject;

    WebDriver driver;

    public IssuesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectOptionCategory(String category){ utils.selectOptionCategory(category); }

    public void selectReportProject(){ utils.click(this.selectReportProject); }

    public void setSummary(String summary){ utils.setTextField(this.inputSummary, summary);}

    public void setDescription(String description){ utils.setTextField(this.inputDescription, description);}

    public void clickReportIssue(){ utils.click(this.textReportIssue);}

    public void clickSelectProject(){ utils.click(this.btnSelectProject);}

    public void clickSubmitReport(){ utils.click(this.btnSubmitReport);}

    public String getText(){
        return utils.getText(this.issueId);
    }

    public void assertSearchedIssueIsRecentlyVisited(String issue){ utils.assertTextEquals(this.firstRecentlyVisited, issue); }

    public boolean assertMessage(String message){ return utils.assertMessage(message); }
}
