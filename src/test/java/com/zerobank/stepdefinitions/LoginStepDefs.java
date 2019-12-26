package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage=new LoginPage();

    @Given("user is on home page")
    public void user_is_on_home_page() {
        System.out.println("user on the home page");
        loginPage.openUrl();

    }

    @When("user enters {string} and {string} and clicks Sign in button")
    public void user_enters_and_and_clicks_Sign_in_button(String username, String password) {
        System.out.println("user log in successfully");
        loginPage.login(username,password);
    }

    @Then("user should be on Account Summary page")
    public void user_should_be_on_Account_Summary_page() {
        System.out.println("Account Summary page should display");
        Assert.assertTrue("Title not match",loginPage.verifyAccountSummary());

    }

    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() {
        System.out.println("user not able to login with wrong credintials");
        Assert.assertTrue("blank username and password",loginPage.verifyTroubleMessageDisplayed());

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        System.out.println("error message display");
        Assert.assertTrue("Wrong username and password",loginPage.verifyErrorMessageDisplayed());

    }
    @Then("close browser")
    public void close_browser() {
        System.out.println("closing the browser");
       // Driver.get().close();

    }
    @And("user clicks on {string} tab")
    public void userClicksOnTab(String tab) {
        loginPage.navigateTo(tab);
    }


}
