package edu.asu.diging.lerna.herkules.exception;

/**
 * This class throws Exception when the specified ProjectID is not found in the
 * database.
 */

public class ProjectIDNotFoundException extends Exception {

	private static final long serialVersionUID = -5897854505878121897L;

	public ProjectIDNotFoundException() {
	}

	public ProjectIDNotFoundException(String message) {
		super(message);
	}

	public ProjectIDNotFoundException(Throwable cause) {
		super(cause);
	}

	public ProjectIDNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
