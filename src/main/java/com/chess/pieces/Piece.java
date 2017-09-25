package com.chess.pieces;

import java.util.Set;

import com.chess.board.Board;
import com.chess.board.Coordinates;
import com.chess.enums.Color;
import com.chess.enums.PieceType;

public abstract class Piece {
	protected final Color color;
	protected final Board board;
	protected Coordinates currentCoordinate;
	protected final PieceType pt;

	public Piece(Color color, Board board, PieceType pt) {
		super();
		this.color = color;
		this.board = board;
		this.pt = pt;
	}

	public Color getColor() {
		return color;
	}
	
	public Coordinates getCurrentCoordinate() {
		return currentCoordinate;
	}

	public void setCurrentCoordinate(Coordinates currentCoordinate) {
		this.currentCoordinate = currentCoordinate;
	}

	public PieceType getPt() {
		return pt;
	}
	
	public abstract Set<Coordinates> getAllMoves();
	
	public boolean isMoveValid(Coordinates to) {
		Set<Coordinates> set = getAllMoves();
		if(set.contains(to)){
			Piece p = board.getPiece(to);
			if(p != null && p.getColor() == this.getColor()){
				return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean move(Coordinates to) {
		if(isMoveValid(to)){
			Piece p = board.getPiece(to);
			if(p != null){
				board.removePiece(to);
			}
			
			board.placePiece(this.getCurrentCoordinate(),to);
			return true;
		}
		return false;
	}
	
	protected boolean isValidCoordinate(Set<Coordinates> set, Coordinates c) {
		Piece p = board.getPiece(c);
		if(p != null){
			if(p.getColor() == this.getColor()){
				return false;
			} else {
				set.add(c);
				return false;
			}
		}
		set.add(c);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ");
		builder.append(pt);
		builder.append(" ");
		return builder.toString();
	}
	
	
}
