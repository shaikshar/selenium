package com.internetbanking.utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest Logger;
	

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		String TimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String RepName = "Test-Report"+TimeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("test-output")+"/test-put"+RepName);
		htmlReporter.loadXMLConfig(System.getProperty("test-output")+"/extent-confit.xml");	
		
		extent = new ExtentReports();
		
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "My machine");
		extent.setSystemInfo("Os","Mac OS");
		extent.setSystemInfo("user", "Mastan");
		
		htmlReporter.config().setDocumentTitle("Demo Project");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		Logger = extent.createTest(arg0.getTestName());
		Logger.log(Status.PASS, MarkupHelper.createLabel(arg0.getName(),ExtentColor.RED));
		
		
		String Screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+arg0.getName()+".png";
		
		File f = new File(Screenshotpath);
		
		if(f.exists()) {
			
			try {
				
				Logger.fail("Screenshot attached"+Logger.addScreencastFromPath(Screenshotpath));
				
			}catch(Exception e) {
				
			}
			//Logger.fail(Logger.addScreenCaptureFromPath(Screenshotpath));
			//Logger.fail(Logger.addScreenCaptureFromPath(Screenshotpath));
			
			
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		Logger = extent.createTest(arg0.getName());
		Logger.log(Status.SKIP, MarkupHelper.createLabel(arg0.getName(), ExtentColor.AMBER));
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		Logger = extent.createTest(arg0.getTestName());
		Logger.log(Status.PASS, MarkupHelper.createLabel(arg0.getName(),ExtentColor.GREEN));
		
	}
	
	

}
