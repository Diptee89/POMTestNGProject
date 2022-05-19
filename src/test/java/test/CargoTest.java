package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HouseBillPage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManifestInformationPage;
import pages.ManifestListPage;

/**
 * Page Object encapsulates the Cargo Module
 */
public class CargoTest {
	String driverPath = "c:\\Drivers\\IEDriverServer.exe";
	protected WebDriver driver;

	@Test(priority = 0)
	public void testManifest() {
		
		ManifestListPage objMNFList = new ManifestListPage(driver);
		ManifestInformationPage objMNFInfo = new ManifestInformationPage(driver);
		HouseBillPage objHBL = new HouseBillPage(driver);
		
//		Create and Submit Manifest
		login_ValidUser("nas.csa", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();
		objHBL.createBL();
		objMNFInfo.submitManifest();
		logOut();
		
//		Approve Manifest
		login_ValidUser("cmanifest.kwi", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);		//"TMRN/8655/KWI22"
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();
		
//		Issue DO
		login_ValidUser("nas.csa", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);	
//		objMNFList.seachWithManifestNo(objMNFInfo.manifestNo);//   "MRN/7346/KWI22"
		objMNFList.clickTempNo();
		objMNFInfo.issueDOs();
		logOut();
	}

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
		System.out.println(driver.getTitle());
		switchToWindow();
	}

	public void switchToWindow() {
		String MainWindow = driver.getWindowHandle();
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

//	@AfterTest
	public void close() {
		driver.close();
	}
	public void login_ValidUser(String id, String pass) {
		// Create Login Page object
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginValidUser(id, pass);
		// Create Home Page Object
		HomePage objHome = new HomePage(driver);
		// Verify home page
//		Assert.assertTrue(objHome.getLoggedInUserID().toUpperCase().contains("NAS.CSA"));
		System.out.println(objHome.getloggedInUserLabel() + ": " + objHome.getLoggedInUserID());
		System.out.println("Default port is " + objHome.getLoginPortName());
	}

	public void logOut() {
		LogOutPage objLogOut = new LogOutPage(driver);
		objLogOut.logOutUser();
	}
	public static int generateRandomInt()
	{
		Random rand = new Random();
		int value = rand.nextInt(10000);
		
		return value;
	}
}