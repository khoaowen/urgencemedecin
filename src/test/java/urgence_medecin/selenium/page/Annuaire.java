package urgence_medecin.selenium.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import urgence_medecin.selenium.driver.DriverManager;

public class Annuaire {

	private Annuaire() {
	}

	public static Annuaire getPage() {
		return new Annuaire();
	}

	public List<String> getRegionsHref() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		return chromeDriver.findElements(By.xpath("//div[contains(@class,'col-1-3')]//a")).stream()
				.map(e -> e.getAttribute("href")).collect(Collectors.toList());
	}
}
