package urgence_medecin.importer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javafx.util.Pair;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static final String SAMPLE_XLSX_FILE_PATH = "BDD.xlsx";
	private final List<Long> postIds = Arrays.asList(6454l, 6455L, 6456L, 6457L, 6459L, 6460L, 6461L, 6462L, 6463L,
			6464L, 6465L, 6521L, 6466L, 6467L, 6468L, 6469L, 6470L, 6471L, 6472L, 6473L, 6475L, 6476L, 6477L, 6533L,
			6478L, 6479L, 6480L, 6545L, 6481L, 6482L, 6483L, 6484L, 6486L, 6487L, 6522L, 6474L, 6485L, 6497L, 6506L,
			6524L, 6528L, 6541L, 6458L, 6519L, 6546L, 6488L, 6489L, 6490L, 6491L, 6492L, 6493L, 6494L, 6495L, 6496L,
			6498L, 6499L, 6500L, 6501L, 6502L, 6503L, 6504L, 6505L, 6507L, 6508L, 6509L, 6510L, 6511L, 6512L, 6513L,
			6514L, 6515L, 6529L, 6516L, 6517L, 6518L, 6520L, 6523L, 6525L, 6526L, 6527L, 6531L, 6530L, 6547L, 6534L,
			6535L, 6536L, 6544L, 6549L, 6548L, 6537L, 6538L, 6539L, 6540L, 6542L, 6543L, 6532L);
	private final long firstMetaId = 391350l;

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	private String readLineByLine(String filePath) throws URISyntaxException {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(filePath).toURI()),
				StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public void testReadLineByLine() throws URISyntaxException {
		assertFalse(readLineByLine("sqlStatements").isEmpty());
	}

	/**
	 * 
	 * @throws IOException
	 * @throws InvalidFormatException // * @throws EncryptedDocumentException
	 * @throws URISyntaxException
	 */
	public void testImportExcelFIleVariable5()
			throws EncryptedDocumentException, InvalidFormatException, IOException, URISyntaxException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		final ExcelReader reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH);
		final String variable5 = "variable5";
		final List<String> valuesOfHeader = reader.getValuesOfHeader("Département Suite", variable5);
		assertEquals(valuesOfHeader.size(), 14);

		MetaDatasUpdater updater = new MetaDatasUpdater(postIds, firstMetaId, variable5, valuesOfHeader);
		assertEquals(readLineByLine("sqlStatements"), updater.generateStatements().getKey());
		reader.close();

	}

	/**
	 * 
	 * @throws IOException
	 * @throws InvalidFormatException // * @throws EncryptedDocumentException
	 * @throws URISyntaxException
	 */
	public void testImportExcelFIleVariable7()
			throws EncryptedDocumentException, InvalidFormatException, IOException, URISyntaxException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		final ExcelReader reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH);
		final String variable7 = "variable7";
		List<String> valuesOfHeader = reader.getValuesOfHeader("Département Suite", variable7);
		assertEquals(valuesOfHeader.size(), 7);

		MetaDatasUpdater updater = new MetaDatasUpdater(postIds, firstMetaId, variable7, valuesOfHeader);
		assertEquals(readLineByLine("sqlStatements2"), updater.generateStatements().getKey());
		reader.close();

	}

	/**
	 * 
	 * @throws IOException
	 * @throws InvalidFormatException // * @throws EncryptedDocumentException
	 * @throws URISyntaxException
	 */
	public void testImportExcelFIleMerged()
			throws EncryptedDocumentException, InvalidFormatException, IOException, URISyntaxException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		final ExcelReader reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH);
		List<String> variablesToRead = Arrays.asList("variable5", "variable7");
		Long metaId = firstMetaId;
		StringBuilder bd = new StringBuilder();
		for (String var : variablesToRead) {
			List<String> valuesOfHeader = reader.getValuesOfHeader("Département Suite", var);
			MetaDatasUpdater updater = new MetaDatasUpdater(postIds, metaId, var, valuesOfHeader);
			Pair<String, Long> generateStatements = updater.generateStatements();
			bd.append(generateStatements.getKey());
			metaId = generateStatements.getValue();
		}

		assertEquals(readLineByLine("sqlStatementsMerged"), bd.toString());
		reader.close();

	}
}
