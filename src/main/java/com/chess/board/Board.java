package com.chess.board;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.chess.enums.Color;
import com.chess.enums.PieceType;
import com.chess.pieces.Bishop;
import com.chess.pieces.King;
import com.chess.pieces.Knight;
import com.chess.pieces.Pawn;
import com.chess.pieces.Piece;
import com.chess.pieces.Queen;
import com.chess.pieces.Rook;

public class Board {
	private Piece [][]board = new Piece[8][8];
	private List<Piece> pieces = new LinkedList<>();

	private Board() {}

	public Piece [][] getBoard() {
		return board.clone();
	}

	public Piece getPiece(Coordinates coordinate) {
		if(coordinate.equals(Coordinates.getEmptyInstance())){
			return null;
		}
		return board[coordinate.getX()][coordinate.getY()];
	}

	public void removePiece(Coordinates coordinate) {
		Piece p = getPiece(coordinate);
		board[coordinate.getX()][coordinate.getY()] = null;
		p.setCurrentCoordinate(Coordinates.getEmptyInstance());
	}

	public void placePiece(Coordinates fromCoordinate, Coordinates toCoordinate) {
		Piece p = getPiece(fromCoordinate);
		board[fromCoordinate.getX()][fromCoordinate.getY()] = null;
		board[toCoordinate.getX()][toCoordinate.getY()] = p;
		p.setCurrentCoordinate(toCoordinate);
	}

	public static Board getBoardWithFEN(String fenString) {
		Board b = new Board();
		String []fenAry = fenString.split("/");
		
		int x, y;
		
		for(int i = 0 ; i < fenAry.length; i++){
			boolean arryErrorCheck = true;
			String f = fenAry[i];
			x=i;
			y=0;
			for(int j = 0 ; j < f.length(); j++){
				Character c = f.charAt(j);
				if(Character.isDigit(c)){
					y += Character.getNumericValue(c);
					if(arryErrorCheck){
						y -= 1;
						arryErrorCheck = false;
					}
				} else if(Character.isAlphabetic(c)) {
						PieceType pt = PieceType.valueOf(c.toString());
						Piece p = null;
						switch(pt){
							case r : p = new Rook(Color.BLACK, b); break;
							case n : p = new Knight(Color.BLACK, b); break;
							case b : p = new Bishop(Color.BLACK, b); break;
							case q : p = new Queen(Color.BLACK, b); break;
							case k : p = new King(Color.BLACK, b); break;
							case p : p = new Pawn(Color.BLACK, b); break;
							
							case R : p = new Rook(Color.WHITE, b); break;
							case N : p = new Knight(Color.WHITE, b); break;
							case B : p = new Bishop(Color.WHITE, b); break;
							case Q : p = new Queen(Color.WHITE, b); break;
							case K : p = new King(Color.WHITE, b); break;
							case P : p = new Pawn(Color.WHITE, b); break;
						}
						
						b.getPieces().add(p);
						p.setCurrentCoordinate(Coordinates.getNewInstance(x, y));
						b.board[x][y++] = p;
					} 
				}
			}
		return b;
		}

	public List<Piece> getPieces() {
		return pieces;
	}
	
	public List<Piece> getPieces(PieceType pt) {
		/*List<Piece> pList = new LinkedList<>(); 
		for(Piece p : pieces){
			if(p.getPt().equals(pt) && !p.getCurrentCoordinate().equals(Coordinates.getEmptyInstance())){
				pList.add(p);
			}
		}
		return pList;*/
		
		return pieces.stream().filter( p -> p.getPt().equals(pt) && !p.getCurrentCoordinate().equals(Coordinates.getEmptyInstance())).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < 8 ; i ++){
			for( int j = 0 ; j < 8 ; j++){
				if(board[i][j] == null){
					builder.append(" - ");
				} else {
					builder.append(board[i][j]);
				}
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	
	
	

}
