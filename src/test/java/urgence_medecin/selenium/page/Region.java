package urgence_medecin.selenium.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import urgence_medecin.selenium.driver.DriverManager;

public class Region {

	private Region() {
	}

	public static Region getPage() {
		return new Region();
	}

	public List<String> getDepartementsHref() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		return chromeDriver.findElements(By.xpath("//div[contains(@class,'et_pb_text_9')]//td/a")).stream()
				.map(e -> e.getAttribute("href")).collect(Collectors.toList());
	}
}
