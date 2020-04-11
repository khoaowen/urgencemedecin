package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;

import com.google.common.base.Functions;

import urgence_medecin.selenium.page.Departement;
import urgence_medecin.selenium.page.Ville;

public class UM_26 extends AbstractTest {

	private static final String DEPARTEMENT_AIN_URL = "https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/ain-01";
	private static final String DEPARTEMENT_ALLIER_URL = "https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/allier-03/";
	private static final String DEPARTEMENT_CANTAL_URL = "https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/cantal-15/";
	private static final String DEPARTEMENT_DROME_URL = "https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/drome-26/";
	private static final String DEPARTEMENT_HAUTE_LOIRE_URL = "https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/haute-loire-43/";
	private static final String DEPARTEMENT_HAUTE_SAVOIE_URL = "https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/haute-savoie-74/";
	private static final String DEPARTEMENT_ISERE_URL = "https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/isere-38/";
	private static final String DEPARTEMENT_LOIRE_URL = "https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/loire-42/";

	// @formatter:off
	private final List<String> phrase1Variables = Arrays.asList(
			"Vous vous trouvez sur la page de notre annuaire",
			"Bienvenu sur la page de l'annuaire",
			"Vous êtes bien sur l'annuaire",
			"L'accès à l'annuaire de cette page web",
			"L'annuaire de cette page vous donne accès à",
			"Bonjour, nous sommes ravis de vous accueillir sur l'annuaire",
			"Vous êtes bien sur notre annuaire",
			"Bienvenu sur l'annuaire",
			"Bienvenu sur notre page annuaire",
			"Bienvenu sur la page de notre annuaire",
			"Bienvenu sur notre annuaire",
			"Bienvenu sur votre annuaire",
			"Vous êtes bien arrivés sur l'annuaire",
			"Vous êtes bien sur la page annuaire",
			"Vous êtes bien sur la page de l'annuaire",
			"Bonjour, vous voila bien sur l'annuaire",
			"Bonjour, notre annuaire est ravi de vous proposer",
			"Bonjour, vous êtes arrivés sur l'annuaire",
			"Bonjour et bienvenu sur notre annuaire",
			"Bonjour, vous êtes bien sur l'annuaire",
			"Vous êtes à présent sur la page de notre annuaire"
			);
	private final List<String> phrase2Variables = Arrays.asList(
			"Cette page vous permet de trouver",
			"Ce site internet et nos consultants vous aideront à trouver",
			"La page de cet annuaire vous permettra de chercher",
			"Ce service vous permet d'avoir une visibilité sur une liste et de trouver",
			"Ce site vous permet de récupérer et trouver simplement",
			"Notre site vous donne la possiblité de trouver en quelques clics",
			"Ce site internet vous aidera à chercher dans les plus brefs délais",
			"Ce site web vous donnera la possibilité de chercher rapidement",
			"Cette page web vous donnera l'opportunité de trouver",
			"Ce site internet vous donnera un choix afin récupérer",
			"Cette page vous offre un accès complet pour trouver rapidement",
			"Nous vous donnons la possibilité de trouver",
			"Nous vous offrons le choix de récupérer facilement",
			"Nous vous accompagnons afin de trouver dans les plus brefs délais",
			"Nous sommes à vos cotés afin de chercher et trouver",
			"Nous vous accompagnons dans la recherche afin de trouver",
			"Notre service vous aidera à trouver le téléphone et",
			"Notre service téléphonique vous accompagne afin de trouver",
			"Nos équipes vous aideront à trouver et chercher",
			"Nos équipes spécialisées vous accompagnent afin de trouver",
			"Nos équipes vous donne la possibilité de trouver",
			"Nos équipes vous aident à chercher et trouver",
			"Nos équipes vous aideront à trouver et récupérer",
			"Nos équipes spécialisées vous accompagnent afin de récupérer",
			"Nos équipes vous donnent la possibilité de récupérer",
			"Nos équipes vous aident à chercher et récupérer",
			"Nos services web vous assistent pour trouver",
			"Nos services vous assistent afin de récupérer et trouver",
			"Cela vous offre la possibilité de trouver",
			"Cela vous offre la possibilité de récupérer",
			"Cela vous permet d'avoir et de trouver",
			"Cela vous permet de trouver",
			"Cela vous permet de chercher",
			"Cela vous offre un accès complet afin de trouver",
			"Cela vous permet d'avoir un accès complet afin de récupérer",
			"Cela vous donne un accès complet afin de chercher",
			"Cela vous donne un accès complet afin d'avoir",
			"Cette page web vous permet d'avoir",
			"Cette page internet vous permet de récupérer",
			"Cette page vous permet de chercher",
			"Cette page internet vous permet de trouver",
			"Notre service vous offre la possibilité de trouver",
			"Notre service internet vous offre la possibilité de récupérer",
			"Notre service vous offre la possibilité de chercher",
			"Notre service d'assistance vous donne l'opportunité de trouver",
			"Notre service de garde vous offre l'opportunité de récupérer",
			"Notre service vous offre l'opportunité de chercher",
			"Nos équipes vous soumettent une liste afin de trouver",
			"Nos conseillers vous accompagnent afin que puissiez trouver",
			"Nos conseillers vous accompagnent afin de récupérer",
			"Nos conseillers vous accompagnent pour chercher",
			"Nous vous accompagnons pour récupérer",
			"Notre accompagnement vous permettra de trouver",
			"Notre site internet vous donne la possibilité de récupérer",
			"Cette page web vous donne une liste afin de trouver",
			"Nos services sont là pour vous assister afin de trouver",
			"Nos services sont là pour vous assister pour chercher",
			"Nos consultants vous accompagnent dans les démarches afin de trouver",
			"Nos consultants accompagnent vos demandes pour récupérer",
			"Nos consultants spécialisés dans la recherche vous aideront à trouver",
			"Nos consultants spécialisés vous aideront à récupérer et trouver",
			"Découvrez comment trouver facilement",
			"Découvrez comment récupérer très facilement"
			);
			
	// @formatter:on

	private static Map<String, List<String>> allVillesPrincipalesDescriptionCache = new HashedMap<>();

	private List<String> getAllVillesPrincipalesDescription(String departementUrl) {
		if (allVillesPrincipalesDescriptionCache.containsKey(departementUrl)) {
			return allVillesPrincipalesDescriptionCache.get(departementUrl);
		}
		webDriver.get(departementUrl);
		final Departement departement = Departement.getPage();
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> departement.getHyperLinksOfMedecinParVilles());
		List<String> hrefLinks = departement.getHyperLinksOfMedecinParVilles().stream().map(e -> e.getAttribute("href"))
				.collect(Collectors.toList());

		List<String> villeDescriptions = new ArrayList<>();

		for (String villeLink : hrefLinks) {
			// go to each ville and collect its description
			webDriver.get(villeLink);
			final Ville ville = Ville.getPage();
			webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> ville.getDescriptionElement());
			villeDescriptions.add(ville.getDescriptionElement().getText());
		}
		allVillesPrincipalesDescriptionCache.put(departementUrl, villeDescriptions);
		return villeDescriptions;
	}

	private List<Integer> getCounterOfEachVariable(String departementUrl, List<String> variableList) {

		List<String> allVillesPrincipalesDescription = getAllVillesPrincipalesDescription(departementUrl);
		Map<String, Integer> variableCounter = variableList.stream()
				.collect(Collectors.toMap(Functions.identity(), (e) -> 0));

		for (String desc : allVillesPrincipalesDescription) {
			for (String variable : variableList) {
				if (desc.contains(variable)) {
					variableCounter.computeIfPresent(variable, (k, v) -> v + 1);
				}
			}
		}
		return new ArrayList<>(variableCounter.values());
	}

	@Test
	public void test_villes_principales_phrase1_doivent_etre_differentes_pour_ain() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_AIN_URL, phrase1Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase2_doivent_etre_differentes_pour_ain() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_AIN_URL, phrase2Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase1_doivent_etre_differentes_pour_allier() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_ALLIER_URL, phrase1Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase2_doivent_etre_differentes_pour_allier() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_ALLIER_URL, phrase2Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase1_doivent_etre_differentes_pour_cantal() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_CANTAL_URL, phrase1Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase2_doivent_etre_differentes_pour_cantal() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_CANTAL_URL, phrase2Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase1_doivent_etre_differentes_pour_drome() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_DROME_URL, phrase1Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase2_doivent_etre_differentes_pour_drome() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_DROME_URL, phrase2Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase1_doivent_etre_differentes_pour_haute_loire() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_HAUTE_LOIRE_URL, phrase1Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase2_doivent_etre_differentes_pour_haute_loire() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_HAUTE_LOIRE_URL, phrase2Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase1_doivent_etre_differentes_pour_haute_savoie() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_HAUTE_SAVOIE_URL, phrase1Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase2_doivent_etre_differentes_pour_haute_savoie() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_HAUTE_SAVOIE_URL, phrase2Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase1_doivent_etre_differentes_pour_isere() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_ISERE_URL, phrase1Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase2_doivent_etre_differentes_pour_isere() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_ISERE_URL, phrase2Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase1_doivent_etre_differentes_pour_loire() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_LOIRE_URL, phrase1Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

	@Test
	public void test_villes_principales_phrase2_doivent_etre_differentes_pour_loire() {
		List<Integer> counter = getCounterOfEachVariable(DEPARTEMENT_LOIRE_URL, phrase2Variables);
		assertThat(counter).allSatisfy(value -> assertThat(value).isLessThan(3).isGreaterThan(0));
	}

}
