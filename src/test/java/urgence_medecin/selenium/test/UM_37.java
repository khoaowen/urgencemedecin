package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Departement;
import urgence_medecin.selenium.page.SiteMap;

public class UM_37 {

	@Test
	public void test_region_departement_url_coherence() {
		TestSuiteSelenium.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/custom-sitemap/departement-sitemap.xml");
		SiteMap siteMap = SiteMap.getPage();
		List<String> allUrls = siteMap.getAllUrls();

		allUrls.forEach(e -> {
			TestSuiteSelenium.getWebDriver().get(e);
			Departement departement = Departement.getPage();
			String regionInUrl = TestSuiteSelenium.getWebDriver().getCurrentUrl().split("/")[1];
			assertThat(departement.getAltLogoDepartement("src")).contains(regionInUrl);
		});
	}

}
