package urgence_medecin.importer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javafx.util.Pair;

/**
 * Hello world!
 *
 */
public class App {

	private static final String SAMPLE_XLSX_FILE_PATH = "BDD.xlsx";
	private static final List<Long> postIds = LongStream.rangeClosed(6550, 43291).boxed().collect(Collectors.toList());
	private static final long firstMetaId = 394404;

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		final ExcelReader reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH);
		List<String> variablesToRead = IntStream.rangeClosed(1, 6).mapToObj(i -> "phrase" + i)
				.collect(Collectors.toList());
		Long metaId = firstMetaId;
		StringBuilder bd = new StringBuilder();
		for (String var : variablesToRead) {
			List<String> valuesOfHeader = reader.getValuesOfHeader("Ville Accroche", var);
			MetaDatasUpdater updater = new MetaDatasUpdater(postIds, metaId, var, valuesOfHeader);
			Pair<String, Long> generateStatements = updater.generateStatements();
			bd.append(generateStatements.getKey());
			metaId = generateStatements.getValue();
		}

		System.out.println(bd.toString());
		reader.close();
	}
}