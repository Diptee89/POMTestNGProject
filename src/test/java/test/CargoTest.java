package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HouseBillPage;
import com.pages.LogOutPage;
import com.pages.LoginPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;

/**
 * Page Object encapsulates the Cargo Module
 */
public class CargoTest {
public WebDriver driver;
	@Test(priority = 0)
	public void testManifest() {

		login("nas.csa", "fx5test");
		ManifestListPage objMNFList = new ManifestListPage(driver);
		ManifestInformationPage objMNFInfo = new ManifestInformationPage(driver);
		HouseBillPage objHBL = new HouseBillPage(driver);

//		Create and Submit Manifest
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();
		objHBL.createBL();
		objMNFInfo.submitManifest();
		logOut();

//		Approve Manifest
		login("cmanifest.kwi", "fx5test");
		objMNFList.clickCargoMenu();
//		objMNFList.searchWithTempNo(tempManifestNo);		//"TMRN/8655/KWI22"
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();

//		Issue DO
		login("nas.csa", "fx5test");
		objMNFList.clickCargoMenu();
//		objMNFList.seachWithManifestNo(manifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.issueDOs();
		logOut();
	}

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.ie.driver", "c:\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
		System.out.println(driver.getTitle());
		switchToWindow();
		login("nas.csa", "fx5test");
	}
	
//	@AfterTest
	public void close() {
		driver.close();
	}
	public void login(String id, String pass) {
		this.switchToWindow();
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginValidUser(id, pass);

	}

	public void logOut() {
		LogOutPage objLogOut = new LogOutPage(driver);
		objLogOut.logOutUser();
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
//				 Switching to Child window
				driver.switchTo().window(ChildWindow);

			}
		}
	}
}