package smokeText;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CargoModule {
	static WebDriver driver = null;
	static WebDriverWait wait = null;
	static Actions act;
	static String tempManifestNo;
	static String MainWindow;

	public static void main(String[] args) {

		setUP();
		login("nas.csa", "fx5test");

		clickCargoMenu();
		createManifest("00007");
		confirmation();
		createBL("HBL/0005/KWI22");
		submitManifest();
		confirmation();
//		driver.close();

	}

	public static void setUP() {
		System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);

		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
		System.out.println(driver.getTitle());
		switchToWindow();
	}

	public static void switchToWindow() {
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

	public static void login(String id, String pwd) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.FX50loginPanelTextBox")));
		WebElement field1 = driver.findElement(By.cssSelector("input.FX50loginPanelTextBox"));
		clearAndType(field1, id);

		driver.findElement(By.cssSelector("#sUserPassword")).click();
		driver.findElement(By.cssSelector(".FX50loginPanelLoginButton")).click();

	}

	private static void clearAndType(WebElement field, String text) {
		field.clear();
		field.sendKeys(text);
	}

	public static void clickCargoMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#MenuLabel_Vertical")));

		driver.findElement(By.cssSelector("#MenuLabel_Vertical")).click();

		WebElement eleMenu = driver.findElement(
				By.xpath("//div[@id='mainMenuItemVertical_Manifest' and @class='mainMenuItem_vertical']/a")); // cssSelector("#mainMenuItemVertical_Manifest")
		// Mouse over in Developers menu then click on Status sub menu.
		act.moveToElement(eleMenu).build().perform();

		driver.findElement(By.linkText("Manifest")).click();
	}

	public static void createManifest(String flightNo) {
		driver.findElement(By.xpath("//input[@id='new1' and @title='Create New Manifest']")).click();

//		Manifest Information
		driver.findElement(By.cssSelector("#OriginPort")).sendKeys("TTA" + Keys.ENTER);

		driver.findElement(By.cssSelector("#ExpectedArrivalDateDatePicker")).click();
		driver.findElement(By.cssSelector(".Fx50CalenderCurrentDate")).click();

		driver.findElement(By.cssSelector("#arrivaldateDatePicker")).click();
		driver.findElement(By.cssSelector(".Fx50CalenderCurrentDate")).click();

		driver.findElement(By.cssSelector("#vesselname")).sendKeys("TNT" + Keys.ENTER);
		driver.findElement(By.cssSelector("#FltNo")).sendKeys(flightNo + Keys.ENTER);

		driver.findElement(By.cssSelector("#remarks")).sendKeys("Created By Selenium Automation For Testing");

		driver.findElement(By.cssSelector("#createbttn")).click();

	}

	public static void confirmation() {
		WebElement eTempManifestNo = driver
				.findElement(By.xpath("//div[@id='vwr_TmpJourneyNumber' and @class='update-text-node']"));
		tempManifestNo = eTempManifestNo.getText();

		System.out.println("Temporary Manifest Number Generated: " + tempManifestNo);

		driver.findElement(By.id("okbutton")).click();
	}

	public static void createBL(String billNo) {
		WebElement eNewbtn = driver
				.findElement(By.cssSelector("input#new1[title='Create New Bill Of Lading'][class='mcbutton']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", eNewbtn);

		eNewbtn.click();

		driver.findElement(By.cssSelector("#billnumber[name='billnumber'][Attribute='HouseBillNumber']"))
				.sendKeys(billNo);

		driver.findElement(By.cssSelector("#housebilldateDatePicker[class='mcCalendarButton']")).click();
		driver.findElement(By.cssSelector(".Fx50CalenderCurrentDate")).click();

//		Goods Details
		driver.findElement(By.cssSelector("#UnregisteredConsignee[Attribute='UnregisteredConsignee']"))
				.sendKeys("Alex MD Husain");

		driver.findElement(By.id("description")).sendKeys("Oil");

		driver.findElement(By.id("Tgweight")).sendKeys("100" + Keys.TAB);

		driver.findElement(By.id("Tquantitymanifested")).sendKeys("100" + Keys.TAB);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)", "");

		driver.findElement(By.id("OriginPort")).sendKeys("%%" + Keys.TAB);

		driver.findElement(By.cssSelector("#submit10[title='Create'][class='mcbutton']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 3000)", "");
		driver.findElement(By.cssSelector("#cancel[value='Back']")).click();

	}

	public static void submitManifest() {
		driver.findElement(By.id("ManualRemarks")).sendKeys("Submitted");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)", "");
		driver.findElement(By.id("btnReqForSubJourney")).click();

		switchToWindow();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkJourneySubmit")));
		driver.findElement(By.id("chkJourneySubmit")).click();

		driver.findElement(By.id("btnOk")).click();
		driver.switchTo().window(MainWindow);
	}
}
