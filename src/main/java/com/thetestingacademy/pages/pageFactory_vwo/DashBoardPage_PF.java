package com.thetestingacademy.pages.pageFactory_vwo;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.thetestingacademy.utils.WaitHelpers.visibilityOfElement;

public class DashBoardPage_PF extends CommonToAllPage {

    WebDriver driver;

    public  DashBoardPage_PF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "[data-qa='lufexuloga']")
    private WebElement userNameOndashboard;

    public  String loggedInUserName(){
        visibilityOfElement(userNameOndashboard);
        return getText(userNameOndashboard);
    }
}
