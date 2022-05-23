package com.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

//@SuppressWarnings("unused")
public class HouseBillPage extends TestBase{
	public HouseBillPage(WebDriver driver) {
		this.driver=driver;
	}
	
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


	public void createBL() {
		clickNew();
		setHouseBill();
		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		findElement(createBy).click();
		findElement(backBy).click();
	}

	private void clickNew() {
		findElement(newBy).click();
	}

	private void setHouseBill() {
		Random rand = new Random();
		int value = rand.nextInt(10000);
		String number = Integer.toString(value);
		findElement(houseBillNoBy).sendKeys("HBL/" +number+"/KWI");
	}
}
