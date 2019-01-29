package com.selenium.practice.ActitimeAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver=null;
	@Test
	public void loginTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\ITAAutomation\\Eclipse_WS\\SeleniumPractice\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8080/login.do");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
	}
	
	@Test
	public void validateViewtimeTrack() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='View Time-Track']")).click();
		driver.findElement(By.xpath("//td[@class='middle-right-cell customLeftPart']/div[@class='arrow']")).click();
		driver.findElement(By.xpath("//div[text()='Current week']")).click();
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logoutLink"))));
		
		logoutLink.click();
		driver.close();
		
	}
}
