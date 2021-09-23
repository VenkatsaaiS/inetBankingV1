package org.inetbanking.tests;


import java.io.IOException;

import org.inetbanking.base.BaseTest;
import org.inetbanking.pom.HeaderPage;
import org.inetbanking.pom.LoginPage;
import org.inetbanking.utilities.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT extends BaseTest
{

    @Test(dataProvider="LoginData")
    public void loginDDT(String user,String pwd) throws InterruptedException
    {

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

        System.out.println("Login Successful......");
    }

    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/org/inetbanking/testData/LoginTestData.xlsx";

        int rownum= ExcelUtils.getRowCount(path, "Sheet1");
        int colcount=ExcelUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=ExcelUtils.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }

}