package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{
    public LoginPage() {

        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(id="signin_button")
    public WebElement signinButton;

    @FindBy(id="user_login")
    public WebElement username;

    @FindBy(id="user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitButton;

    @FindBy(linkText ="Login and/or password are wrong.")
    public WebElement ErrorMessage;

    @FindBy(xpath = "//h3")
    public WebElement TroubleMessage;

    public void openUrl(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }



    public void login(String username, String password) {
        signinButton.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        BrowserUtils.waitForClickablility(submitButton,10);
        submitButton.click();

    }
    public boolean verifyAccountSummary(){
        String expectedTitle="Zero - Account Summary";
        String actualTitle=Driver.get().getTitle();
        boolean expectTitle=expectedTitle.equals(actualTitle);
        return expectTitle;
    }
    public boolean verifyTroubleMessageDisplayed(){
        return TroubleMessage.isDisplayed();
    }
    public boolean verifyErrorMessageDisplayed(){
        return ErrorMessage.isDisplayed();
    }
}