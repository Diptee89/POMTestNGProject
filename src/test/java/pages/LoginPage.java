package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Page Object encapsulates the Sign-in page.
 */
public class LoginPage {

	protected WebDriver driver;

	private By usernameBy = By.cssSelector("input.FX50loginPanelTextBox");
	private By passwordBy = By.cssSelector("#sUserPassword");
	private By signinBy = By.cssSelector(".FX50loginPanelLoginButton");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Set user name in textbox
	private void setUserName(String strUserName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBy));
		WebElement field = driver.findElement(usernameBy);
		clearAndType(field, strUserName);
	}

	// Set password in password textbox
	private void setPassword(String strPassword) {
//		WebElement field = driver.findElement(passwordBy);
//		clearAndType(field, strPassword);
		driver.findElement(passwordBy).click();
	}
	// Click on login button

	private void clickLogin() {

		driver.findElement(signinBy).click();
	}
	// Get the title of Login Page

	/**
	 * Login as valid user
	 *
	 * @param userName
	 * @param password
	 * @return HomePage object
	 */
	public void loginValidUser(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();
	}

	private static void clearAndType(WebElement field, String text) {
		field.clear();
		field.sendKeys(text);
	}

}
