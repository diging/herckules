package edu.asu.diging.lerna.herkules.exception;
/**
 *	This class throws Exception if the parameter is NULL or EMPTY
 */
public class HerckulesArgumentException extends Exception {
	
	private static final long serialVersionUID = -1143264011147534606L;

	public HerckulesArgumentException() {
        // TODO Auto-generated constructor stub
    }

    public HerckulesArgumentException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public HerckulesArgumentException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public HerckulesArgumentException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
}
