package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import pages.MyViewPage;
import utils.BaseTest;

import java.io.File;
import java.io.IOException;

import static utils.DriverFactory.getDriver;
import static utils.DriverFactory.killDriver;

public class Login{

    @Before
    public void onSetUp(){
        getDriver();
    }

    @After
    public void onTearDown(Scenario scenario){
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

        myViewPage.checkSuccessfulLogin();

        //killDriver();
    }


}
