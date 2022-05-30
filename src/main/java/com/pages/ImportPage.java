package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class ImportPage extends TestBase {
	public ImportPage(WebDriver driver) {
		this.driver = driver;
	}

	private By editBy = By.id("edit");
	private By cancelBy = By.id("cancel");
	private By validateDecVehBy = By.id("ValidateDecVeh");
	private By cmdCancelDecBy = By.id("cmdCancelDec");
	private By ddFormBy = By.id("btnCreateIDD");
	private By saveBy = By.id("savebttn3");
	private By calculateDutyBy = By.id("makepayment");

	private By addInvoiceBy = By.id("addinvoice");

//	Declaration Documents
	private By requiredDocumentBy = By.id("viewCCPReqDocs");

	private By requiredDocumentsLs_0By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_0_']");
//	private By requiredDocumentsLs_0By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_0_']"); //@SubType='+number' and @type='text' 
	private By requiredDocumentsLs_1By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_1_']");
	private By requiredDocumentsLs_2By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_2_']");
	private By requiredDocumentsLs_3By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_3_']");
	private By requiredDocumentsLs_4By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_4_']");
	private By requiredDocumentsLs_5By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_5_']");
	private By requiredDocumentsLs_6By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_6_']");
	private By requiredDocumentsLs_7By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_7_']");
	private By requiredDocumentsLs_8By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_8_']");
	private By requiredDocumentsLs_9By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_9_']");
	private By requiredDocumentsLs_10By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_10_']");
	private By requiredDocumentsLs_11By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_11_']");
	private By requiredDocumentsLs_12By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_12_']");
	private By saveDocumentsBy = By.id("Associate");

	private By digitalDocumentsBy = By.linkText("Digital Documents");

	private By closeDocumentsBy = By.id("btnClose");

//	Declaration Vehicles List
	private By declarationVehiclesListlnkBy = By.id("DeclarationVehicles");
	private By NewBtnBy = By.id("NewBtn");
	private By drpGatePassCategoryBy = By.id("drpGatePassCategory");
	private By drpCargoTypeBy = By.id("drpCargoType");
	private By drpTruckNCarrierSizeBy = By.id("drpTruckNCarrierSize");
	private By PN_Num1By = By.id("PN_Num1");
	private By PN_LONGNBy = By.id("PN_LONGN");
	private By txtCivilIDBy = By.id("txtCivilID");
	private By txtWeigtBy = By.id("txtWeigt");
	private By createNewVehicleBy = By.id("SaveNewVehicle");
	private By saveContainersBy = By.id("SaveContainers");
	private By cancelDecVehicleDetailsBy = By.id("cancel");
	private By closeDecVehicleListBy = By.id("close");

	public void clickEdit() {
		findElement(editBy).click();
	}

	public void requiredDocuments() {
		findElement(requiredDocumentBy).click();
		switchToWindow();
		waitForElementToBeVisible(saveDocumentsBy);

		findElement(requiredDocumentsLs_0By).sendKeys("1");
		findElement(requiredDocumentsLs_1By).sendKeys("1");
		findElement(requiredDocumentsLs_2By).sendKeys("1");
		findElement(requiredDocumentsLs_3By).sendKeys("1");
		findElement(requiredDocumentsLs_4By).sendKeys("1");
		findElement(requiredDocumentsLs_5By).sendKeys("1");
		findElement(requiredDocumentsLs_6By).sendKeys("1");
		findElement(requiredDocumentsLs_7By).sendKeys("1");
		findElement(requiredDocumentsLs_8By).sendKeys("1");
		findElement(requiredDocumentsLs_9By).sendKeys("1");
		findElement(requiredDocumentsLs_10By).sendKeys("1");
		findElement(requiredDocumentsLs_11By).sendKeys("1");
		findElement(requiredDocumentsLs_12By).sendKeys("1");
		findElement(saveDocumentsBy).click();
		waitForElementToBeVisible(digitalDocumentsBy);
		findElement(closeDocumentsBy).click();
		driver.switchTo().window(MainWindow);

	}

	public void addDeclarationVehiclesList() {
		findElement(declarationVehiclesListlnkBy).click();
		switchToWindow();
		findElement(NewBtnBy).click();

//		Select selectGatePassCategory=new Select(findElement(drpGatePassCategoryBy));
//		selectGatePassCategory.selectByVisibleText("General loads");

//		Select selectCargoType=new Select(findElement(drpCargoTypeBy));
//		selectCargoType.selectByVisibleText("General Cargo");

//		Select selectCarrier_Size=new Select(findElement(drpTruckNCarrierSizeBy));
//		selectCarrier_Size.selectByVisibleText("Half Lorry");

//		doSelectByVisibleText(drpGatePassCategoryBy, "General loads");//332293540
		doSelectByValue(drpGatePassCategoryBy, "332293540");
		doSelectByVisibleText(drpCargoTypeBy, "General Cargo");
		doSelectByVisibleText(drpTruckNCarrierSizeBy, "Half Lorry");

		findElement(PN_Num1By).sendKeys("91");
		findElement(PN_LONGNBy).sendKeys("202298765");

		findElement(txtCivilIDBy).sendKeys("321030900015");

		findElement(txtWeigtBy).sendKeys("100");
		findElement(createNewVehicleBy).click();
		waitForElementToBeVisible(saveContainersBy);
		findElement(cancelDecVehicleDetailsBy).click();
		findElement(closeDecVehicleListBy).click();
		driver.switchTo().window(MainWindow);

	}

//	Invoice Details -->Invoice Information

	public void addInvoice() {
		doClick(By.id("addinvoice"));
		doSendKeys(By.id("orderno"), "INV202201");
		doClick(By.id("orderdateDatePicker"));
		doClick(By.id("Fx50CalenderCurrentDate"));

		doSendKeys(By.id("SupplierName"), MainWindow);

		doSendKeys(By.id("currency"), "KWD");
		doSendKeys(By.id("country"), "SA");

		doClick(By.id("SaveNewCommercialInvoiceOne"));

	}

//	Add Items -->Invoice Items
	public void addItems() {
		doClick(By.xpath("//td[@id='List_DeclarationInvoice_0_NewItem']/a"));
		doSendKeys(By.id("hscode"), "9702.00.00");
		doSendKeys(By.id("country"), "SA");
		doSendKeys(By.id("description"), "Original engravings, prints and lithographs.");
		doSendKeys(By.id("Manufacturer"), "Alex MD");
		doSendKeys(By.id("totalprice"), "100");
		doSendKeys(By.id("noofpackages"), "100");
		findElement(By.id("txtpackagetype")).sendKeys("Piece" + Keys.ENTER);
		switchToWindow();
		doClick(By.xpath("//td[@id='List_PackageTypeLsPg_0_Description']/a"));
		driver.switchTo().window(MainWindow);
		doSendKeys(By.id("quantity"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("Gross1"), "100");
		doClick(By.id("chkInfoIsCrct"));
		doClick(By.id("createnew"));

	}

	public void calculateDuty() {
		doClick(calculateDutyBy);
	}

//	Payment Information
	public void addPaymentInformation() {
		doSelectByValue(By.id("paymentmethod"), "332294082");
		doClick(By.id("next"));

		doSendKeys(By.id("CashReceiptNumber"), "2022001");
		doClick(By.id("addtopayment"));
		doClick(By.id("payment_save"));

	}

	public void submitDeclaration() {
		doClick(By.name("submitdeclaration"));
//		Disclaimer Confirmation
		switchToWindow();
		doClick(By.id("chkSubmitDeclaration"));
		doClick(By.id("btnOk"));
		driver.switchTo().window(MainWindow);
	}
}
