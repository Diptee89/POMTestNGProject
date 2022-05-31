package test;

import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HBItemsPage;
import com.pages.HouseBillPage;
import com.pages.ImportPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;

public class TestClass extends TestBase {
	String driverPath = "c:\\Drivers\\IEDriverServer.exe";
	private ManifestInformationPage objMNFInfo;
	private CustomsBayanPage objBayan;

	@BeforeTest
	public void setUp() {
		openIE();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
//		driver.get("http://10.138.108.44/mckwfx5bam/Main.aspx");
		System.out.println(driver.getTitle());
		switchToWindow();
	}

//	@Test(enabled=false)
//	@Test(priority = 0)
	public void testManifest() {

		ManifestListPage objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);
		HouseBillPage objHBL = new HouseBillPage(driver);
		HBItemsPage objHBItems = new HBItemsPage(driver);

//		Create and Submit Manifest
		login("nas.csa", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();
		objHBL.createBL();
//		objHBItems.createHBItems();
		objMNFInfo.submitManifest();
		logOut();

//		Approve Manifest
		login("cmanifest.kwi", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();

//		Issue DO
		login("nas.csa", "fx5test");
		objMNFList.clickCargoMenu();
		objMNFList.seachWithManifestNo(objMNFInfo.manifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.issueDOs();
		logOut();
	}

	@Test(priority = 1)
	public void testBayan() {
		PendingDeliveryOrderListPage objPendingDOList = new PendingDeliveryOrderListPage(driver);
		objBayan = new CustomsBayanPage(driver);
		DeclarationListPage objDecList = new DeclarationListPage(driver);
		ImportPage objImp = new ImportPage(driver);

		login("broker.kwi", "fx5test");
//		Declare DO & Create Import Bayan
//		objPendingDOList.clickPendingDOSubMenu();
//		objPendingDOList.searchWithDO(objMNFInfo.doNumber); // objMNFInfo.doNumber DO/54924/KWI22
//		objPendingDOList.clickDeclare();
//
//		objBayan.createBayan();

//		Edit Created Bayan from Declaration list screen4';u		
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec("TIM/29661/KWI22");// tempDeclarationNo
		objDecList.clickTempNo();

		objImp.clickEdit();
		objImp.selectExitPort();
//		objImp.addInvoice();
//		objImp.addItems();
//		
//		objImp.requiredDocuments();
//		objImp.addDeclarationVehiclesList();
//
//		objImp.calculateDuty();
//		objImp.addPaymentInformation();
//		objImp.submitDeclaration();
//		logOut();
	}

//	@AfterTest
	public void close() {
		driver.close();
	}

}
