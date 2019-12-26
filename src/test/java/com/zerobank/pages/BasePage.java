package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    @FindBy(css = ".brand")
    @CacheLookup
    public WebElement brandLogo;

    @FindBy(xpath = "//input[@id='searchTerm']")
    public WebElement searchBar;

    @FindBy(xpath = "(//a[starts-with(@class, 'dropdown')])[1]")
    @CacheLookup
    public WebElement settingButton;

    @FindBy(xpath = "(//a[starts-with(@class, 'dropdown')])[2]")
    public WebElement usernameButton;

    @FindBy(id ="logout_link")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(), 'Account Summary')]")
    public WebElement accountSummaryTab;

    @FindBy(xpath = "//a[contains(text(), 'Account Activity')]")
    public WebElement accountActivityTab;

    @FindBy(xpath = "//a[contains(text(), 'Transfer Funds')]")
    public WebElement transferFundsTab;

    @FindBy(xpath = "//a[contains(text(), 'Pay Bills')]")
    public WebElement payBillsTab;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public boolean verifyLogoDislayed() {
        return brandLogo.isDisplayed();
    }

    public boolean verifySearchBarDisplayed() {
        return searchBar.isEnabled();
    }

    public void logout() {
        usernameButton.click();
        BrowserUtils.waitForClickablility(logoutButton,10);
        logoutButton.click();
    }
    public String getUsername() {
        BrowserUtils.waitForVisibility(usernameButton, 5);
        return usernameButton.getText();
    }



    public void navigateTo(String tab){

        Driver.get().findElement(By.xpath("//a[text()='"+tab+"']")).click();
    }


}







