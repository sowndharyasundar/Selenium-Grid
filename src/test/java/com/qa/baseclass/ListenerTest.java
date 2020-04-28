package com.qa.baseclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerTest implements ITestListener {
	private static ExtentTest test;
	BaseTest baseTest = new BaseTest();
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult testResult) {
		test.log(Status.FAIL, "Test failed: " + testResult.getName());
		test.log(Status.FAIL, "Test failed with exception: " + testResult.getThrowable());
		try {
			test.addScreenCaptureFromPath("."+getScreenshotPath(testResult.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult testResult) {
		test.log(Status.SKIP, "Test passed: " + testResult.getName());
	}

	public void onTestStart(ITestResult testResult) {
		test = baseTest.getReport().createTest("Verify " + testResult.getName());
	}

	public void onTestSuccess(ITestResult testResult) {
		test.log(Status.PASS, "Test passed: " + testResult.getName());
	}

	public String getScreenshotPath(String testName) throws IOException {
		File screenshotSource = ((TakesScreenshot) baseTest.getDriver()).getScreenshotAs(OutputType.FILE);
		String destination = "./screenshots/" + testName + "-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
		FileUtils.copyFile(screenshotSource, new File(destination));
		return destination;
	}
}