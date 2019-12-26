package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage extends BasePage {


    public AccountSummaryPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    LoginPage loginPage = new LoginPage();

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> subTitles;

    @FindBy(xpath = "//div[@class='board'][3]/div/table/thead/tr/th")
    public List<WebElement>table;

    public String returnTitle(){
        String actualTitle=Driver.get().getTitle();
        return actualTitle;
    }
    public List<String> returnSubTitle(){
        List<String>SubTitle=new ArrayList<>();
        for(WebElement el: subTitles){
            SubTitle.add(el.getText());
        }
        return SubTitle;
    }
    public List<String> returnTableTitle(){
        List<String>TableTitle=new ArrayList<>();
        for(WebElement El: table){
          TableTitle.add(El.getText());
        }
        return TableTitle;
    }

}
