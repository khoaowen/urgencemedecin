package urgence_medecin.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import urgence_medecin.selenium.driver.DriverManager;

public class Ville {

	private Ville() {
	}

	public static Ville getPage() {
		return new Ville();
	}

	public WebElement getDescriptionElement() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		return chromeDriver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_1']//p//b"));
	}

}
