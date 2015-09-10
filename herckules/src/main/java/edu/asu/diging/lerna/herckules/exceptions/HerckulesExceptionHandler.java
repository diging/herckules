package edu.asu.diging.lerna.herckules.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class handles exceptions thrown in Controller classes.
 * 
 * @author Julia Damerow
 *
 */
@ControllerAdvice
public class HerckulesExceptionHandler {

	
	private static final Logger logger = LoggerFactory.getLogger(HerckulesExceptionHandler.class);
	/**
	 * For now this method handles all exceptions thrown in Controller classes. Eventually this method can be
	 * replaced by methods that handle individual exceptions.
	 * 
	 * @param ex The exception thrown in a controller.
	 * @return Information about the exception page.
	 */
	@ExceptionHandler(HerckulesException.class)
	public ModelAndView handleNotImplementedEx(Exception ex) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("auth/issue");
		modelAndView.addObject("ex_name", ex.getClass().getName());
		modelAndView.addObject("ex_message", ex.getMessage());
		logger.error(ex.getMessage(), ex);
		return modelAndView;
	}
	
	@ExceptionHandler(HerckulesStorageException.class)
	public ModelAndView handleSQLException(HerckulesStorageException ex) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("auth/storageissue");
		modelAndView.addObject("ex_name", ex.getClass().getName());
		modelAndView.addObject("ex_message", ex.getMessage());
		logger.error(ex.getMessage(), ex);
		return modelAndView;
	}
	

	@ExceptionHandler(value ={ HerckulesAccessException.class})
	public ModelAndView handleUserAccessException(HerckulesAccessException ex) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("auth/accessissue");
		modelAndView.addObject("ex_name", ex.getClass().getName());
		modelAndView.addObject("ex_message", ex.getMessage());
		logger.error(ex.getMessage(), ex);
		return modelAndView;
	}
	
	}
