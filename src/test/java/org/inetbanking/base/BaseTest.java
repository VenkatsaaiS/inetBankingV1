package org.inetbanking.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.inetbanking.utilities.ReadConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    ReadConfig readConfig= new ReadConfig();
    public Logger logger;
   protected WebDriver driver;
   protected String baseURL = readConfig.getBaseURL();
   protected String userName = readConfig.getUserName();
   protected String password = readConfig.getPassword();

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String br) throws Exception {

        logger= Logger.getLogger("Ecommerce");
        PropertyConfigurator.configure("log4j.properties");

        switch (br) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new Exception("Invalid Browser Value");
        }
    }

    @AfterMethod
    public void quitDriver(ITestResult result) throws IOException {

      if (result.getStatus()==ITestResult.FAILURE)
      {
          File destFile= new File(System.getProperty("user.dir")+ "/Screenshots/" +
                  result.getTestClass().getRealClass().getSimpleName() + "_" +
                  result.getMethod().getMethodName()+ ".png");
          captureScreenShot(destFile);
      }
      driver.quit();
    }

    private void captureScreenShot(File destFile) throws IOException
    {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File srcFile= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,destFile);
        System.out.println("Screenshot captured as the test failed...");
        }
    }
