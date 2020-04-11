package urgence_medecin.selenium.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;

public class AbstractTest {
	protected static WebDriver webDriver;
	protected static WebDriverWait webDriverWait;

	@BeforeClass
	public static void initalize() {
		webDriver = DriverManager.getChromeDriver();
		webDriverWait = DriverManager.getWebDriverWait();
	}

	@AfterClass
	public static void tearDown() {
		webDriver.close();
	}

}
