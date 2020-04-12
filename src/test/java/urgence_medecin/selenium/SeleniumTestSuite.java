package urgence_medecin.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;
import urgence_medecin.selenium.test.UM_26;
import urgence_medecin.selenium.test.UM_5;

@RunWith(Suite.class)
@Suite.SuiteClasses({ UM_5.class, UM_26.class })
public class SeleniumTestSuite {

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

	public static WebDriver getWebDriver() {
		if (webDriver == null) {
			initalize();
		}
		return webDriver;
	}

	public static WebDriverWait getWebDriverWait() {
		if (webDriverWait == null) {
			initalize();
		}
		return webDriverWait;
	}

}
