package urgence_medecin.selenium.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;

public class CommonPageHelper {

	private CommonPageHelper() {

	}

	public static String getPageTitle() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathTitle = "//head/title";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(e -> {
			return e.findElement(By.xpath(xpathTitle));
		});
		return chromeDriver.findElement(By.xpath(xpathTitle)).getAttribute("innerText");
	}
}
