package com.zark.easyframe.common.exception;

import org.slf4j.Logger;


/**
 * @author karl on 15-10-16.
 */
public interface ExceptionAdapter {

	Class<? extends Throwable> getExceptionClass();

	String getErrorMessage(Throwable exception);
	
	void log(Logger logger, String logPrefix, Throwable exception);
}
