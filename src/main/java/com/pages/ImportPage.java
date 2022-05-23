package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class ImportPage extends TestBase {
	public ImportPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By editBy=By.id("edit");
	private By cancelBy=By.id("cancel");
	private By validateDecVehBy=By.id("ValidateDecVeh");
	private By cmdCancelDecBy=By.id("cmdCancelDec");
	private By ddFormBy=By.id("btnCreateIDD");
	private By saveBy=By.id("savebttn3");
	private By calculateDutyBy=By.id("makepayment");
	private By declarationVehiclesBy=By.id("DeclarationVehicles");

	private By addInvoiceBy=By.id("addinvoice");
	
//	Declaration Documents
	private By requiredDocumentBy=By.id("viewCCPReqDocs");
	private By requiredDocumentsLs_0By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_0_");
	private By requiredDocumentsLs_1By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_1_");
	private By requiredDocumentsLs_2By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_2_");
	private By requiredDocumentsLs_3By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_3_");
	private By requiredDocumentsLs_4By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_4_");
	private By requiredDocumentsLs_5By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_5_");
	private By requiredDocumentsLs_6By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_6_");
	private By requiredDocumentsLs_7By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_7_");
	private By requiredDocumentsLs_8By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_8_");
	private By requiredDocumentsLs_9By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_9_");
	private By requiredDocumentsLs_10By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_10_");
	private By requiredDocumentsLs_11By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_11_");
	private By requiredDocumentsLs_12By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_12_");
	private By saveDocumentsBy=By.id("Associate");
	private By closeDocumentsBy=By.id("btnClose");
			
	
	public void clickEdit() {
		findElement(editBy).click();
	}
	public void requiredDocuments() {
		findElement(requiredDocumentBy).click();
		switchToWindow();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(saveDocumentsBy));

//		findElement(requiredDocumentsLs_0By).sendKeys("1");
//		findElement(requiredDocumentsLs_1By).sendKeys("1");
//		findElement(requiredDocumentsLs_2By).sendKeys("1");
//		findElement(requiredDocumentsLs_3By).sendKeys("1");
//		findElement(requiredDocumentsLs_4By).sendKeys("1");
//		findElement(requiredDocumentsLs_5By).sendKeys("1");
//		findElement(requiredDocumentsLs_6By).sendKeys("1");
//		findElement(requiredDocumentsLs_7By).sendKeys("1");
//		findElement(requiredDocumentsLs_8By).sendKeys("1");
//		findElement(requiredDocumentsLs_9By).sendKeys("1");
//		findElement(requiredDocumentsLs_10By).sendKeys("1");
//		findElement(requiredDocumentsLs_11By).sendKeys("1");
//		findElement(requiredDocumentsLs_12By).sendKeys("1");
//		findElement(saveDocumentsBy).click();
		findElement(closeDocumentsBy).click();
		driver.switchTo().window(MainWindow);
		
		
	}
	
	
	
	
}
