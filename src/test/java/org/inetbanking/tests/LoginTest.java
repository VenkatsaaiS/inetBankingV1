package org.inetbanking.tests;

import org.inetbanking.base.BaseTest;
import org.inetbanking.pom.HeaderPage;
import org.inetbanking.pom.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws IOException {

        driver.get(baseURL);
        logger.info("URL is accessed");


        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickAccountMenuLink();
        logger.info("Clicked on Account Menu Link");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(userName);
        logger.info("Entered UserName");

        loginPage.enterPassword(password);
        logger.info("Entered Password");

        loginPage.clickLoginBtn();
        logger.info("Clicked Submit button");

        loginPage.clickLogoutBtn();
        logger.info("Clicked Logout button");

        System.out.println("Login Successful....");
    }
}
