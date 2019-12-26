package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseForeignCurrencyPage extends BasePage {

    public PurchaseForeignCurrencyPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    LoginPage loginPage=new LoginPage();

    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    public WebElement puchaseForeignCurrencyTab;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement currencySelection;

    @FindBy(xpath = "//input[@id='pc_calculate_costs']")
    public WebElement calculateCostButton;


}
