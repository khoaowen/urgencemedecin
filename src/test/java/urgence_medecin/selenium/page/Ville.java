package urgence_medecin.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import urgence_medecin.selenium.driver.DriverManager;

public class Ville {

	private Ville() {
	}

	public static Ville getPage() {
		return new Ville();
	}

	public String getDescriptionElement() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		return chromeDriver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_1']//p//b")).getText();
	}

}
