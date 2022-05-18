package pages;

import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManifestInformationPage {
	protected WebDriver driver;
	String MainWindow;
	public String tempManifestNo;
	public String manifestNo;
	public String doNumber;

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
	private By manifestNoBy=By.id("vwr_JourneyNumber");
	
//	Issue DO
	private By chkAllBy=By.id("chkallEQ");
	private By issueDOsBy=By.id("btnIssueDO");
	private By doNoBy=By.xpath("//td[@id='List_ViewBillsFromManifestLs_0_cell_DONO']/a");

	public ManifestInformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void createManifest(String flightNo) {
		setOriginPort();
		selectExpectedArrivalDate();
		selectArrivaldate();
		setVesselName();
		setFlightNo(flightNo);
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
		driver.findElement(chkAllBy).click();
		driver.findElement(issueDOsBy).click();
		WebElement e=driver.findElement(doNoBy);
		doNumber=e.getText();
		System.out.println("DO Number: "+doNumber);
//		driver.findElement(doNoBy).click();
	}

	/*
	 * Confirmation: TMRN/8652/KWI22 Has been Submitted Successfully.
	 * 
	 */
	private void confirmation() {
		WebElement eTempManifestNo = driver.findElement(tempJourneyNumberBy);
		tempManifestNo = eTempManifestNo.getText();

		System.out.println("Temporary Manifest Number Generated: " + tempManifestNo);

		driver.findElement(okButtonBy).click();
	}

	/*
	 * Confirmation: MRN/7347/KWI22 Has been Approved Successfully.
	 */
	private void approveConf() {
		WebElement eManifestNo = driver.findElement(manifestNoBy);
		manifestNo = eManifestNo.getText();

		System.out.println("Manifest Number Generated: " + manifestNo);

		driver.findElement(okButtonBy).click();
	}

	private void disclaimerConfirmation() {
		switchToWindow();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(chkJourneySubmitBy));

		driver.findElement(chkJourneySubmitBy).click();

		driver.findElement(btnOkBy).click();
		driver.switchTo().window(MainWindow);
	}

	private void switchToWindow() {
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

	private void setOriginPort() {
		driver.findElement(originPortBy).sendKeys("TTA" + Keys.ENTER);
	}

	private void selectExpectedArrivalDate() {
		driver.findElement(expectedArrivalDateDatePickerBy).click();
		driver.findElement(calenderCurrentDateBy).click();
	}

	private void selectArrivaldate() {
		driver.findElement(arrivaldateDatePickerBy).click();
		driver.findElement(calenderCurrentDateBy).click();
	}

	private void setVesselName() {
		driver.findElement(vesselNameBy).sendKeys("TNT" + Keys.ENTER);
	}

	private void setFlightNo(String strFlightNo) {
		driver.findElement(flightNoBy).sendKeys(strFlightNo + Keys.ENTER);
//		txtVesselName.clear();
//		Random rand = new Random();
//		int value = rand.nextInt(1000);
//		String gShipName = Integer.toString(value);
//
//		txtVesselName.sendKeys(testData + gShipName);
//		shipName = testData + gShipName;
//		System.out.println("GetText " + shipName);
	}

	private void setRemarks() {
		driver.findElement(remarksBy).sendKeys("Created By Selenium Automation For Testing");

	}

	private void setManualRemarks() {

		driver.findElement(manualRemakrs).sendKeys("Submitted");
	}

	private void clickCreatebtn() {
		driver.findElement(createbttnBy).click();
	}

	private void clickSubmitbtn() {
		driver.findElement(submitManiestBy).click();

	}

	private void clickApprovebtn() {

		driver.findElement(approveBy).click();
	}

//	private void clickBackbtn() {
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 4000)", "");
//		driver.findElement(backBy).clear();
//	}
//	private void getError() {
//		WebElement e=driver.findElement(errorBy);
//		System.out.println(e.getText());
//	}
}
