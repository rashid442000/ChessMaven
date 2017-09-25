package com.chess.exceptions;

public class InvalidMoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7965168442074900499L;
	
	public InvalidMoveException(String message){
		super(message);
	}

}
