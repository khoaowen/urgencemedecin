package urgence_medecin.importer;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private final String filePath;
	private final Workbook workbook;

	public ExcelReader(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		this.filePath = filePath;
		workbook = WorkbookFactory.create(new File(getClass().getClassLoader().getResource(filePath).getFile()));
	}

	public Sheet getSheet(String string) {
		if (workbook == null) {
			throw new IllegalStateException("The workbook must be intialized first");
		}
		return workbook.getSheet(string);
	}

}
