package steps.myview;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.IssuesPage;
import pages.LoginPage;
import pages.MyViewPage;

import static utils.DriverFactory.getDriver;
import static utils.DriverFactory.killDriver;

public class MyViewFilter {

    @Before
    public void onSetUp(){
        getDriver();
    }

    @After
    public void onTearDown(){
        killDriver();
    }

    @Given("user is logged")
    public void user_is_logged() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.setTxtUsername("mila.nozella");
        loginPage.setTxtPassword("base2@123");
        loginPage.clickBtnLogin();
    }

    @When("^user enters \"(.*)\"$")
    public void user_enters_issue(String issue) {
        MyViewPage myViewPage = new MyViewPage(getDriver());

        myViewPage.setIssueSearch(issue);
    }

    @Then("^system shows an error \"(.*)\"$")
    public void system_shows_an_error(String message) throws InterruptedException {
        MyViewPage myViewPage = new MyViewPage(getDriver());

        Assert.assertTrue(myViewPage.assertMessage(message));
    }

    @When("user enters valid issue number")
    public void user_enters_valid_issue_number() {
        MyViewPage myViewPage = new MyViewPage(getDriver());

        myViewPage.setIssueSearch("0005462");
    }

    @Then("system shows issue details")
    public void system_shows_issue_details() {
        IssuesPage issuesPage = new IssuesPage(getDriver());

        Assert.assertEquals(issuesPage.getText(), "0005462");
    }

    @And("searched issue is placed in Recently visited")
    public void searched_issue_is_placed_in_recently_visited() {
        MyViewPage myViewPage = new MyViewPage(getDriver());
        IssuesPage issuesPage = new IssuesPage(getDriver());

        myViewPage.clickMyView();

        issuesPage.assertSearchedIssueIsRecentlyVisited("0005462");
    }

    @Given("project has one or more issues")
    public void project_has_one_or_more_issues() {
    }

    @When("user selects a project")
    public void user_selects_a_project() {
        MyViewPage myViewPage = new MyViewPage(getDriver());

        myViewPage.selectMilasProject();
    }

    @Then("project's issues are listed")
    public void projects_issues_are_listed() {
        MyViewPage myViewPage = new MyViewPage(getDriver());

        Assert.assertTrue(myViewPage.assertMessage("0005462"));
    }

}
