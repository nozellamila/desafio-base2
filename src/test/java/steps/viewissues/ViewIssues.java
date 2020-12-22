package steps.viewissues;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.MyViewPage;
import pages.ViewIssuesPage;
import utils.BaseTest;

import static utils.DriverFactory.getDriver;
import static utils.DriverFactory.killDriver;

public class ViewIssues extends BaseTest {

    @Before
    public void onSetUp(){
        getDriver();
    }

    @After
    public void onTearDown(){
        killDriver();
    }

    @Given("user goes to view issues")
    public void user_goes_to_view_issues() {
        LoginPage loginPage = new LoginPage(getDriver());
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());
        MyViewPage myViewPage = new MyViewPage(getDriver());

        myViewPage.assertDefaultProjectIsSelected();

        viewIssuesPage.clickViewIssues();
    }

    @When("user list issues using filters")
    public void user_list_issues_using_filters() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        viewIssuesPage.clickFilterAssignedTo();
        viewIssuesPage.selectAdministrador();
        viewIssuesPage.clickFilter();
    }

    @Then("system lists corresponding issues for applied filters")
    public void system_lists_corresponding_issues_for_applied_filters() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        Assert.assertTrue(viewIssuesPage.assertSearch(getDriver(), "assigned"));
    }

    @When("user search a specific issue")
    public void user_search_a_specific_issue() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        viewIssuesPage.setInputSearch("0005462");
        viewIssuesPage.clickFilter();
    }

    @Then("system list corresponding issue searched")
    public void system_list_corresponding_issue_searched(){
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        Assert.assertTrue(viewIssuesPage.assertSearch(getDriver(), "0005462"));
    }

    @Given("there is applied filters")
    public void there_is_applied_filters() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        viewIssuesPage.setInputSearch("0005462");
        viewIssuesPage.clickFilter();
    }

    @When("user reset applied filters")
    public void user_reset_applied_filters() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        viewIssuesPage.clickResetFilter();
    }

    @Then("system lists all issues")
    public void system_lists_all_issues() {
        // TODO: improve assert by using data source with existing issues for selected project
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        Assert.assertTrue(viewIssuesPage.assertSearch(getDriver(), "0005461"));
    }
}
