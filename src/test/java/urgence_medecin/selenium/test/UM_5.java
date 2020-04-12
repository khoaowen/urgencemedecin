package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.SeleniumTestSuite;
import urgence_medecin.selenium.page.CommonPageHelper;

public class UM_5 {

	@Test
	public void testTitreDeLaRegionDansMetaDonnee() {
		SeleniumTestSuite.getWebDriver().get("https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes");
		String title = CommonPageHelper.getHeaderTitle();
		assertThat(title).contains("Auvergne-rhone-alpes");
	}

	@Test
	public void testTitreDeDepartementDansMetaDonnee() {
		SeleniumTestSuite.getWebDriver().get("https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/rhone-69/");
		String title = CommonPageHelper.getHeaderTitle();
		assertThat(title).contains("Rhone");
	}

	@Test
	public void testTitreDeVilleDansMetaDonnee() {
		SeleniumTestSuite.getWebDriver().get(
				"https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/rhone-69/villefranche-sur-saone-69400/");
		String title = CommonPageHelper.getHeaderTitle();
		assertThat(title).contains("Villefranche-sur-saone");
	}

}
