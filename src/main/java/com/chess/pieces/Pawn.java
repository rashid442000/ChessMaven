package com.chess.pieces;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.Board;
import com.chess.board.Coordinates;
import com.chess.enums.Color;
import com.chess.enums.PieceType;

public class Pawn extends Piece {

	public Pawn(Color color, Board board) {
		super(color, board, color == Color.WHITE?PieceType.P:PieceType.p);
	}

	@Override
	public Set<Coordinates> getAllMoves() {
		Set<Coordinates> set = new HashSet<>();
		
		Coordinates c1 = null;
		Coordinates c2 = null;
		Coordinates c3 = null;
		
		if(this.color == Color.WHITE){
			 c1 = Coordinates.getNewInstance(currentCoordinate.getX()-1,currentCoordinate.getY()-1);
			 c2 = Coordinates.getNewInstance(currentCoordinate.getX()-1,currentCoordinate.getY());
			 c3 = Coordinates.getNewInstance(currentCoordinate.getX()-1,currentCoordinate.getY()+1);
		} else {
			 c1 = Coordinates.getNewInstance(currentCoordinate.getX()+1,currentCoordinate.getY()-1);
			 c2 = Coordinates.getNewInstance(currentCoordinate.getX()+1,currentCoordinate.getY());
			 c3 = Coordinates.getNewInstance(currentCoordinate.getX()+1,currentCoordinate.getY()+1);
		}
		
		Piece p = board.getPiece(c1);
		if(p != null && this.color != p.getColor()){
			set.add(c1);
		}
		set.add(c2);
		
		p = board.getPiece(c3);
		if(p != null && this.color != p.getColor()){
			set.add(c3);
		}
		
		
		return set;
	}

	@Override
	public boolean isMoveValid(Coordinates to) {
		Set<Coordinates> set = getAllMoves();
		if(set.contains(to)){
			Piece p = board.getPiece(to);
			if(currentCoordinate.getY().equals(to.getY()) && p == null){
				return true;
			}
			
			if(!currentCoordinate.getY().equals(to.getY()) && p != null && p.color != this.color){
				return true;
			}
		}
		return false;
	}

}
