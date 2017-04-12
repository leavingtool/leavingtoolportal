package com.dynagility.leavingtoolportal.exceptions;

public class NotAuthorizedException extends RuntimeException {
	/**
	 * Not Authorized Exception
	 */
	private static final long serialVersionUID = 5448617068785128103L;

	public NotAuthorizedException() {
		super("Not allowed access");
	}
}
