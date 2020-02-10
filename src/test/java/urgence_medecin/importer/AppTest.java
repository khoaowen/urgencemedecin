package urgence_medecin.importer;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static final String SAMPLE_XLSX_FILE_PATH = "BDD.xlsx";

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

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws IOException
	 * @throws InvalidFormatException // * @throws EncryptedDocumentException
	 */
	public void testImportExcelFIle() throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		ExcelReader reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH);
		Sheet sheet = reader.getSheet("Département Suite");
		assertNotNull(sheet);
	}
}
