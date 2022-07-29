package com.automationpractice.tests;

import com.automationpractice.pages.*;
import com.automationpractice.utilities.StaticProvider;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class CartValidationTest extends BaseTest {


    @Test(dataProvider = "CartValidationSheetData", dataProviderClass = StaticProvider.class)
    public void cartValidation(String TestID, String TestDescription, String Email, String Password) throws Exception {
        extentTest = extentReports.createTest(TestID + ": " + TestDescription);
        softAssert = new SoftAssert();
        HomePage homePage = new HomePage(browser);
        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterEmailAddress(Email);
        signInPage.enterPassword(Password);
        AccountHomePage accountHomePage = signInPage.clickOnSignInButton();
        BlousesPage blousesPage = accountHomePage.selectWomenBlouses();
        String expectedItemName = blousesPage.getItemName();
        CartPage cartPage = blousesPage.addItemToCartAndProceedToCheckOut();


        softAssert.assertTrue(cartPage.isChosenItemPresent(expectedItemName), "Item chosen is not present");
        softAssert.assertAll();

    }

}
