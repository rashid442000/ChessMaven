package com.chess.enums;

public enum PieceName {
	ROOK("Rook"),KNIGHT("Knight"),BISHOP("Bishop"),QUEEN("Queen"),KING("King"),PAWN("Pawn");
	
	private String name;
	
	public String getName() {
		return name;
	}

	private PieceName(String name){
		this.name= name;
	}
}
