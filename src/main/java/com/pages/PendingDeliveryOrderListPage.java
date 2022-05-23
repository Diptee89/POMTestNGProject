package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.base.TestBase;

public class PendingDeliveryOrderListPage extends TestBase {
	public PendingDeliveryOrderListPage(WebDriver driver) {
		this.driver = driver;
	}

	private By menuNavigateIconBy = By.cssSelector(".menuNavigateIcon");
	private By mainMenuDeclarationBy = By.xpath("//div[@id='mainMenuItemVertical_Declaration']/a");
	private By subMenuPendingDOBy = By.linkText("Pending D.O");
	private By frmSearchDiv_SearchBy = By.className("frmSearchDiv_Search");
	private By DONoBy = By.name("DONo");
	private By securityNoBy = By.name("IDNO");
	private By searchBy = By.className("mcSearchbutton");
	private By deliveryOrderNoBy = By.xpath("//td[@id='List_listdeliveryorder_0_DeliveryOrderNumber']/a");
	private By declarBy = By.xpath("//td[@id='List_listdeliveryorder_0_ECABAAA']/a");

	public void clickPendingDOSubMenu() {
		clickDeclarationMenu();
		findElement(subMenuPendingDOBy).click();
	}

	private void clickDeclarationMenu() {
		Actions act = new Actions(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(menuNavigateIconBy));

		findElement(menuNavigateIconBy).click();
		// Mouse over in Developers menu then click on Status sub menu.
		act.moveToElement(findElement(mainMenuDeclarationBy)).build().perform();
	}

	public void searchWithDO() {
		findElement(frmSearchDiv_SearchBy).click();
//		findElement(DONoBy).sendKeys(doNumber + Keys.ENTER);
		findElement(DONoBy).sendKeys("DO/54872/KWI22" + Keys.ENTER);
	}

	public void clickDeclare() {
		findElement(declarBy).click();
	}
}
