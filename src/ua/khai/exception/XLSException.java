package ua.khai.exception;

/**
 * Exception will be thrown if there are problems with XLS-file.
 *
 * @author Salimonovych, Nadtochiy, Limarenko
 */
public class XLSException extends AppException {

    private static final long serialVersionUID = -2940125149049496757L;

    public XLSException() {
	super();
    }

    public XLSException(String message, Throwable cause) {
	super(message, cause);
    }

    public XLSException(String message) {
	super(message);
    }

    public XLSException(Throwable cause) {
	super(cause);
    }

}
