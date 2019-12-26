package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefs {

    AccountActivityPage accountActivityPage=new AccountActivityPage();

    @Then("dropdown default option should be {string}")
    public void dropdown_default_option_should_be(String expectedOptions) {
        System.out.println("dropdown default option display");
        String actualOptions=accountActivityPage.verifyAcctDropDefault();
        Assert.assertEquals("dropdown default optios didn't match",expectedOptions,actualOptions);

    }

    @Then("dropdown options should be following items")
    public void dropdown_options_should_be_following_items(List<String> expectedItems) {
        System.out.println("dropdown items display");
        List<String> actualItems=accountActivityPage.verifyActtDropDownOpp();
        Assert.assertEquals("dropdown items didn't match",expectedItems,actualItems);



    }

    @Then("transaction table columns should be following items")
    public void transaction_table_columns_should_be_following_items(List<String> expectedColumns) {
        System.out.println("transaction table items display");
        List<String> actualColumns=accountActivityPage.verifyTranTabColumn();
        Assert.assertEquals("transaction table items display",expectedColumns,actualColumns);



    }

}





