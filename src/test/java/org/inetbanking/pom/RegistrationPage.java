package org.inetbanking.pom;

import org.inetbanking.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver)
    {
      super(driver);

      PageFactory.initElements(driver,this);

    }

    @FindBy(how=How.ID,using = "reg_username")
    @CacheLookup
    WebElement userName;

    @FindBy(how = How.ID,using = "reg_email")
    @CacheLookup
    WebElement emailId;

    @FindBy(how = How.ID, using= "reg_password")
    @CacheLookup
    WebElement password;

    @FindBy(how= How.NAME, using="register")
    @CacheLookup
    WebElement registerBtn;


    public void enterUserName(String uname){
        userName.sendKeys(uname);

    }
    public void enterEmailAddress(String email) {
        emailId.sendKeys(email);
    }

    public void enterPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void clickRegisterBtn() {
        registerBtn.click();
    }
}
