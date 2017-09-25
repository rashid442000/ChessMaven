package com.chess.game;

import java.util.List;
import java.util.Set;

import com.chess.board.Board;
import com.chess.board.Coordinates;
import com.chess.board.Move;
import com.chess.enums.Color;
import com.chess.exceptions.InvalidFENException;
import com.chess.exceptions.InvalidMoveException;
import com.chess.fen.FENPrinter;
import com.chess.pieces.Piece;
import com.chess.validators.FENValidator;
import com.chess.validators.MoveValidator;

public class Game {
	
	private final Board board;
	private Color playerTurn;
	private final FENPrinter fenPrinter;
	
	private Game(Board board, FENPrinter fenPrinter){
		this.board = board;
		this.fenPrinter = fenPrinter;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public static Game getNewInstance() throws InvalidFENException{
		return getNewInstanceWithFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
	}
	
	public static Game getNewInstanceWithFEN(String fenString) throws InvalidFENException{
		FENValidator.validateFEN(fenString);
		String []fenStringAry = fenString.split(" ");
		Board board = Board.getBoardWithFEN(fenStringAry[0]);
		FENPrinter fenPrinter = FENPrinter.getNewInstance(board);
		Game game = new Game(board, fenPrinter);
		game.playerTurn = getPlayerTurn(fenStringAry[1]);
		return game;
	}

	private static Color getPlayerTurn(String player) {
		if("w".equalsIgnoreCase(player)){
			return Color.WHITE;
		} 
		return Color.BLACK;
	}
	
	public Color getPlayerTurn(){
		return playerTurn;
	}
	
	public boolean move(String m) {
		try {
			Piece p = null;
			MoveValidator.validateMove(m,playerTurn);
			Move mv = Move.getNewInstance(m,playerTurn);
			List<Piece> pieces = board.getPieces(mv.getPt());
			
			int posibbleMoves = 0;
			for(Piece p1 : pieces){
				Set<Coordinates> possibleCoordinates = p1.getAllMoves();
				if(possibleCoordinates.contains(mv.getTo())){
					posibbleMoves++;
					p = p1;
				}
			}
			
			if(posibbleMoves == 0 ){
				throw new InvalidMoveException("No such move possible.");
			}
			
			if(posibbleMoves > 1){
				Integer fileValue = Move.getFileValue(m);
				if(fileValue != null){
					for(Piece p1 : pieces){
						if(p1.getCurrentCoordinate().getY().equals(fileValue)){
							p = p1;
						}
					}
				} else {
					Integer rankValue = Move.getRankValue(m);
					if(rankValue != null){
						for(Piece p1 : pieces){
							if(p1.getCurrentCoordinate().getY().equals(rankValue)){
								p = p1;
							}
						}
					} 
				}
			}
			
			if( p == null){
				throw new InvalidMoveException("No such move possible.");
			}
			
			p.move(mv.getTo());
			
			playerTurn = playerTurn == Color.WHITE?Color.BLACK:Color.WHITE;
			
			System.out.println(getFENString());
			
			return true;
			
		} catch (InvalidMoveException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public String getFENString() {
		return fenPrinter.getFenString();
	}

	public static void main(String[] args) {
		try {
			Game game = Game.getNewInstanceWithFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
			/*game.move("Pb3");
			game.move("nc6");
			game.move("Pb4");
			game.move("nb4");*/
			System.out.println("Game started : ");
			System.out.println("Initial board : " + game.getFENString());
			 while (true) {

		            System.out.print(game.getPlayerTurn() + " player move : ");
		            String input = System.console().readLine();
		            
		            if ("q".equals(input)) {
		            	System.out.println("Exit!");
		            	System.exit(0);
		            }
		            
		            game.move(input);

		        }
//			System.out.println(game.getBoard().toString());
		} catch (InvalidFENException e) {
			System.out.println(e.getMessage());
		}

	}

	
	

}
