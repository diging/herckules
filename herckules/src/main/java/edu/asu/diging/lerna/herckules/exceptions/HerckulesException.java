package edu.asu.diging.lerna.herckules.exceptions;
/**
 * This is an exception thrown when there is a general exception in the system.
 * @author Ram Kumar Kumaresan
 * 
 */
public class HerckulesException extends Exception {

	private static final long serialVersionUID = -3850218568287768164L;
	
	/**
	 * default storage exception
	 */
	public HerckulesException() {
		super();
	}
	
	/**
	 * Custom message in the exception
	 * @param customMsg
	 */
	public HerckulesException(String customMsg) {
		super(customMsg);
	}


	
	public HerckulesException(Exception e)
	{
		super(e);
	}


	public HerckulesException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	

}
