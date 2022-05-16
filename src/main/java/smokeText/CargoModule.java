package smokeText;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CargoModule {
static WebDriver driver=null;
	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "c:\\Drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");

	}

}
