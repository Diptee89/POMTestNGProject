package com.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

/**
 * Page Object encapsulates the Sign-in page.
 */
public class LoginPage extends TestBase {

	private By usernameBy = By.cssSelector("input.FX50loginPanelTextBox");
	private By passwordBy = By.cssSelector("#sUserPassword");
	private By signinBy = By.cssSelector(".FX50loginPanelLoginButton");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Login as valid user
	 *
	 * @param userName
	 * @param password
	 * @return HomePage object
	 */
	public void loginValidUser(String strUserName, String strPasword) {

		// Fill user name

		setUserName(strUserName);

		// Fill password

		setPassword(strPasword);

		// Click Login button

		clickLogin();
	}

	// Set user name in textbox
	private void setUserName(String strUserName) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBy));
		WebElement field = findElement(usernameBy);
		clearAndType(field, strUserName);
	}

	private void setPassword(String strPassword) {
		findElement(passwordBy).click();
	}

	private void clickLogin() {
		findElement(signinBy).click();
	}

}
