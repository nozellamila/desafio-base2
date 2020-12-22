package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

public class ViewIssuesPage extends BasePage {

    @FindBy(linkText = "View Issues")
    WebElement textViewIssues;

    @FindBy(linkText = "Assigned To:")
    WebElement textFilterAssignedTo;

    @FindBy(linkText = "0005462")
    WebElement textIssue;

    @FindBy(xpath = "//span[contains(text(), 'Viewing Issues (0 - 0 / 0)')]")
    WebElement textNoneIssuesDisplayed;

    @FindBy(xpath = "//option[contains(text(), 'administrator')]")
    WebElement optionAdministrador;

    @FindBy(name = "search")
    WebElement inputSearch;

    @FindBy(name = "filter")
    WebElement btnFilter;

    @FindBy(name = "switch_to_query_button")
    WebElement btnResetFilter;

    WebDriver driver;

    public ViewIssuesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setInputSearch(String text){ utils.setTextField(this.inputSearch, text);}

    public void selectAdministrador(){ utils.click(this.optionAdministrador); }

    public void clickViewIssues(){ utils.click(this.textViewIssues); }

    public void clickFilterAssignedTo(){ utils.click(this.textFilterAssignedTo); }

    public void clickFilter(){ utils.click(this.btnFilter); }

    public void clickIssue(){ utils.click(this.textIssue); }

    public void clickResetFilter(){ utils.click(this.btnResetFilter); }

    public boolean assertSearch(WebDriver driver, String text){ return driver.getPageSource().contains(text); }

    public boolean assertNoIssuesAreDisplayed(){ return utils.checkIsDisplayed(this.textNoneIssuesDisplayed);}
}
