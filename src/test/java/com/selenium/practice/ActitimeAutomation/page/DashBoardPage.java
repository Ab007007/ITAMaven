package com.selenium.practice.ActitimeAutomation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "TASKS")
	WebElement tasksTab;

	@FindBy(id = "logoutLink")
	WebElement logoutLink;

	public void clickOnTasks() {
		tasksTab.click();
	}

	public void logout() {
		logoutLink.click();
	}
}
