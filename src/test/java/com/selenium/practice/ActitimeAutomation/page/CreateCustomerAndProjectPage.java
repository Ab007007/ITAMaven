package com.selenium.practice.ActitimeAutomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCustomerAndProjectPage {

	WebDriver driver=null;
	public CreateCustomerAndProjectPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[text()='Add New']")
	WebElement addNewButton;
	
	@FindBy(xpath="//div[contains(text(),'New Customer')]")
	WebElement newCustomerButton;
	
	
	@FindBy(id="customerLightBox_nameField")
	WebElement customerNameTextBox;
	@FindBy(id="customerLightBox_descriptionField")
	WebElement customerDescTextBox;
	@FindBy(id="customerLightBox_commitBtn")
	WebElement createCustomerButton;
	
	@FindBy(xpath="//div[@class='toasts']//span")
	WebElement toastMsg;
	
	public void clickOnAddNewButton()
	{
		addNewButton.click();
	}
	public void clickOnNewCustomerButton()
	{
		newCustomerButton.click();
	}
	
	public void enterCustomerName(String name) {
		customerNameTextBox.sendKeys(name);
	}
	
	public void enterCustomerDesc(String name) {
		customerDescTextBox.sendKeys(name);
	}
	
	public void clickOnCreateCustomerButton() {
		createCustomerButton.click();
	}
	
	public void createNewCustomre(String cn,String cd)
	{
		enterCustomerName(cn);
		enterCustomerDesc(cd);
		clickOnCreateCustomerButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		System.out.println("Success message is dispalyed-->#######" + toastMsg.getText());
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toasts']//span"))));
		System.out.println("toast message dissappeared..");
	}
	
	
}
