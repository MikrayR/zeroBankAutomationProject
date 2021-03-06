package com.zerobank.stepdefinitions;

import com.zerobank.pages.AddNewPayeePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    AddNewPayeePage addNewPayeePage=new AddNewPayeePage();

    @Given("user is on Add New Payee page")
    public void user_is_on_Add_New_Payee_page() {
        System.out.println("Add New Payee page display");
        addNewPayeePage.clickAddNewPayee();

    }

    @When("user creates new payee using following information")
    public void user_creates_new_payee_using_following_information(Map<String,String> userData) {
        System.out.println("New Payee should be created");
        addNewPayeePage.AddNewPayee(userData.get("Payee Name"),userData.get("Payee Address"),userData.get("Account"),userData.get("Payee details"));

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessages) {
        System.out.println("message display");
        String actualMessages=addNewPayeePage.verifyMessage();
        Assert.assertEquals("messages did not match",expectedMessages,actualMessages);

    }

}
