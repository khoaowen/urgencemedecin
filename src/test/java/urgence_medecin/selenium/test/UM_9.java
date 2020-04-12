package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.SeleniumTestSuite;

public class UM_9 {

	@Test
	public void testPagesSupprimees_departement_finistere() {
		SeleniumTestSuite.getWebDriver().get("https://www.urgence-medecin-garde.fr/departement/finistere/");
		assertThat(SeleniumTestSuite.getWebDriver().getCurrentUrl()).isEqualTo("https://www.urgence-medecin-garde.fr/");
	}

	@Test
	public void testPagesSupprimees_region_ile_de_france() {
		SeleniumTestSuite.getWebDriver().get("https://www.urgence-medecin-garde.fr/region/ile-de-france/");
		assertThat(SeleniumTestSuite.getWebDriver().getCurrentUrl()).isEqualTo("https://www.urgence-medecin-garde.fr/");
	}

	@Test
	public void testPagesSupprimees_ville_saint_etienne() {
		SeleniumTestSuite.getWebDriver().get("https://www.urgence-medecin-garde.fr/ville/saint-etienne/");
		assertThat(SeleniumTestSuite.getWebDriver().getCurrentUrl()).isEqualTo("https://www.urgence-medecin-garde.fr/");
	}

}
