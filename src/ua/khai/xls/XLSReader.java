package ua.khai.xls;

import java.util.List;

/**
 * Interface to XLS-file readers.
 *
 * @author Salimonovych, Nadtochiy, Limarenko
 */
public interface XLSReader {

    /**
     * Returns a list of lines from XLS-file, where every line is a list of
     * values.
     *
     * @return
     */
    List<List<String>> readXLS();

}
