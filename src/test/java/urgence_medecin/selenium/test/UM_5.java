package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.SeleniumTestSuite;
import urgence_medecin.selenium.page.CommonPageHelper;

public class UM_5 {

	@Test
	public void testTitreDeLaRegionDansMetaDonnee() {
		SeleniumTestSuite.getWebDriver().get("https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes");
		String title = CommonPageHelper.getPageTitle();
		assertThat(title).contains("Auvergne-rhone-alpes");
	}

}
