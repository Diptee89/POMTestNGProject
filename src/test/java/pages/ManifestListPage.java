package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManifestListPage {
	protected WebDriver driver;
	
	private By menuLableBy=By.cssSelector("#MenuLabel_Vertical");
	private By mainMenuCargoBy=By.xpath("//div[@id='mainMenuItemVertical_Manifest' and @class='mainMenuItem_vertical']/a");
	private By subMenuManifestBy=By.linkText("Manifest");
	private By newButtonBy=By.xpath("//input[@id='new1' and @title='Create New Manifest']");
	
	
	
	public ManifestListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCargoMenu() {
		Actions act = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(menuLableBy));

		driver.findElement(menuLableBy).click();

		WebElement eleMenu = driver.findElement(mainMenuCargoBy); // cssSelector("#mainMenuItemVertical_Manifest")
		// Mouse over in Developers menu then click on Status sub menu.
		act.moveToElement(eleMenu).build().perform();

		driver.findElement(subMenuManifestBy).click();
//		Click on new button 
//		driver.findElement(newButtonBy).click();
	}

}
