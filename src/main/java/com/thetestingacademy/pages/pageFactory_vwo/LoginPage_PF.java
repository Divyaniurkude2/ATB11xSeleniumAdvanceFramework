package com.thetestingacademy.pages.pageFactory_vwo;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.pages.pageObjectModel_normal_POM.imporved_POM_vwo.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAllPage {
    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    public String loginToVWOInvalidCreds() {
        try{
            openVWOUrl();
            enterInput(username, PropertiesReader.readKey("invalid-username"));
            enterInput(password, PropertiesReader.readKey("invalid-password"));
            clickElement(signButton);
            WaitHelpers.waitJVM(5000);
        }catch (Exception e) {
            System.out.println("Elements Not Found!");
        }
        return getText(error_message);
    }
}
