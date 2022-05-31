package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class CustomsBayanPage extends TestBase {
	
	public String tempDeclarationNo;
	public CustomsBayanPage(WebDriver driver) {
		this.driver = driver;
	}

//	private By menuNavigateIconBy=By.cssSelector(".menuNavigateIcon");
	private By dectypeBy = By.id("dectype");
	private By consigneebrowsebuttonBy = By.id("consigneebrowsebutton");
	private By peopleBy = By.id("people");
	private By firstNameBy = By.id("FirstName");
	private By peopleDetails_0_FirstNameBy = By.xpath("//td[@id='List_ListPeopleDetails_0_FirstName']/a");
	private By txtReMarksBy = By.id("txtReMarks");
	private By savebttnBy = By.id("savebttn");
	private By tempDeclNumberBy = By.xpath("//td[@id='TempDeclNumber']/div");
//	private By cancelBy=By.id("cancel");

	public void createBayan() {
//		selectDecType(); //as in application default selected IMPORT
		selectImporter();
		findElement(txtReMarksBy).sendKeys("Created By Automation");
		findElement(savebttnBy).click();
		getTempDeclNumber();
	}

	private void selectDecType() {
		Select selectlist = new Select(findElement(dectypeBy));
		selectlist.selectByVisibleText("IMPORT");
	}

	private void selectImporter() {
		findElement(consigneebrowsebuttonBy).click();
		switchToWindow();
		waitForElementToBeVisible(peopleBy);
		findElement(peopleBy).click();
		findElement(firstNameBy).sendKeys("AGILITY PWC" + Keys.ENTER);
		waitForElementToBeVisible(peopleDetails_0_FirstNameBy);
		findElement(peopleDetails_0_FirstNameBy).click();
		driver.switchTo().window(MainWindow);
	}

	private String getTempDeclNumber() {
		tempDeclarationNo=findElement(tempDeclNumberBy).getText();
		System.out.println(tempDeclarationNo);
		return tempDeclarationNo;
	}
}
