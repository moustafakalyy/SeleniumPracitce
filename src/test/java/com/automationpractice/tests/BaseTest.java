package com.automationpractice.tests;

import com.automationpractice.utilities.MyBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BaseTest {
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public MyBrowser browser;
    public SoftAssert softAssert;
    String timeStamp = new SimpleDateFormat("MM dd yyyy_ HH mm ss").format(Calendar.getInstance().getTime());

    @BeforeSuite
    public void setUpReport() {
        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Report/Report " + timeStamp + ".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Host Name", "Moustafa Aly");


        extentHtmlReporter.config().setChartVisibilityOnOpen(true);
        extentHtmlReporter.config().setDocumentTitle("Automation Testing Training");
        extentHtmlReporter.config().setReportName("Automation Practice Report");
        extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        extentHtmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeMethod
    public void setUpDriver() {
        browser = new MyBrowser("Chrome");


    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
            captureScreenShot(browser.driver);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            extentTest.skip(result.getThrowable());
        }

        browser.driver.quit();

    }

    @AfterSuite
    public void tearDown() {
        extentReports.flush();
    }


    public void captureScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFolder = System.getProperty("user.dir") + "/test-output/Screenshots/" + timeStamp + ".png";
        System.out.println(destinationFolder);
        File destination = new File(destinationFolder);
        FileUtils.copyFile(source, destination);
        extentTest.addScreenCaptureFromPath("../Screenshots/" + timeStamp + ".png");
    }
}
