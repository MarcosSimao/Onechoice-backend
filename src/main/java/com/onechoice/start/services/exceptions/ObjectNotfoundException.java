package com.onechoice.start.services.exceptions;

public class ObjectNotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotfoundException(String msg) {
		super(msg);
	}

}
