package com.automationpractice.pages;

import com.automationpractice.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateAccountPage extends BasePage {
    private By firstNameTextField = By.xpath("//*[@id=\"customer_firstname\"]");
    private By lastNameTextField = By.xpath("//*[@id=\"customer_lastname\"]");
    private By emailAddressTextField = By.id("email");
    private By passwordTextField = By.id("passwd");
    private By addressTextField = By.id("address1");
    private By cityTextField = By.id("city");

    private By stateDropDownMenu = By.xpath("//select[@name='id_state']");
    private By zipCodeTextField = By.id("postcode");
    private By countryTextField = By.id("id_country");
    private By mobileNumTextField = By.id("phone_mobile");
    private By aliasEmailAddressTextField = By.id("alias");
    private By registerButton = By.id("submitAccount");

    public CreateAccountPage(WebDriver driver) throws Exception {
        super(driver);
        Utilities.isWebElementPresent(firstNameTextField, driver);
    }

    public void enterFirstName(String name) throws Exception {
        Utilities.waitAndEnterTextInWebElement(name, firstNameTextField, driver);


    }

    public void enterLastName(String name) throws Exception {
        Utilities.waitAndEnterTextInWebElement(name, lastNameTextField, driver);


    }

    public void enterPassword(String password) throws Exception {
        Utilities.waitAndEnterTextInWebElement(password, passwordTextField, driver);
    }


    public void enterAddress(String address) throws Exception {
        Utilities.waitAndEnterTextInWebElement(address, addressTextField, driver);
    }

    public void enterCity(String city) throws Exception {
        Utilities.waitAndEnterTextInWebElement(city, cityTextField, driver);


    }

    public void selectState(String state) throws Exception {
        Utilities.waitAndSelectFromDropdown(state, stateDropDownMenu, driver);
    }


    public void enterZipCode(String code) throws Exception {
        Utilities.waitAndEnterTextInWebElement(code, zipCodeTextField, driver);

    }

    public void enterMobileNum(String mobileNumber) throws Exception {
        Utilities.waitAndEnterTextInWebElement(mobileNumber, mobileNumTextField, driver);

    }

    public void enterAliasEmailAddress(String aliasEmailAddress) throws Exception {
        Utilities.waitAndEnterTextInWebElement(aliasEmailAddress, aliasEmailAddressTextField, driver);
    }


    public AccountHomePage clickRegisterButton() throws Exception {
        Utilities.waitAndClickOnWebElement(registerButton, driver);
        return new AccountHomePage(this.driver);
    }


}






























