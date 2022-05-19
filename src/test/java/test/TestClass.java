package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HouseBillPage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManifestInformationPage;
import pages.ManifestListPage;

public class TestClass {
	String driverPath = "c:\\Drivers\\IEDriverServer.exe";
	protected WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
		System.out.println(driver.getTitle());
		switchToWindow();
	}

	@Test
	public void testManifest() {

		ManifestListPage objMNFList = new ManifestListPage(driver);
		ManifestInformationPage objMNFInfo = new ManifestInformationPage(driver);
		HouseBillPage objHBL = new HouseBillPage(driver);

//		Create and Submit Manifest
		login("nas.csa", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();
		objHBL.createBL();
		objMNFInfo.submitManifest();
		logOut();

//		Approve Manifest
		login("cmanifest.kwi", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo); // "TMRN/8655/KWI22"
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();

//		Issue DO
		login("nas.csa", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);
//		objMNFList.seachWithManifestNo(objMNFInfo.manifestNo);//   "MRN/7346/KWI22"
		objMNFList.clickTempNo();
		objMNFInfo.issueDOs();
		logOut();
	}

	@AfterTest
	public void close() {
		driver.close();
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

	public void login(String id, String pass) {

		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginValidUser(id, pass);

	}

	public void logOut() {
		LogOutPage objLogOut = new LogOutPage(driver);
		objLogOut.logOutUser();
	}
}
