package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baselayer.BaseClass;
import utillayer.ExtentManager;
import utillayer.Screenshot;

public class TestListener implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    
    public void onTestStart(ITestResult result) {

        extent = ExtentManager.getExtentReports();
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test Started");
        test.log(Status.PASS, result.getName()+"start execution");
    }
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
        test.log(Status.PASS, result.getName()+"TestCase Passed");
        BaseClass base = (BaseClass) result.getInstance();
        WebDriver driver = base.driver;

        String screenshotPath =
                Screenshot.captureScreenshot(
                        driver,
                        result.getMethod().getMethodName());

        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            test.warning("Unable to attach screenshot: "
                    + e.getMessage());
        }
    }
    public void onTestFailure(ITestResult result) {
        test=extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName()+"got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());
        BaseClass base = (BaseClass) result.getInstance();
        WebDriver driver = base.driver;
		String screenshotPath =Screenshot.captureScreenshot(driver,result.getMethod().getMethodName());
                
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onTestSkipped(ITestResult result) {  
    	test=extent.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
    	test.log(Status.SKIP, result.getName()+"got Skipped");
    	test.log(Status.INFO, result.getThrowable().getMessage());
    }

    
    public void onFinish(ITestContext context) {
        ExtentManager.getExtentReports().flush();
    }
     

    }

