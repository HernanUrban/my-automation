package com.test.automation.exception;

/**
 * Base Page Exception.
 * 
 * @author hernan.urban
 * 
 */
public class PageException extends Exception {

	private static final long serialVersionUID = 1640947204446138434L;

	public PageException() {
		super();
	}

	public PageException(final String msg) {
		super(msg);
	}

	public PageException(final String msg, Throwable t) {
		super(msg, t);
	}

}
