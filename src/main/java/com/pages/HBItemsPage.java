package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class HBItemsPage extends TestBase {
	public HBItemsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void createHBItems() {
		doClick(By.id("btnNew"));

//		doSelectByValue(By.id("cmbKind"), "33224107");
//		doSelectByVisibleText(By.xpath("//select[@id='cmbKind and @class='clsDLbl']"), "CONTAINER");
//		doClick(By.xpath("//select[@id='cmbKind and @class='clsDLbl']"));

		Select select = new Select(findElement(By.xpath("//select[@id='cmbKind and @class='clsDLbl']")));
		select.selectByVisibleText("CONTAINER");
		doSendKeys(By.id("txtContainerNo"), "POIU7654321");
		doSendKeys(By.id("txtContainerSizeDesc"), "20 ft");
		doSendKeys(By.id("txtQty"), "100");
		doSendKeys(By.id("txtQtyUOMDesc"), "Pieces");
		doSendKeys(By.id("txtGWt"), "100");
		doSendKeys(By.id("txtGrossUOMDesc"), "Kilograms");
		doSendKeys(By.id("txtTWt"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilograms");
		doSendKeys(By.id("txtsealNo"), "S00101");
		;
		doClick(By.id("btnCreate"));
		doClick(By.cssSelector("#cancel[value='Back']"));
	}
}
