package ua.khai.exception;

/**
 * Root exception to all application exceptions.
 *
 * @author Salimonovych, Nadtochiy, Limarenko
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = 33680255165364378L;

    public AppException() {
	super();
    }

    public AppException(String message, Throwable cause) {
	super(message, cause);
    }

    public AppException(String message) {
	super(message);
    }

    public AppException(Throwable cause) {
	super(cause);
    }

}
