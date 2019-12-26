package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPayeePage extends BasePage {

    public AddNewPayeePage(){

        PageFactory.initElements(Driver.get(),this);

    }
    LoginPage loginPage=new LoginPage();

    @FindBy(xpath = "//a[contains(text(),'Pay Bills')]")
    public WebElement PayBillsTab;

    @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
    public WebElement addNewPayeeTab;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeNameTab;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement payeeAddressTab;

    @FindBy(xpath = "//input[@id='np_new_payee_account'] ")
    public WebElement accountTab;

    @FindBy(xpath = "//input[@id='np_new_payee_details'] ")
    public WebElement payeeDetailsTab;

    @FindBy(xpath = "//input[@id='add_new_payee']")
    public WebElement addButton;

    @FindBy(id ="alert_content")
    public WebElement confirmationMessage;

    public void clickAddNewPayee(){
        loginPage.openUrl();
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        navigateTo("Pay Bills");
        addNewPayeeTab.click();
    }
    public void AddNewPayee(String name, String address, String account, String payeeDetails){
        payeeNameTab.sendKeys(name);
        payeeAddressTab.sendKeys(address);
        accountTab.sendKeys(account);
        payeeDetailsTab.sendKeys(payeeDetails);
        addButton.click();



    }
    public String verifyMessage(){
        BrowserUtils.waitForVisibility(confirmationMessage,5);
        String actualMessage=confirmationMessage.getText();
        return actualMessage;

    }

}
