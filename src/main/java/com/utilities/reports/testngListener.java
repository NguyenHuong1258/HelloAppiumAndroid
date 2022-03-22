package com.utilities.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.IOException;

public class testngListener extends BaseTest implements ITestNGListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.extentReportGenerator();
    ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest.get().log(Status.PASS, "Test Passed");
        //test.log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //Screenshot
        extentTest.get().fail(result.getThrowable());
        AppiumDriver<?> driver =null;
        String testMethodName =result.getMethod().getMethodName();
        try {
            driver =(AppiumDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch(Exception e){}

        try {
            String path = getScreenshotPath(testMethodName, driver);
            extentTest.get().fail("Hello Attachment").addScreenCaptureFromPath(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            extentTest.get().fail("Test failed, cannot attach screenShot");
        }
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        if(extent != null) {
            extent.flush();
        }
    }
}
