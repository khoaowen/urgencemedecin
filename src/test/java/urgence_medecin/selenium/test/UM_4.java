package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.SeleniumTestSuite;

public class UM_4 {

	@Test
	public void test_supprimer_les_pages_get_ville() {
		SeleniumTestSuite.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/get-region/get-departement/get-ville/");
		assertThat(SeleniumTestSuite.getWebDriver().getCurrentUrl())
				.isEqualTo("https://www.urgence-medecin-garde.fr/annuaire");
	}

	@Test
	public void test_supprimer_les_pages_get_departement() {
		SeleniumTestSuite.getWebDriver().get("https://www.urgence-medecin-garde.fr/get-region/get-departement/");
		assertThat(SeleniumTestSuite.getWebDriver().getCurrentUrl())
				.isEqualTo("https://www.urgence-medecin-garde.fr/annuaire");
	}

	@Test
	public void test_supprimer_les_pages_get_region() {
		SeleniumTestSuite.getWebDriver().get("https://www.urgence-medecin-garde.fr/get-region/");
		assertThat(SeleniumTestSuite.getWebDriver().getCurrentUrl())
				.isEqualTo("https://www.urgence-medecin-garde.fr/annuaire");
	}
}
