package urgence_medecin.selenium.driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = null;
	private static ThreadLocal<WebDriver> mobileDriver = null;
	private static ThreadLocal<WebDriverWait> driverWait = null;
	private static ThreadLocal<WebDriverWait> mobileDriverWait = null;

	private DriverManager() {
	}

	public static WebDriver getChromeDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			driver = new ThreadLocal<WebDriver>() {
				@Override
				protected WebDriver initialValue() {
					return new ChromeDriver(options);
				}
			};
		}
		return driver.get();
	}

	public static WebDriver getChromeMobileDriver() {
		if (mobileDriver == null) {
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Nexus 5");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("incognito");
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			mobileDriver = new ThreadLocal<WebDriver>() {
				@Override
				protected WebDriver initialValue() {
					return new ChromeDriver(chromeOptions);
				}
			};
		}
		return mobileDriver.get();

	}

	public static WebDriverWait getWebDriverWait() {
		if (driverWait == null) {
			driverWait = new ThreadLocal<WebDriverWait>() {
				@Override
				protected WebDriverWait initialValue() {
					return new WebDriverWait(getChromeDriver(), 10);
				}
			};
		}
		return driverWait.get();
	}

	public static WebDriverWait getWebMobileDriverWait() {
		if (mobileDriverWait == null) {
			mobileDriverWait = new ThreadLocal<WebDriverWait>() {
				@Override
				protected WebDriverWait initialValue() {
					return new WebDriverWait(getChromeMobileDriver(), 10);
				}
			};
		}
		return mobileDriverWait.get();
	}

}
