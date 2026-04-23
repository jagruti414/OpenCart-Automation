package com.amazon.automation.stepDefinitions;

import com.amazon.automation.pages.LoginPage;
import com.amazon.automation.utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    LoginPage lp;

    @Before
    public void setUp() {
        new BaseClass().setUp();
        lp = new LoginPage(BaseClass.driver);
    }

    @After
    public void tearDown() {
        new BaseClass().tearDown();
    }

    @Given("User is on OpenCart login page")
    public void user_is_on_opencart_login_page() {
        lp.goToLoginPage();
    }

    @When("User enters valid email {string}")
    public void user_enters_valid_email(String email) {
        lp.enterEmail(email);
    }

    @When("User enters invalid email {string}")
    public void user_enters_invalid_email(String email) {
        lp.enterEmail(email);
    }

    @And("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
        lp.enterPassword(password);
    }

    @And("User enters invalid password {string}")
    public void user_enters_invalid_password(String password) {
        lp.enterPassword(password);
    }

    @And("User clicks login button")
    public void user_clicks_login_button() {
        lp.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in() {
        Assert.assertTrue(lp.isLoginSuccessful(),
            "User should be logged in");
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(lp.isErrorDisplayed(),
            "Error message should be visible");
    }
}