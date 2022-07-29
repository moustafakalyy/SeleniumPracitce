package com.automationpractice.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MyBrowser {
    public WebDriver driver = null;

    public MyBrowser(String Browser) {
        switch (Browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

                break;
            default:
                System.out.println("Browser is not Supported");
        }


    }

    public void driverInt(String initialUrl) {
        this.driver.manage().window().maximize();
        this.driver.navigate().to(initialUrl);
    }


}
