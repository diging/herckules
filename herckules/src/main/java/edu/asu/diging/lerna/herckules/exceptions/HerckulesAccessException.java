package edu.asu.diging.lerna.herckules.exceptions;
/**
 * This is an exception thrown when there is an access problem.
 * @author Ram Kumar Kumaresan
 * 
 */
public class HerckulesAccessException extends Exception {

	private static final long serialVersionUID = -3850218568287768164L;
	
	/**
	 * default storage exception
	 */
	public HerckulesAccessException() {
		super();
	}
	
	/**
	 * Custom message in the exception
	 * @param customMsg
	 */
	public HerckulesAccessException(String customMsg) {
		super(customMsg);
	}


	
	public HerckulesAccessException(Exception e)
	{
		super(e);
	}


	public HerckulesAccessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	

}
