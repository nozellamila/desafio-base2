package steps.myview;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MyViewPage;
import utils.BaseTest;

import static utils.DriverFactory.getDriver;
import static utils.DriverFactory.killDriver;

public class MyView extends BaseTest {

    @Before
    public void onSetUp(){
        getDriver();
    }

    @After
    public void onTearDown(){
        killDriver();
    }

    @Given("user is able to view main page")
    public void user_is_able_to_view_main_page(){

    }

    @When("user enter valid login")
    public void user_enter_valid_login() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.setTxtUsername("mila.nozella");
        loginPage.setTxtPassword("base2@123");
        loginPage.clickBtnLogin();
    }

    @Then("user is redirected to my view")
    public void user_is_redirected_to_my_view() {
        MyViewPage myViewPage = new MyViewPage(getDriver());

        myViewPage.assertSuccessfulLogin();
    }

    @And("default project is selected")
    public void default_project_is_selected() {
        MyViewPage myViewPage = new MyViewPage(getDriver());

        Assert.assertTrue(myViewPage.assertDefaultProjectIsSelected());
    }

}
