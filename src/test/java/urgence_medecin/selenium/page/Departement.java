package urgence_medecin.selenium.page;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;

public class Departement {

	private Departement() {

	}

	public static Departement getPage() {
		return new Departement();
	}

	WebDriver chromeDriver = DriverManager.getChromeDriver();

	public List<String> getMedecinParVillesHref() {
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,'et_pb_text_13')]//td/a";
		webDriverWait.withTimeout(Duration.ofSeconds(10))
				.until(d -> chromeDriver.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute("href"))
				.collect(Collectors.toList());
	}

}
