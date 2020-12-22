package steps.viewissues;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.IssuesPage;
import pages.MyViewPage;
import pages.ViewIssuesPage;

import static utils.DriverFactory.getDriver;
import static utils.DriverFactory.killDriver;

public class ViewIssuesForOneProject {

    @Before
    public void onSetUp(){
        getDriver();
    }

    @After
    public void onTearDown(){
        killDriver();
    }

    @Given("user navigates to view issues")
    public void user_navigates_to_view_issues() {
        MyViewPage myViewPage = new MyViewPage(getDriver());
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        myViewPage.selectMilasProject();
        viewIssuesPage.clickViewIssues();
    }

    @When("user list all issues for the project")
    public void user_list_all_issues_for_the_project() {
        // TODO: improve assert by using data source with existing issues for selected project
    }

    @Then("system lists corresponding issues for the project")
    public void system_lists_corresponding_issues_for_the_project() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        Assert.assertTrue(viewIssuesPage.assertSearch(getDriver(), "0005462"));
    }

    @When("user search a specific project's issue")
    public void user_search_a_specific_project_s_issue() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        viewIssuesPage.setInputSearch("0005462");
        viewIssuesPage.clickFilter();
    }

    @Then("system list corresponding issue")
    public void system_list_corresponding_issue() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        Assert.assertTrue(viewIssuesPage.assertSearch(getDriver(), "0005462"));
    }

    @And("user access issue details")
    public void user_access_issue_details() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        viewIssuesPage.clickIssue();
    }

    @And("system shows page with issue details")
    public void system_shows_page_with_issue_details() {
        IssuesPage issuesPage = new IssuesPage(getDriver());

        Assert.assertEquals(issuesPage.getText(), "0005462");
    }

    @When("user search an issue not belonging to selected project")
    public void user_search_an_issue_not_belonging_to_selected_project() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        viewIssuesPage.setInputSearch("0005461");
        viewIssuesPage.clickFilter();
    }

    @Then("system does not list corresponding issue")
    public void system_does_not_list_corresponding_issue() {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(getDriver());

        Assert.assertTrue(viewIssuesPage.assertNoIssuesAreDisplayed());
    }
}
