package com.chess.pieces;

import java.util.HashSet;
import java.util.Set;

import com.chess.board.Board;
import com.chess.board.Coordinates;
import com.chess.enums.Color;
import com.chess.enums.PieceType;

public class Knight extends Piece {

	public Knight(Color color, Board board) {
		super(color, board, color == Color.WHITE?PieceType.N:PieceType.n);
	}

	@Override
	public Set<Coordinates> getAllMoves() {
		Set<Coordinates> set = new HashSet<>();
		/*set.add(Coordinates.getNewInstance(currentCoordinate.getX()-2, currentCoordinate.getY()-1));
		set.add(Coordinates.getNewInstance(currentCoordinate.getX()-2, currentCoordinate.getY()+1));
		set.add(Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()+2));
		set.add(Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()+2));
		set.add(Coordinates.getNewInstance(currentCoordinate.getX()+2, currentCoordinate.getY()+1));
		set.add(Coordinates.getNewInstance(currentCoordinate.getX()+2, currentCoordinate.getY()-1));
		set.add(Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()-2));
		set.add(Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()-2));*/
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()-2, currentCoordinate.getY()-1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()-2, currentCoordinate.getY()+1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()+2));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()+2));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()+2, currentCoordinate.getY()+1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()+2, currentCoordinate.getY()-1));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()+1, currentCoordinate.getY()-2));
		isValidCoordinate(set,Coordinates.getNewInstance(currentCoordinate.getX()-1, currentCoordinate.getY()-2));
		return set;
	}

}
