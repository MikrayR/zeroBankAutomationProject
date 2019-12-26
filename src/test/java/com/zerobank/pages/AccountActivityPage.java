package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);

    }
    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountDropDefault;

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public List<WebElement> accountDropDownOptions;

    @FindBy(xpath = "//div/table/thead/tr/th")
    public List<WebElement>transactionsTableColumn;

    public String verifyAcctDropDefault(){
        Select defaul=new Select(accountDropDefault);
        String defaultvalue=defaul.getFirstSelectedOption().getText();
        return defaultvalue;
    }
    public List<String>verifyActtDropDownOpp(){
        List<String>actualOptions=new ArrayList<>();
        BrowserUtils.waitFor(5);
        for(WebElement el:accountDropDownOptions){
            actualOptions.add(el.getText());
        }
        return actualOptions;
    }
    public List<String >verifyTranTabColumn(){
        List<String>actualColumns=new ArrayList<>();
        for (WebElement El: transactionsTableColumn){
            actualColumns.add(El.getText());

        }
        return actualColumns;
    }
}
