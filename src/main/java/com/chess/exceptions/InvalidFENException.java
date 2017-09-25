package com.chess.exceptions;

public class InvalidFENException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5405986782131011170L;
	
	public InvalidFENException(String message){
		super(message);
	}

}
