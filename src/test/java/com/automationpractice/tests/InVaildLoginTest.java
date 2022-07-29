package com.automationpractice.tests;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.utilities.StaticProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InVaildLoginTest extends BaseTest {


    @Test(dataProvider = "InvalidLoginSheetData", dataProviderClass = StaticProvider.class)
    public void InvalidSignIn(String TestID, String TestDescription, String Email, String Password, String ExpectedMessage) throws Exception {
        extentTest = extentReports.createTest(TestID + ": " + TestDescription);
        softAssert = new SoftAssert();
        HomePage homePage = new HomePage(browser);
        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterEmailAddress(Email);
        signInPage.enterPassword(Password);
        signInPage.clickOnSignInButton();
        softAssert.assertTrue(signInPage.isErrorMessagePresent(ExpectedMessage), "Error message is not displayed correctly");
        softAssert.assertAll();

    }

}

