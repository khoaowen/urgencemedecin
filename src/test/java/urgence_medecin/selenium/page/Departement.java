package urgence_medecin.selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import urgence_medecin.selenium.driver.DriverManager;

public class Departement {

	private Departement() {

	}

	public static Departement getPage() {
		return new Departement();
	}

	public List<WebElement> getHyperLinksOfMedecinParVilles() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		return chromeDriver.findElements(By.xpath("//div[contains(@class,'et_pb_text_13')]//td/a"));
	}

}
