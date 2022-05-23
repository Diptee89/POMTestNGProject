package test;

import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HouseBillPage;
import com.pages.ImportPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;

public class TestClass extends TestBase {
	String driverPath = "c:\\Drivers\\IEDriverServer.exe";
//	protected WebDriver driver;

	@BeforeTest
	public void setUp() {
		openIE();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
		System.out.println(driver.getTitle());
		switchToWindow();
	}

//	@Test(enabled=false)
//	@Test
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
		objMNFList.searchWithTempNo(tempManifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();

//		Issue DO
		login("nas.csa", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.seachWithManifestNo(manifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.issueDOs();
		logOut();
	}

	@Test
	public void testBayan() {
		PendingDeliveryOrderListPage objPendingDOList = new PendingDeliveryOrderListPage(driver);
		CustomsBayanPage objBayan = new CustomsBayanPage(driver);
		DeclarationListPage objDecList=new DeclarationListPage(driver);
		ImportPage objImp=new ImportPage(driver);

		login("broker.kwi", "fx5test");
//		objPendingDOList.clickPendingDOSubMenu();
//		objPendingDOList.searchWithDO();
//		objPendingDOList.clickDeclare();
//		objBayan.createBayan();
		
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec();
		objDecList.clickTempNo();
		
		objImp.clickEdit();
		objImp.requiredDocuments();
	}

//	@AfterTest
	public void close() {
		driver.close();
	}
	
}
