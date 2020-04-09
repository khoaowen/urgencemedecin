package urgence_medecin.importer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
	private static final long firstMetaId = 625812;

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		final ExcelReader reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH);
		List<String> variablesToRead = IntStream.rangeClosed(1, 46).mapToObj(i -> "variable" + i)
				.collect(Collectors.toList());
		Long metaId = firstMetaId;
		StringBuilder bd = new StringBuilder();
		for (String var : variablesToRead) {
			List<String> valuesOfHeader = reader.getValuesOfHeader("Ville ALL", var);
			Pair<String, Long> generateStatements = MetaDatasUpdater.insertStatements(metaId, var, postIds,
					valuesOfHeader);
			bd.append(generateStatements.getKey());
			metaId = generateStatements.getValue();
		}
		try (BufferedWriter writer = Files.newBufferedWriter(new File("sqlResult.txt").toPath())) {
			writer.write(bd.toString());
		}
		reader.close();
	}
}