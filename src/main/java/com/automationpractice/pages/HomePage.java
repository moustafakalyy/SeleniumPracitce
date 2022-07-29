package com.automationpractice.pages;

import com.automationpractice.utilities.MyBrowser;
import com.automationpractice.utilities.Utilities;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By signInButton = By.xpath("//div[@class='header_user_info']");
    public static String homePagePath = "http://automationpractice.com/index.php";

    public HomePage(MyBrowser browser) throws Exception {
        super(browser.driver);
        browser.driverInt(homePagePath);
        Utilities.isWebElementPresent(signInButton, this.driver);
    }

    public SignInPage clickSignInButton() throws Exception {
        Utilities.waitAndClickOnWebElement(signInButton, this.driver);
        return new SignInPage(this.driver);


    }
}