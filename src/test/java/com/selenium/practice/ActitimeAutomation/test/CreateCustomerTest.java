package com.selenium.practice.ActitimeAutomation.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.practice.ActitimeAutomation.page.CreateCustomerAndProjectPage;
import com.selenium.practice.ActitimeAutomation.page.DashBoardPage;
import com.selenium.practice.ActitimeAutomation.page.LoginPage;
import com.selenium.practice.ActitimeAutomation.utils.DriverUtils;

public class CreateCustomerTest {

	WebDriver driver=null;
	
	LoginPage loginPage = null;
	DashBoardPage dPage =null;
	CreateCustomerAndProjectPage  ccPage = null;

	
	@Test
	public void createCustomerTest()
	{
		driver = DriverUtils.getMyDriver();
		loginPage = new LoginPage(driver);
		dPage = new DashBoardPage(driver);
		ccPage = new CreateCustomerAndProjectPage(driver);
		
		
		driver.get("http://localhost:8080/login.do");
		loginPage.loginToApplication("admin", "manager");
		loginPage.validateTitle("actiTIME - Enter Time-Track");
		dPage.clickOnTasks();
		ccPage.clickOnAddNewButton();
		ccPage.clickOnNewCustomerButton();
		ccPage.createNewCustomre("POM-Cust2", "POM-Cust2");
		dPage.logout();
		driver.close();
	}
}
