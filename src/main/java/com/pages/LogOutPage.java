package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.base.TestBase;
//@SuppressWarnings("unused")
public class LogOutPage extends TestBase{
public LogOutPage(WebDriver driver) {
	this.driver = driver;
}

	private By profileListBy = By.cssSelector("#profileListDiv");
	private By profile_Sign_outBy = By.xpath("//div[@id='profile_Sign_out']/a/div[2]");

	public void logOutUser() {

		this.clickProfileList();
		this.clickLogout();
	}

	private void clickProfileList() {
//		driver.findElement(profileListBy).click();
		findElement(profileListBy).click();
	}
	private void clickLogout() {
//		driver.findElement(profile_Sign_outBy).click();
		findElement(profile_Sign_outBy).click();
	}
}
