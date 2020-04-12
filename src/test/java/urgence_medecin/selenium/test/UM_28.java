package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.SeleniumTestSuite;

public class UM_28 {

	@Test
	public void test_supprimer_la_redirection_301() {
		SeleniumTestSuite.getWebDriver().get(
				"https://www.urgence-medecin-garde.fr/get-region/get-departement/get-ville/?regionparam=$1&departementparam=$2&codeparam=$3&villeparam=$4&postalparam=$5");
		assertThat(SeleniumTestSuite.getWebDriver().getCurrentUrl())
				.isEqualTo("https://www.urgence-medecin-garde.fr/annuaire");
	}
}
