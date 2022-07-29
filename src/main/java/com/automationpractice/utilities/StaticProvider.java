package com.automationpractice.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class StaticProvider {
    private int cartValidationSheet = 0;
    private int invalidLoginSheet = 1;
    private int validLoginSheet = 0;
    private int validSignUpSheet = 0;

    @DataProvider(name = "ValidSignUpSheetData")
    public Object[][] getValidSignUpSheetData() throws IOException {
        String signUpExcelPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\SignUpData.xlsx";
        ExcelFile signUpSheetExcelFile = new ExcelFile(signUpExcelPath);
        Object[][] validSignUpSheetData = signUpSheetExcelFile.getTestDataFromExcelFile(validSignUpSheet);
        return validSignUpSheetData;

    }

    @DataProvider(name = "CartValidationSheetData")
    public Object[][] getCartValidationData() throws IOException {
        String cartValidationExcelPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\CartValidationData.xlsx";
        ExcelFile cartValidationExcelFile = new ExcelFile(cartValidationExcelPath);
        Object[][] cartValidationData = cartValidationExcelFile.getTestDataFromExcelFile(cartValidationSheet);
        return cartValidationData;

    }

    @DataProvider(name = "InvalidLoginSheetData")
    public Object[][] getInvalidLoginData() throws IOException {
        String logInExcelPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\LogInData.xlsx";
        ExcelFile logInSheetExcel = new ExcelFile(logInExcelPath);
        Object[][] invalidLoginData = logInSheetExcel.getTestDataFromExcelFile(invalidLoginSheet);
        return invalidLoginData;

    }

    @DataProvider(name = "ValidLoginSheetData")
    public Object[][] getValidLoginData() throws IOException {
        String logInExcelPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\LogInData.xlsx";
        ExcelFile logInSheetExcel = new ExcelFile(logInExcelPath);
        Object[][] validLoginData = logInSheetExcel.getTestDataFromExcelFile(validLoginSheet);
        return validLoginData;

    }

}
