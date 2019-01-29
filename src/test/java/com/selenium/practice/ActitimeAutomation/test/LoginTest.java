package com.selenium.practice.ActitimeAutomation.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.practice.ActitimeAutomation.page.LoginPage;
import com.selenium.practice.ActitimeAutomation.utils.DriverUtils;

import junit.framework.Assert;

public class LoginTest {

	WebDriver driver =null;
	LoginPage lp = null;
	ExtentReports ex = null;
	ExtentTest test = null;
	@BeforeTest
	public void createReports() {
		ex = new ExtentReports("reports\\TestExecution_Report_" + DriverUtils.getDateAndTime()+ ".html",true);
		
	}
	
	@BeforeMethod
	public void preSteps() {
		test = ex.startTest("presetup");
		lp = new LoginPage(driver,test);
		driver = DriverUtils.getMyDriver();
		driver.get("http://localhost:8080/login.do");
	}
	@Test(priority=1)
	public void validCredsLoginTest()
	{
		test = ex.startTest("Creating a report for Valid Creds...");
		test.log(LogStatus.INFO, "Login function is called...");
		lp.loginToApplication("admin", "manager");
		test.log(LogStatus.PASS, "Login is successfull");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		test.log(LogStatus.PASS, "Validation is successfull...");
	}
	
	
	@Test(priority=2)
	public void invalidCredsLogin()
	{
		test = ex.startTest("Creating a report for In-Valid Creds...");
		test.log(LogStatus.INFO, "Login function is called...");
		lp.loginToApplication("admin1", "manager1");
		test.log(LogStatus.PASS, "Login is Failed");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		test.log(LogStatus.PASS, "Failure - Validation is successfull...");
	}
	
	@AfterMethod
	public void postSteps(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "Test Step Failed... Taking a Screenshot");
			DriverUtils.takeScreenShot();
			
		}
		ex.endTest(test);
		test=null;
		driver.close();
	}
	
	
	@AfterTest
	public void saveReports()
	{
		ex.flush();
	}
}
