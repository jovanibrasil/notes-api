package com.notes.exceptions;

/**
 * 
 * @author Jovani Brasil
 *
 */
public class ValidationError {

	private final String message;
	private final String field;
	private final Object parameter;
	
	public ValidationError(String message, String field, Object parameter) {
		super();
		this.message = message;
		this.field = field;
		this.parameter = parameter;
	}

	public String getMessage() {
		return message;
	}

	public String getField() {
		return field;
	}

	public Object getParameter() {
		return parameter;
	}

}