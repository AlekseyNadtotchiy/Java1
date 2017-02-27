package ua.khai.main;

import ua.khai.checker.DataChecker;
import ua.khai.checker.DataCheckerImpl;
import ua.khai.xls.XLSReader;
import ua.khai.xls.XLSReaderImpl;

/**
 * Main class to start the project.
 *
 * @author Salimonovych, Nadtochiy, Limarenko
 */
public class Main {

	/**
	 * Project entry point.
	 */
	public static void main(String[] args) {
		XLSReader reader = new XLSReaderImpl();
		DataChecker checker = new DataCheckerImpl();
		checker.checkData(reader.readXLS());
	}

}
