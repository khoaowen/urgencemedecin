package urgence_medecin.selenium.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;

public class Ville {

	private Ville() {
	}

	public static Ville getPage() {
		return new Ville();
	}

	public String getDescriptionElement() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[@class='et_pb_row et_pb_row_1']//p//b";
		webDriverWait.withTimeout(Duration.ofSeconds(10))
				.until(d -> d.findElement(By.xpath(xpathExpression)));
		return chromeDriver.findElement(By.xpath(xpathExpression)).getText();
	}

}
