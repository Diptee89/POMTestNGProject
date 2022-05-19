package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@SuppressWarnings("unused")
public class LogOutPage {
	protected WebDriver driver;

	private By profileListBy = By.cssSelector("#profileListDiv");
	private By profile_Sign_outBy = By.xpath("//div[@id='profile_Sign_out']/a/div[2]");

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void logOutUser() {

		this.clickProfileList();
		this.clickLogout();
	}

	private void clickProfileList() {
		driver.findElement(profileListBy).click();
	}
	private void clickLogout() {
		driver.findElement(profile_Sign_outBy).click();
	}
}
