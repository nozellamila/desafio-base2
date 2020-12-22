package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MyViewPage;

import static utils.DriverFactory.getDriver;
import static utils.DriverFactory.killDriver;

public class Login{

    @Before
    public void onSetUp(){
        getDriver();
    }

    @After
    public void onTearDown(){
        killDriver();
    }

    @Given("User is in login page")
    public void user_is_in_login_page() {
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.setTxtUsername("mila.nozella");
        loginPage.setTxtPassword("base2@123");
    }

    @And("Clicks on submission button")
    public void clicks_on_submission_button() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.clickBtnLogin();

    }

    @Then("user is able to view de main page")
    public void user_is_able_to_view_de_main_page() {
        MyViewPage myViewPage = new MyViewPage(getDriver());

        myViewPage.assertSuccessfulLogin();
    }


}
