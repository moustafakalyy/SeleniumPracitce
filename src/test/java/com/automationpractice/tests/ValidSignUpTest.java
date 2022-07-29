package com.automationpractice.tests;

import com.automationpractice.pages.AccountHomePage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.utilities.StaticProvider;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ValidSignUpTest extends BaseTest {


    @Test(dataProvider = "ValidSignUpSheetData", dataProviderClass = StaticProvider.class)
    public void signUp(String TestID, String TestDescription, String FirstName,
                               String LastName, String Email, String Password, String Address, String City,
                               String State, String ZipCode, String Country,
                               String MobilePhone, String AliasEmail, String ExpectedMessage) throws Exception {
        extentTest = extentReports.createTest(TestID + ": " + TestDescription);
        softAssert = new SoftAssert();
        HomePage homePage = new HomePage(browser);
        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterCreateEmailAddress(Email);
        CreateAccountPage createAccount = signInPage.clickCreateAccountButton();
        createAccount.enterFirstName(FirstName);
        createAccount.enterLastName(LastName);
        createAccount.enterPassword(Password);
        createAccount.enterAddress(Address);
        createAccount.enterCity(City);
        createAccount.selectState(State);
        createAccount.enterZipCode(ZipCode);
        createAccount.enterMobileNum(MobilePhone);
        createAccount.enterAliasEmailAddress(AliasEmail);
        AccountHomePage accountHomePage = createAccount.clickRegisterButton();
        String ActualMessage = accountHomePage.getWelcomeMessage();
        softAssert.assertEquals(ActualMessage, ExpectedMessage);
        softAssert.assertAll();
    }


}
