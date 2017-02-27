package ua.khai.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import ua.khai.exception.DataException;

/**
 * Implementation of <tt>{@link DataChecker}</tt> interface.
 *
 * @author Salimonovych, Nadtochiy, Limarenko
 */
public class DataCheckerImpl implements DataChecker {

	private final static Logger LOGGER = Logger.getLogger(DataCheckerImpl.class);

	private final static String REG_EX_FIRST_NAME_RU = "([\\p{javaUpperCase}]+)([\\p{javaUpperCase}\\p{javaLowerCase}\\.\\-\\ ]*) ([\\p{javaUpperCase}]+)([\\p{javaUpperCase}\\p{javaLowerCase}\\.\\-\\ ]*)";
	private final static String REG_EX_LAST_NAME_RU = "([\\p{javaUpperCase}]+)([\\p{javaUpperCase}\\p{javaLowerCase}\\.\\-\\ ]*)";
	private final static String REG_EX_EMAIL = "([\\p{javaLowerCase}]{1})\\.([\\p{javaLowerCase}]+)@(student.khai.edu)";
	private final static String REG_EX_PASSWORD = "[\\p{javaUpperCase}\\p{javaLowerCase}0-9]{8}";
	private final static String REG_EX_EMAIL_SECOND = "([\\p{javaUpperCase}\\p{javaLowerCase}0-9\\.\\-_]+)@([\\p{javaUpperCase}\\p{javaLowerCase}]+).([\\p{javaUpperCase}\\p{javaLowerCase}\\.]+)";
	private final static String REG_EX_MOBILE_PHONE = "\\+380([0-9]{9})";
	private final static String REG_EX_DEPARTMENT = "[\\p{javaUpperCase}]{1}[0-9]{3}";
	private final static String REG_EX_FIRST_NAME_EN = "([\\p{javaUpperCase}]+)([\\p{javaUpperCase}\\p{javaLowerCase}\\.\\-\\ ]*)";
	private final static String REG_EX_LAST_NAME_EN = "([\\p{javaUpperCase}]+)([\\p{javaUpperCase}\\p{javaLowerCase}\\.\\-\\ ]*)";
	private final static List<String> REG_EXS = new ArrayList<>();

	static {
		REG_EXS.add(REG_EX_FIRST_NAME_RU);
		REG_EXS.add(REG_EX_LAST_NAME_RU);
		REG_EXS.add(REG_EX_EMAIL);
		REG_EXS.add(REG_EX_PASSWORD);
		REG_EXS.add(REG_EX_EMAIL_SECOND);
		REG_EXS.add(REG_EX_MOBILE_PHONE);
		REG_EXS.add(REG_EX_DEPARTMENT);
		REG_EXS.add(REG_EX_FIRST_NAME_EN);
		REG_EXS.add(REG_EX_LAST_NAME_EN);
	}

	private boolean check(String regExp, String value) {
		Matcher matcher = Pattern.compile(regExp).matcher(value);
		if (!matcher.find()) {
			return false;
		}
		return true;
	}

	@Override
	public void checkData(List<List<String>> lines) {
		List<String> params = lines.get(0);
		if (REG_EXS.size() != params.size()) {
			LOGGER.error("Invalid amount of parameters");
			throw new DataException("Invalid amount of parameters");
		}

		for (int i = 1; i < lines.size(); i++) {
			for (int j = 0; j < REG_EXS.size(); j++) {
				if (!this.check(REG_EXS.get(j), lines.get(i).get(j))) {
					LOGGER.error("Invalid value of " + params.get(j) + ": " + lines.get(i).get(j));
					throw new DataException("Invalid value of " + params.get(j) + ": " + lines.get(i).get(j));
				}
			}
		}

		LOGGER.trace("Data is valid");
	}

}
