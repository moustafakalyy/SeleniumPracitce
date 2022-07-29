package com.automationpractice.tests;

import com.automationpractice.pages.AccountHomePage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.utilities.StaticProvider;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ValidLoginTest extends BaseTest {


    @Test(dataProvider = "ValidLoginSheetData", dataProviderClass = StaticProvider.class)
    public void validSignIn(String TestID, String TestDescription, String Email, String Password, String ExpectedMessage) throws Exception {
        extentTest = extentReports.createTest(TestID + ": " + TestDescription);
        softAssert = new SoftAssert();
        HomePage homePage = new HomePage(browser);
        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterEmailAddress(Email);
        signInPage.enterPassword(Password);
        AccountHomePage accountHomePage = signInPage.clickOnSignInButton();
        String actualMessage = accountHomePage.getWelcomeMessage();
        softAssert.assertEquals(actualMessage, ExpectedMessage);
        softAssert.assertAll();


    }

}
