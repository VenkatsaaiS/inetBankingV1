package org.inetbanking.pom;

import org.inetbanking.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {

   private WebDriver driver;

   public HeaderPage(WebDriver driver){
       super(driver);
       PageFactory.initElements(driver,this);
   }

   @FindBy(css = "li[id='menu-item-1237'] a[class='menu-link']")
   @CacheLookup
    WebElement accountMenuLink;

   public void clickAccountMenuLink(){
       accountMenuLink.click();

   }
}
