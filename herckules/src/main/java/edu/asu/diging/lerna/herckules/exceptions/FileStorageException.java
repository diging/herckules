package edu.asu.diging.lerna.herckules.exceptions;

/**
 * This is an exception thrown when there is an File Storage Issue.
 * @author Bhargav J Desai
 * 
 */
public class FileStorageException extends Exception {

	private static final long serialVersionUID = -3850218568287768164L;
	
	/**
	 * default storage exception
	 */
	public FileStorageException() {
		super();
	}
	
	/**
	 * Custom message in the exception
	 * @param customMsg
	 */
	public FileStorageException(String customMsg) {
		super(customMsg);
	}


	
	public FileStorageException(Exception e)
	{
		super(e);
	}


	public FileStorageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	

}
