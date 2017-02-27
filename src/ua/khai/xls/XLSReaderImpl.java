package ua.khai.xls;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import ua.khai.exception.XLSException;

/**
 * Implementation of <tt>{@link XLSReader}</tt> interface.
 *
 * @author Salimonovych, Nadtochiy, Limarenko
 */
public class XLSReaderImpl implements XLSReader {

	private final static Logger LOGGER = Logger.getLogger(XLSReaderImpl.class);

	private final static String FILE_NAME = "data.xls";

	@Override
	public List<List<String>> readXLS() {
		List<List<String>> lines = new ArrayList<>();
		Workbook workbook = null;

		try {
			workbook = WorkbookFactory.create(new File(FILE_NAME));
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				List<String> line = new ArrayList<>();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					line.add(cell.getStringCellValue());
				}
				lines.add(line);

				if (line.size() != lines.get(0).size()) {
					LOGGER.error("Invalid amount of parameters");
					throw new XLSException("Invalid amount of parameters");
				}
			}

			LOGGER.trace("XLS-file has been read");
		} catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
			LOGGER.error("XLS-file has not been read");
			throw new XLSException("XLS-file has not been read", e);
		} finally {
			try {
				workbook.close();
				LOGGER.trace(workbook.getClass().getSimpleName() + " has been closed");
			} catch (IOException e) {
				LOGGER.error(workbook.getClass().getSimpleName() + " has not been closed", e);
			}
		}

		return lines;
	}

}
