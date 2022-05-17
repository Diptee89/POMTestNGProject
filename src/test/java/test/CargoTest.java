package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HouseBillPage;
import pages.LoginPage;
import pages.ManifestInformationPage;
import pages.ManifestListPage;

/**
 * Page Object encapsulates the Cargo Module
 */
public class CargoTest {
	String driverPath = "c:\\Drivers\\IEDriverServer.exe";
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions act;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);

		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
		System.out.println(driver.getTitle());
		switchToWindow();
	}

	public void switchToWindow() {
		String MainWindow = driver.getWindowHandle();
		System.out.println("Parent Winodow ID: " + MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();// to fetch the value iterator() will return from the collection object

		while (i1.hasNext()) { // loop if having some valu until loop will run
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				System.out.println("Child Winodow ID: " + ChildWindow);
				// Switching to Child window
				driver.switchTo().window(ChildWindow);

			}
		}
	}

	@Test(priority = 0)
	public void testLogin_ValidUser() {

		// Create Login Page object
		LoginPage objLogin = new LoginPage(driver);

		// Verify login page title

		objLogin.loginValidUser("nas.csa", "fx5test");

		// Create Home Page Object
		HomePage objHome = new HomePage(driver);

		// Verify home page
		Assert.assertTrue(objHome.getLoggedInUserID().toUpperCase().contains("NAS.CSA"));
		System.out.println(objHome.getloggedInUserLabel() + ": " + objHome.getLoggedInUserID());

		System.out.println("Default port is " + objHome.getLoginPortName());
	}

	@Test(priority = 1)
	public void testManifest() {
		ManifestListPage objMNFList = new ManifestListPage(driver);
		ManifestInformationPage objMNFInfo = new ManifestInformationPage(driver);
		HouseBillPage objHBL = new HouseBillPage(driver);

		objMNFList.clickCargoMenu();
		objMNFInfo.createManifest("00009");
		objHBL.createBL("HBL/0009/KWI22");
		objMNFInfo.submitManifest();

	}
}