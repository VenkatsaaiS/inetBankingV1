package org.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig() {

        File file = new File("./Configurations/config.properties");
        try {
            FileInputStream fis = new FileInputStream(file);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception is" + e.getMessage());
        }

    }

    public String getBaseURL() {
        String baseURl = properties.getProperty("baseURL");
        return baseURl;
    }

    public String getUserName() {
        String userName = properties.getProperty("userName");
        return userName;
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        return password;
    }

    public String getChromeDriverPath() {
        String chromedriver = properties.getProperty("chromedriverpath");
        return chromedriver;
    }

    public String getFirefoxDriverPath() {
        String firefoxdriver = properties.getProperty("firefoxdriverpath");
        return firefoxdriver;
    }
}

