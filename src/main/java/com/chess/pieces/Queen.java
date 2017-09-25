package com.chess.pieces;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.Board;
import com.chess.board.Coordinates;
import com.chess.enums.Color;
import com.chess.enums.PieceType;

public class Queen extends Piece {

	public Queen(Color color, Board board) {
		super(color, board, color == Color.WHITE?PieceType.Q:PieceType.q);
	}

	@Override
	public Set<Coordinates> getAllMoves() {
		Set<Coordinates> set = new HashSet<>();
		int i,j;
		
		i=currentCoordinate.getX();
		j=currentCoordinate.getY();
		
		while(--i>=1 && --j>=1){
			Coordinates c= Coordinates.getNewInstance(i, j);
			if(!isValidCoordinate(set,c)){
				break;
			}
		}
		
		i=currentCoordinate.getX();
		j=currentCoordinate.getY();
		
		while(--i>=1 && ++j<=8){
			Coordinates c= Coordinates.getNewInstance(i, j);
			if(!isValidCoordinate(set,c)){
				break;
			}
		}
		
		i=currentCoordinate.getX();
		j=currentCoordinate.getY();
		
		while(++i<=8 && ++j<=8){
			Coordinates c= Coordinates.getNewInstance(i, j);
			if(!isValidCoordinate(set,c)){
				break;
			}
		}
		
		i=currentCoordinate.getX();
		j=currentCoordinate.getY();
		
		while(++i<=8 && --j>=1){
			Coordinates c= Coordinates.getNewInstance(i, j);
			if(!isValidCoordinate(set,c)){
				break;
			}
		}
		
		j=currentCoordinate.getY();
		
		while(++j<=8){
			Coordinates c= Coordinates.getNewInstance(currentCoordinate.getX(), j);
			if(!isValidCoordinate(set,c)){
				break;
			}
		}
		
		j=currentCoordinate.getY();
		
		while(--j>=1){
			Coordinates c= Coordinates.getNewInstance(currentCoordinate.getX(), j);
			if(!isValidCoordinate(set,c)){
				break;
			}
		}
		
		i=currentCoordinate.getX();
		
		while(++i<=8){
			Coordinates c= Coordinates.getNewInstance(i, currentCoordinate.getY());
			if(!isValidCoordinate(set,c)){
				break;
			}
		}
		
		i=currentCoordinate.getX();
		
		while(--i>=1){
			Coordinates c= Coordinates.getNewInstance(i, currentCoordinate.getY());
			if(!isValidCoordinate(set,c)){
				break;
			}
		}
		
		return set;
	}
	
	/*private boolean isValidCoordinate(Set<Coordinates> set, Coordinates c) {
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
	}*/

}
