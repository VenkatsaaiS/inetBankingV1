package org.inetbanking.tests;

import org.inetbanking.base.BaseTest;
import org.inetbanking.pom.HeaderPage;
import org.inetbanking.pom.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BaseTest {


    @Test
    public void RegistrationTest() throws IOException {

        driver.get(baseURL);
        logger.info("URL is accessed");

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickAccountMenuLink();
        logger.info("Clicked on Account Menu Link");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.
                enterUserName("albithar");
        registrationPage.
                enterEmailAddress("albithar18@yahoo.co.in");
        registrationPage.
                enterPassword("albitharpwd");
        registrationPage.
                clickRegisterBtn();


    }
}
