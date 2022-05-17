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
	String tempManifestNo;

	private By newButtonBy = By.xpath("//input[@id='new1' and @title='Create New Manifest']");
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

	public ManifestInformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void createManifest(String flightNo) {
//		Click on new button 
		driver.findElement(newButtonBy).click();
//		Manifest Information
		driver.findElement(originPortBy).sendKeys("TTA" + Keys.ENTER);

		driver.findElement(expectedArrivalDateDatePickerBy).click();
		driver.findElement(calenderCurrentDateBy).click();

		driver.findElement(arrivaldateDatePickerBy).click();
		driver.findElement(calenderCurrentDateBy).click();

		driver.findElement(vesselNameBy).sendKeys("TNT" + Keys.ENTER);
		driver.findElement(flightNoBy).sendKeys(flightNo + Keys.ENTER);

		driver.findElement(remarksBy).sendKeys("Created By Selenium Automation For Testing");

		driver.findElement(createbttnBy).click();
		confirmation();
	}

	private void confirmation() {
		WebElement eTempManifestNo = driver.findElement(tempJourneyNumberBy);
		tempManifestNo = eTempManifestNo.getText();

		System.out.println("Temporary Manifest Number Generated: " + tempManifestNo);

		driver.findElement(okButtonBy).click();
	}

	public void submitManifest() {
		driver.findElement(manualRemakrs).sendKeys("Submitted");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)", "");
		driver.findElement(submitManiestBy).click();

		switchToWindow();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(chkJourneySubmitBy));

		driver.findElement(chkJourneySubmitBy).click();

		driver.findElement(btnOkBy).click();
		driver.switchTo().window(MainWindow);
		confirmation();
	}

	private void switchToWindow() {
		MainWindow = driver.getWindowHandle();
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
}
