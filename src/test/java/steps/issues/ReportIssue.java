package steps.issues;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.IssuesPage;
import pages.MyViewPage;
import utils.BaseTest;

import static utils.DriverFactory.getDriver;
import static utils.DriverFactory.killDriver;

public class ReportIssue extends BaseTest {

    @Before
    public void onSetUp(){
        getDriver();
    }

    @After
    public void onTearDown(){
        killDriver();
    }

    @Given("user goes to report issue")
    public void user_goes_to_report_issue() {
        IssuesPage issuesPage = new IssuesPage(getDriver());
        MyViewPage myViewPage = new MyViewPage(getDriver());

        myViewPage.selectMilasProject();
        issuesPage.clickReportIssue();
    }



    @When("^user fills \"(.*)\", \"(.*)\" and \"(.*)\"$")
    public void user_fills_category_summary_and_description(String category, String summary, String description){
        IssuesPage issuesPage = new IssuesPage(getDriver());

        issuesPage.setSummary(summary);
        issuesPage.setDescription(description);
        issuesPage.clickSubmitReport();
    }

    @Then("^system shows an message: \"(.*)\"$")
    public void system_shows_an_message(String message) {
        IssuesPage issuesPage = new IssuesPage(getDriver());

        Assert.assertTrue(issuesPage.assertMessage(message));
    }

    @When("user submits new issue")
    public void user_submits_new_issue() {
        IssuesPage issuesPage = new IssuesPage(getDriver());

        issuesPage.selectOptionCategory("[All Projects] General");
        issuesPage.setSummary("summary");
        issuesPage.setDescription("description");
        issuesPage.clickSubmitReport();
    }

    @Then("system shows successfull message")
    public void system_shows_successfull_message() {
        IssuesPage issuesPage = new IssuesPage(getDriver());

        Assert.assertTrue(issuesPage.assertMessage("Operation successful."));
    }
}
