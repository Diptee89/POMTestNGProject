package com.pages;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

//@SuppressWarnings("unused")
public class ManifestInformationPage extends TestBase {
	public ManifestInformationPage(WebDriver driver) {
		this.driver = driver;
	}
//	private By newButtonBy = By.xpath("//input[@id='new1' and @title='Create New Manifest']");
	private By originPortBy = By.cssSelector("#OriginPort");
	private By expectedArrivalDateDatePickerBy = By.cssSelector("#ExpectedArrivalDateDatePicker");
	private By calenderCurrentDateBy = By.cssSelector(".Fx50CalenderCurrentDate");
	private By arrivaldateDatePickerBy = By.cssSelector("#arrivaldateDatePicker");
	private By vesselNameBy = By.cssSelector("#vesselname");
	private By flightNoBy = By.cssSelector("#FltNo");
	private By remarksBy = By.cssSelector("#remarks");
	private By createbttnBy = By.cssSelector("#createbttn");
	private By tempJourneyNumberBy = By.xpath("//div[@id='vwr_TmpJourneyNumber' and @class='update-text-node']");
	private By okButtonBy = By.id("okbutton");

	private By manualRemakrs = By.id("ManualRemarks");
	private By submitManiestBy = By.id("btnReqForSubJourney");
	private By chkJourneySubmitBy = By.id("chkJourneySubmit");
	private By btnOkBy = By.id("btnOk");
//	private By backBy = By.id("cancel");

	private By errorBy = By.xpath("//p[@class='errorpage_header']");

//	Approve Submission Request
	private By approveBy = By.name("ArrivedSubmitJourney");
	private By manifestNoBy = By.id("vwr_JourneyNumber");

//	Issue DO
	private By chkAllBy = By.id("chkallEQ");
	private By issueDOsBy = By.id("btnIssueDO");
	private By doNoBy = By.xpath("//td[@id='List_ViewBillsFromManifestLs_0_cell_DONO']/a");

	public void createManifest() {
		setOriginPort();
		selectExpectedArrivalDate();
		selectArrivaldate();
		setVesselName();
		setFlightNo();
		setRemarks();
		clickCreatebtn();
		confirmation();
	}

	public void submitManifest() {
		setManualRemarks();
		clickSubmitbtn();
		disclaimerConfirmation();
		confirmation();
//		clickBackbtn();
	}

	public void approveManifest() {
		clickApprovebtn();
		disclaimerConfirmation();
		approveConf();
//		clickBackbtn();
	}

	public void issueDOs() {
		findElement(chkAllBy).click();
		findElement(issueDOsBy).click();
		WebElement e = findElement(doNoBy);
		doNumber = e.getText();
		System.out.println("DO Number: " + doNumber);
//		findElement(doNoBy).click();
	}

	/*
	 * Confirmation: TMRN/8652/KWI22 Has been Submitted Successfully.
	 * 
	 */
	private void confirmation() {
		WebElement eTempManifestNo = findElement(tempJourneyNumberBy);
		tempManifestNo = eTempManifestNo.getText();

		System.out.println("Temporary Manifest Number Generated: " + tempManifestNo);

		findElement(okButtonBy).click();
	}

	/*
	 * Confirmation: MRN/7347/KWI22 Has been Approved Successfully.
	 */
	private void approveConf() {
		WebElement eManifestNo = findElement(manifestNoBy);
		manifestNo = eManifestNo.getText();

		System.out.println("Manifest Number Generated: " + manifestNo);

		findElement(okButtonBy).click();
	}

	private void disclaimerConfirmation() {
		switchToWindow();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(chkJourneySubmitBy));

		findElement(chkJourneySubmitBy).click();

		findElement(btnOkBy).click();
		driver.switchTo().window(MainWindow);
	}

	private void setOriginPort() {
		findElement(originPortBy).sendKeys("TTA" + Keys.ENTER);
	}

	private void selectExpectedArrivalDate() {
		findElement(expectedArrivalDateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
	}

	private void selectArrivaldate() {
		findElement(arrivaldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
	}

	private void setVesselName() {
		findElement(vesselNameBy).sendKeys("TNT" + Keys.ENTER);
	}

	private void setFlightNo() {
//		findElement(flightNoBy).sendKeys(strFlightNo + Keys.ENTER);

		WebElement txtFlightNo = findElement(flightNoBy);
		Random rand = new Random();
		int value = rand.nextInt(10000);
		String number = Integer.toString(value);

		txtFlightNo.sendKeys(number + Keys.ENTER);
	}

	private void setRemarks() {
		findElement(remarksBy).sendKeys("Created By Selenium Automation For Testing");

	}

	private void setManualRemarks() {

		findElement(manualRemakrs).sendKeys("Submitted");
	}

	private void clickCreatebtn() {
		findElement(createbttnBy).click();
	}

	private void clickSubmitbtn() {
		findElement(submitManiestBy).click();

	}

	private void clickApprovebtn() {

		findElement(approveBy).click();
	}

//	private void clickBackbtn() {
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 4000)", "");
//		findElement(backBy).clear();
//	}
//	private void getError() {
//		WebElement e=findElement(errorBy);
//		System.out.println(e.getText());
//	}
}
