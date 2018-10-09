package com.manju.springboot.jersey.model;

import javax.ws.rs.WebApplicationException;

public class ApplicationException extends WebApplicationException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorId;
	private String errorMessage;
	
	public ApplicationException(String errorId, String errorMessage) {
		// TODO Auto-generated constructor stub
		this.errorId = errorId;
		this.errorMessage=errorMessage;
	}

	public String getErrorId() {
		return errorId;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	
}
