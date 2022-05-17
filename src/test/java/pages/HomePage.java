package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	protected WebDriver driver;
	private By loginPortNameBy = By.cssSelector("#LoginPortNameLabel");
	private By loggedInUserLabelBy = By.cssSelector(".LoggedInUserLabel");
	private By loggedInUserIDBy = By.cssSelector(".LoggedInUserID");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	// Get the User name from Home Page
	public String getloggedInUserLabel() {

		return driver.findElement(loggedInUserLabelBy).getText();

	}
	public String getLoggedInUserID() {

		return driver.findElement(loggedInUserIDBy).getText();

	}

	public String getLoginPortName() {

		return driver.findElement(loginPortNameBy).getText();

	}

}
