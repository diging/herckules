package edu.asu.diging.lerna.herkules.exception;

/**
 * This class throws Exception if the parameter is NULL or EMPTY
 */
public class HerckulesArgumentException extends Exception {

	private static final long serialVersionUID = -1143264011147534606L;

	public HerckulesArgumentException() {

	}

	public HerckulesArgumentException(String message) {
		super(message);
	}

	public HerckulesArgumentException(Throwable cause) {
		super(cause);
	}

	public HerckulesArgumentException(String message, Throwable cause) {
		super(message, cause);
	}
}
