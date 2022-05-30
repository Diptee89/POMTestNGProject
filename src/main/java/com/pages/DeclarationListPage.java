package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class DeclarationListPage extends TestBase {
	public DeclarationListPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By menuNavigateIconBy=By.cssSelector(".menuNavigateIcon");
	private By mainMenuDeclarationBy=By.xpath("//div[@id='mainMenuItemVertical_Declaration']/a");
//	private By subMenuDeclarationBy=By.linkText("Declaration");
	private By subMenuDeclarationBy=By.xpath("//div[@class='subMenuWrapperDynamic_vertical' and @id='subMenuWrapperDynamicVertical_Declaration']/div[2]/div[2]/a");
	private By parent_frmSearchDiv_SearchBy=By.id("parent_frmSearchDiv_Search");
	private By tempDeclarationNoBy=By.name("TempSADNo");
	private By declarationNoBy=By.name("SADNo");
	private By searchBy=By.xpath("//input[@title='Search']");
	
	private By listDeclaration_0_TempDeclNumberBy=By.xpath("//td[@id='List_ListDeclaration_0_TempDeclNumber' and @class='mcontent-text']/a");

		
	public void clickDeclarationSubMenu() {
		Actions act = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(menuNavigateIconBy));

		driver.findElement(menuNavigateIconBy).click();

		WebElement eleMenu = driver.findElement(mainMenuDeclarationBy); // cssSelector("#mainMenuItemVertical_Manifest")
		// Mouse over in Developers menu then click on Status sub menu.
		act.moveToElement(eleMenu).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(subMenuDeclarationBy));

		driver.findElement(subMenuDeclarationBy).click();

	}
	public void searchByTempDec(String strTempDecNo) {
		findElement(parent_frmSearchDiv_SearchBy).click();
//		findElement(tempDeclarationNoBy).sendKeys(tempDeclarationNo+Keys.ENTER);
//		findElement(tempDeclarationNoBy).sendKeys("TIM/29636/KWI22"+Keys.ENTER);
		findElement(tempDeclarationNoBy).sendKeys(strTempDecNo+Keys.ENTER);
		}
	public void clickTempNo() {
		findElement(listDeclaration_0_TempDeclNumberBy).click();
	}
}
