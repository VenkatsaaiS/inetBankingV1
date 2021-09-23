package org.inetbanking.pom;

import org.inetbanking.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage
{

    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="username")
   private WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(name="login")
    WebElement loginBtn;

    @FindBy(linkText="Logout")
    WebElement logoutBtn;

    
    public void enterUserName(String uname){

        userName.sendKeys(uname);
    }

    public void enterPassword(String pwd){

        password.sendKeys(pwd);
    }

    public void clickLoginBtn(){

        loginBtn.click();
    }

    public void clickLogoutBtn(){

        logoutBtn.click();
    }


}
