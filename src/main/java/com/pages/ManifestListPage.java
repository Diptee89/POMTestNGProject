package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

 
//@SuppressWarnings("unused")
public class ManifestListPage extends TestBase{
	public ManifestListPage(WebDriver driver) {
		this.driver = driver;
	}
	private By menuNavigateIconBy=By.cssSelector("#MenuLabel_Vertical");
	private By mainMenuCargoBy=By.xpath("//div[@id='mainMenuItemVertical_Manifest' and @class='mainMenuItem_vertical']/a");
	private By subMenuManifestBy=By.linkText("Manifest");
	private By newButtonBy=By.xpath("//input[@id='new1' and @title='Create New Manifest']");
//	Search
	private By searchBy=By.id("parent_frmSearchDiv_Search");
	private By tempMNFNoBy=By.name("Temp.No");
	private By manifestNoBy=By.name("JourneyNumber");
//	private By searchbtnBy=By.className("mcSearchbutton");
	
//	Calender Search
	private By calenderBy=By.id("parent_frmSearchDiv_Calendar");
	private By todayDateBy=By.xpath("//span[@id='FixedCalendarTodayAnchor']/a");
	
	private By tempLinkBy=By.xpath("//tr[@id='List_journey_0_' and @class='DataGridItem_Row']/td[2]/a");
	
	public void clickCargoMenu() {
		Actions act = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(menuNavigateIconBy));

		findElement(menuNavigateIconBy).click();

		act.moveToElement(findElement(mainMenuCargoBy)).build().perform();

		findElement(subMenuManifestBy).click();

	}
	
	public void searchWithCalender() {
		findElement(calenderBy).click();
		findElement(todayDateBy).click();
		
	}
	public void searchWithTempNo(String tempNo) {
		findElement(searchBy).click();
		findElement(tempMNFNoBy).sendKeys(tempNo+Keys.ENTER);	
		
//		driver.findElement(tempMNFNoBy).sendKeys(tempNo);
//		driver.findElement(searchbtnBy).click();
	}
	public void seachWithManifestNo(String strManifestNo) {
		findElement(searchBy).click();
		findElement(manifestNoBy).sendKeys(strManifestNo+Keys.ENTER);
	}
	public void clickTempNo() {
		findElement(tempLinkBy).click();
	}
	public void clickNew() {
//		Click on new button 
		findElement(newButtonBy).click();
	}
}
