package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class HouseBillPage {
	protected WebDriver driver;

	private By newBy = By.cssSelector("input#new1[title='Create New Bill Of Lading'][class='mcbutton']");
	private By houseBillNoBy = By.cssSelector("#billnumber[name='billnumber'][Attribute='HouseBillNumber']");
	private By housebilldateDatePickerBy = By.cssSelector("#housebilldateDatePicker[class='mcCalendarButton']");
	private By calenderCurrentDateBy = By.cssSelector(".Fx50CalenderCurrentDate");
	private By unregisteredConsigneeBy = By.cssSelector("#UnregisteredConsignee[Attribute='UnregisteredConsignee']");
	private By descriptionBy = By.id("description");
	private By tgWeightBy = By.id("Tgweight");
	private By tquantityManifestedBy = By.id("Tquantitymanifested");
	private By originPortBy = By.id("OriginPort");
	private By createBy = By.cssSelector("#submit10[title='Create'][class='mcbutton']");
	private By backBy = By.cssSelector("#cancel[value='Back']");

	public HouseBillPage(WebDriver driver) {
		this.driver = driver;
	}

	public void createBL() {
		clickNew();
		setHouseBill();

		driver.findElement(housebilldateDatePickerBy).click();
		driver.findElement(calenderCurrentDateBy).click();

//		Goods Details
		driver.findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");

		driver.findElement(descriptionBy).sendKeys("Oil");

		driver.findElement(tgWeightBy).sendKeys("100" + Keys.TAB);

		driver.findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)", "");

		driver.findElement(originPortBy).sendKeys("%%" + Keys.TAB);

		driver.findElement(createBy).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 3000)", "");
		driver.findElement(backBy).click();

	}

	private void clickNew() {
		WebElement eNewbtn = driver.findElement(newBy);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", eNewbtn);

		eNewbtn.click();
	}

	private void setHouseBill() {
		WebElement txtHBL = driver.findElement(houseBillNoBy);
//		txtHBL.clear();
		Random rand = new Random();
		int value = rand.nextInt(10000);
		String HBL = Integer.toString(value);

		txtHBL.sendKeys("HBL/" + HBL+"/KWI");
	}
}
