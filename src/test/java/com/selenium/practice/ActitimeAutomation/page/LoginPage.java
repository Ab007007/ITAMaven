package com.selenium.practice.ActitimeAutomation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class LoginPage {

	WebDriver driver = null;
	ExtentTest test =null;
	//Variables section
	@FindBy(id="username")
	WebElement usernameTextbox;
	
	@FindBy(name="pwd")
	WebElement passwordTextBox;
	
	@FindBy(id="loginButton")
	WebElement loginButton;
	
	
	public void validateTitle(String title)
	{
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	//Method Section
	private void enterUserName(String un)
	{
	//	test.log(LogStatus.INFO, "Entering username " + un);
		usernameTextbox.sendKeys(un);
	//	test.log(LogStatus.INFO, "Entering username is completed" + un);
	}
	
	
	private void enterPassword(String pwd)
	{
	//	test.log(LogStatus.INFO, "Entering Password " + pwd);
		passwordTextBox.sendKeys(pwd);
	//	test.log(LogStatus.INFO, "Entering username " + pwd);
	}
	
	private void clickOnLoginButton()
	{
	//	test.log(LogStatus.INFO, "Clicking on login button " );
		loginButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loginToApplication(String un,String pwd)
	{
		//test.log(LogStatus.INFO, "Logging into the applicaiton with " + un + "-" + pwd);
		enterUserName(un);
		enterPassword(pwd);
		clickOnLoginButton();
	}
	
	
	
	public LoginPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
}
