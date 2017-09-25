package com.chess.pieces;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.Board;
import com.chess.board.Coordinates;
import com.chess.enums.Color;
import com.chess.enums.PieceType;

public class King extends Piece {

	public King(Color color, Board board) {
		super(color, board, color == Color.WHITE?PieceType.K:PieceType.k);
	}

	@Override
	public Set<Coordinates> getAllMoves() {
		Set<Coordinates> set = new HashSet<>();
		/*Coordinates c1 = Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()-1);
		Coordinates c2 = Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY());
		Coordinates c3 = Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()+1);
		Coordinates c4 = Coordinates.getNewInstance(currentCoordinate.getX(), currentCoordinate.getY()-1);
		Coordinates c5 = Coordinates.getNewInstance(currentCoordinate.getX(), currentCoordinate.getY()+1);
		Coordinates c6 = Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()-1);
		Coordinates c7 = Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY());
		Coordinates c8 = Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()+1);
		
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(c4);
		set.add(c5);
		set.add(c6);
		set.add(c7);
		set.add(c8);*/
		
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()-1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()+1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX(), currentCoordinate.getY()-1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX(), currentCoordinate.getY()+1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()-1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()+1));
		
		return set;
	}

}
