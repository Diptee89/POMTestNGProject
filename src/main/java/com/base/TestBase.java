package com.base;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.pages.LogOutPage;
import com.pages.LoginPage;



public class TestBase {
	protected String MainWindow;
	protected WebDriver driver;

	protected String tempManifestNo;
	protected String manifestNo;
	protected String doNumber;
	protected String tempDeclarationNo;

	public void login(String id, String pass) {
		this.switchToWindow();
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginValidUser(id, pass);

	}

	public void logOut() {
		LogOutPage objLogOut = new LogOutPage(driver);
		objLogOut.logOutUser();
	}
	public WebElement findElement(By by) {
		WebElement elem = driver.findElement(by);
		// draw a border around the found element
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		}
		return elem;
	}

	public WebDriver openIE() {
		System.setProperty("webdriver.ie.driver", "c:\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		return driver;
	}

	public static void clearAndType(WebElement field, String text) {
		field.clear();
		field.sendKeys(text);
	}

	public void randomNum() {
		Random rand = new Random();
		int value = rand.nextInt(10000);
		Integer.toString(value);

	}

	public void switchToWindow() {
		MainWindow = driver.getWindowHandle();
//		System.out.println("Parent Winodow ID: " + MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();// to fetch the value iterator() will return from the collection object

		while (i1.hasNext()) { // loop if having some valu until loop will run
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
//				System.out.println("Child Winodow ID: " + ChildWindow);
				// Switching to Child window
				driver.switchTo().window(ChildWindow);

			}
		}
	}
}
