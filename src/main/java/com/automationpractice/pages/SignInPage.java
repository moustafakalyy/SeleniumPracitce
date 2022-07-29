package com.automationpractice.pages;

import com.automationpractice.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    private By emailAddressTextField = By.id("email");
    private By passwordTextField = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By createEmailAddressTextField = By.id("email_create");
    private By createAnAccountButton = By.id("SubmitCreate");

    public SignInPage(WebDriver driver) throws Exception {
        super(driver);
        Utilities.isWebElementPresent(emailAddressTextField, driver);

    }


    public void enterEmailAddress(String email) throws Exception {
        Utilities.waitAndEnterTextInWebElement(email, emailAddressTextField, driver);
    }

    public void enterPassword(String password) throws Exception {
        Utilities.waitAndEnterTextInWebElement(password, passwordTextField, driver);
    }

    public AccountHomePage clickOnSignInButton() throws Exception {
        Utilities.waitAndClickOnWebElement(signInButton, driver);
        return new AccountHomePage(driver);
    }

    public boolean isErrorMessagePresent(String errorMessage) throws Exception {
        By errorElement = By.xpath("//li[text()='" + errorMessage + "']");
        return Utilities.isWebElementPresent(errorElement, driver);
    }

    public void enterCreateEmailAddress(String email) throws Exception {
        Utilities.waitAndEnterTextInWebElement(email, createEmailAddressTextField, this.driver);


    }

    public CreateAccountPage clickCreateAccountButton() throws Exception {
        Utilities.waitAndClickOnWebElement(createAnAccountButton, this.driver);
        return new CreateAccountPage(this.driver);

    }

}
