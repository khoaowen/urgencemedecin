package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.SiteMap;

public class CrawlAnnuaire {

	private static final int NUMBER_OF_THREADS = 32;

	@Test
	public void crawlAllRegions() throws InterruptedException, ExecutionException {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/custom-sitemap/region-sitemap.xml");
		SiteMap siteMap = SiteMap.getPage();
		List<String> allUrls = siteMap.getAllUrls();

		crawlUrls(allUrls);
	}

	private void crawlUrls(List<String> allUrls) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		final int NUMBER_OF_ITEMS = allUrls.size();

		int minItemsPerThread = NUMBER_OF_ITEMS / NUMBER_OF_THREADS;
		int maxItemsPerThread = minItemsPerThread + 1;
		int threadsWithMaxItems = NUMBER_OF_ITEMS - NUMBER_OF_THREADS * minItemsPerThread;
		int start = 0;
		List<Future<?>> futures = new ArrayList<Future<?>>(NUMBER_OF_ITEMS);
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			int itemsCount = (i < threadsWithMaxItems ? maxItemsPerThread : minItemsPerThread);
			int end = start + itemsCount;
			Runnable r = new PageCrawler(allUrls.subList(start, end));
			futures.add(service.submit(r));
			start = end;
		}
		for (Future<?> f : futures) {
			f.get();
		}
	}

	@Test
	public void crawlAllDepartements() throws InterruptedException, ExecutionException {
		TestSuiteSelenium.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/custom-sitemap/departement-sitemap.xml");
		SiteMap siteMap = SiteMap.getPage();
		List<String> allUrls = siteMap.getAllUrls();
		crawlUrls(allUrls);
	}

	@Test
	public void crawlAllVilles() throws InterruptedException, ExecutionException {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/custom-sitemap/ville-sitemap.xml");
		SiteMap siteMap = SiteMap.getPage();
		List<String> allUrls = siteMap.getAllUrls();
		crawlUrls(allUrls);
	}

	private class PageCrawler implements Runnable {
		private final List<String> urls;
		private final ChromeDriver chromeDriver;

		public PageCrawler(List<String> urls) {
			this.urls = urls;
			this.chromeDriver = createChromeDriver();
		}

		private ChromeDriver createChromeDriver() {
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
			return new ChromeDriver(options);
		}

		@Override
		public void run() {
			urls.forEach(e -> {
				chromeDriver.get(e);
				assertThat(chromeDriver.getCurrentUrl()).contains(e);
			});
			chromeDriver.close();
		}

	}

}
