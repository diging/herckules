package edu.asu.diging.lerna.herckules.exceptions;
/**
 * This is an exception thrown when there is a storage problem.
 * @author Ram Kumar Kumaresan
 * 
 */
public class HerckulesStorageException extends Exception {

	private static final long serialVersionUID = -3850218568287768164L;
	
	/**
	 * default storage exception
	 */
	public HerckulesStorageException() {
		super();
	}
	
	/**
	 * Custom message in the exception
	 * @param customMsg
	 */
	public HerckulesStorageException(String customMsg) {
		super(customMsg);
	}


	
	public HerckulesStorageException(Exception e)
	{
		super(e);
	}


	public HerckulesStorageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	

}
