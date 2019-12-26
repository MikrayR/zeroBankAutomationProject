package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {
    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();

    @Then("title should be {string}")
    public void title_should_be(String title) {
        System.out.println("user on Zero Account Summary Page");
        String expectedTitle=title;
        String actualTitle=accountSummaryPage.returnTitle();
        Assert.assertEquals("Titles didn't match",expectedTitle,actualTitle);

    }

    @Then("following account types should be displayed")
    public void following_account_types_should_be_displayed(List<String> expectedSubTitles) {
        System.out.println("Account Summary page display different account types");
        List<String> actualSubTitles=accountSummaryPage.returnSubTitle();
        System.out.println(expectedSubTitles);
        System.out.println(actualSubTitles);
        Assert.assertEquals("SubTitles didn't match",expectedSubTitles,actualSubTitles);
    }

    @Then("following columns should be displayed on Credit Accounts table")
    public void following_columns_should_be_displayed_on_Credit_Accounts_table(List<String> expectedClumns) {
        System.out.println("columns diplayed on Credit Account Table");
        List<String> actualColumns=accountSummaryPage.returnTableTitle();
        System.out.println(actualColumns);
        System.out.println(expectedClumns);
        Assert.assertEquals("Columns didn't match",expectedClumns,actualColumns);



    }
}
