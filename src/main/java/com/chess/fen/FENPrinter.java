package com.chess.fen;

import com.chess.board.Board;
import com.chess.pieces.Piece;

public class FENPrinter {
	
	private final Board board;
	
	private FENPrinter(Board board){
		this.board = board;
	}
	
	public static FENPrinter getNewInstance(Board board){
		return new FENPrinter(board);
	}
	
	public String getFenString(){
		Piece[][] b = board.getBoard();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 8 ; i++){
			int count = 0;
			for(int j = 0 ; j < 8 ; j++){
				Piece p = b[i][j];
				if(p != null){
					if(count != 0){
						sb.append(count);
						count = 0;
					}
					sb.append(p.getPt().toString().trim());
				} else {
					count++;
				}
			}
			if(count != 0){
				sb.append(count);
				count = 0;
			}
			if( i < 7){
				sb.append("/");
			}
		}
		return sb.toString();
	}

}
