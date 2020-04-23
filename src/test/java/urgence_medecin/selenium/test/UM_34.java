package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Ville;

public class UM_34 {

	@Test
	public void test_logo_hericourt_de_departement_haute_saone_region_bourgogne_franche_comte() {
		TestSuiteSelenium.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/bourgogne-franche-comte/haute-saone-70/hericourt-70400");
		Ville ville = Ville.getPage();
		assertThat(ville.getLogoVilleImg("src")).contains("bourgogne-franche-comte");
	}

	@Test
	public void test_logo_saint_claude_de_departement_haute_saone_region_bourgogne_franche_comte() {
		TestSuiteSelenium.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/bourgogne-franche-comte/jura-39/saint-claude-39200");
		Ville ville = Ville.getPage();
		assertThat(ville.getLogoVilleImg("src")).contains("bourgogne-franche-comte");
	}

	@Test
	public void test_logo_hericourt_de_departement_pas_de_calais_region_hauts_de_france() {
		TestSuiteSelenium.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/hauts-de-france/pas-de-calais-62/hericourt-62130/");
		Ville ville = Ville.getPage();
		assertThat(ville.getLogoVilleImg("src")).contains("Hauts-de-France");
	}

}
