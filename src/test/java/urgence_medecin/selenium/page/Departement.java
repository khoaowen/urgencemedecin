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

	public String getMedecinDeGardeDepartementTitle() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,\"et_pb_row_inner_0\")]//h1";
		webDriverWait.withTimeout(Duration.ofSeconds(10))
				.until(d -> chromeDriver.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElement(By.xpath(xpathExpression)).getAttribute("innerText");
	}

	public List<String> getMedecinParVillesHyperLink(String attribute) {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,'et_pb_text_13')]//td/a";
		webDriverWait.withTimeout(Duration.ofSeconds(10))
				.until(d -> chromeDriver.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute(attribute))
				.collect(Collectors.toList());
	}

	public String getVilleSaintEtienneText() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,'et_pb_text_13')]//td/a";
		webDriverWait.withTimeout(Duration.ofSeconds(10))
				.until(d -> chromeDriver.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute("innerText"))
				.filter(e -> e.contains("SAINT-ETIENNE")).findAny().get();
	}

	public List<String> getDepartementsDeLaRegion(String attribute) {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "(//ul[@class=\"special-list\"])[2]//a";
		webDriverWait.withTimeout(Duration.ofSeconds(10))
				.until(d -> chromeDriver.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute(attribute))
				.collect(Collectors.toList());
	}

}
