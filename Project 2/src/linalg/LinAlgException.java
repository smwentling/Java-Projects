package linalg;

/** A simple specialized Exception class for our Linear Algebra package.  Use this
 *  class as you would any Exception.  You do not need to modify this file!
 * 
 * @author ssanner@mie.utoronto.ca
 *
 */
public class LinAlgException extends Exception {

	/** Exception constructor should always pass error message to its superclass
	 *  (we should not redundantly store the message since the superclass stores 
	 *   the message and provides methods for accessing it that we inherit here).
	 * 
	 * @param message
	 */
	public LinAlgException(String message) {
		super(message);
	}

}
