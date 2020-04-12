package urgence_medecin.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;
import urgence_medecin.selenium.test.UM_1;
import urgence_medecin.selenium.test.UM_10;
import urgence_medecin.selenium.test.UM_11;
import urgence_medecin.selenium.test.UM_21;
import urgence_medecin.selenium.test.UM_26;
import urgence_medecin.selenium.test.UM_27;
import urgence_medecin.selenium.test.UM_28;
import urgence_medecin.selenium.test.UM_3;
import urgence_medecin.selenium.test.UM_32;
import urgence_medecin.selenium.test.UM_4;
import urgence_medecin.selenium.test.UM_5;
import urgence_medecin.selenium.test.UM_9;

@RunWith(Suite.class)
@Suite.SuiteClasses({ UM_1.class, UM_4.class, UM_3.class, UM_5.class, UM_9.class, UM_10.class, UM_11.class, UM_21.class,
		UM_27.class, UM_28.class, UM_32.class, UM_26.class })
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
