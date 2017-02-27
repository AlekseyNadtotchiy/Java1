package ua.khai.checker;

import java.util.List;

/**
 * Interface to data checkers.
 *
 * @author Salimonovych, Nadtochiy, Limarenko
 */
public interface DataChecker {

    /**
     * Checks data by regular expressions.
     *
     * @param lines
     *            a value list to be checked
     */
    void checkData(List<List<String>> lines);

}
