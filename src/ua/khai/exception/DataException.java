package ua.khai.exception;

/**
 * Exception will be thrown if data to be checked is invalid.
 *
 * @author Salimonovych, Nadtochiy, Limarenko
 */
public class DataException extends AppException {

    private static final long serialVersionUID = 6390778382083402183L;

    public DataException() {
	super();
    }

    public DataException(String message, Throwable cause) {
	super(message, cause);
    }

    public DataException(String message) {
	super(message);
    }

    public DataException(Throwable cause) {
	super(cause);
    }

}
