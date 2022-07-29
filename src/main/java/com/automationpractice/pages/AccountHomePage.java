package com.automationpractice.pages;


import com.automationpractice.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AccountHomePage extends BasePage {
    private By WomenMenu = By.xpath("//a[@title='Women']");
    private By Blouses = By.xpath("//a[@title='Blouses']");
    private By welcomeMessage = By.xpath("//p[text()='Welcome to your account. Here you can manage all of your personal information and orders.']");

    public AccountHomePage(WebDriver driver) throws Exception {
        super(driver);
        Utilities.isWebElementPresent(WomenMenu, driver);

    }

    public BlousesPage selectWomenBlouses() throws Exception {
        Utilities.waitAndHoverOverElement(WomenMenu, driver);
        Utilities.waitAndClickOnWebElement(Blouses, driver);
        return new BlousesPage(this.driver);
    }

    public String getWelcomeMessage() throws Exception {
        return Utilities.waitAndGetWebElementText(welcomeMessage, driver);


    }
}
