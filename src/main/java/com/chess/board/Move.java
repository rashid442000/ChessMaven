package com.chess.board;

import com.chess.enums.Color;
import com.chess.enums.PieceType;
import com.chess.enums.Positions;

public class Move {
	
	private final Color playerTurn;
	private final PieceType pt;
	private final Coordinates to;
	private final boolean capturting;
	
	private Move(Color playerTurn, PieceType pt, Coordinates to, boolean capturting) {
		super();
		this.playerTurn = playerTurn;
		this.pt = pt;
		this.to = to;
		this.capturting = capturting;
	}

	public static Move getNewInstance(String m, Color playerTurn) {
		PieceType pt = null;
		if(m.length() == 2){
			pt = playerTurn == Color.WHITE?PieceType.P:PieceType.p;
		} else {
			pt = PieceType.valueOf(m.substring(0, 1));
		}
		
		boolean capturting = false;
		if(m.contains("x")){
			capturting = true;
		}
		
		Coordinates to = Coordinates.getCoordinateFromLocation(m.substring(m.length()-2, m.length()));
		return new Move(playerTurn, pt, to, capturting);
	}

	public Color getPlayerTurn() {
		return playerTurn;
	}

	public PieceType getPt() {
		return pt;
	}

	public Coordinates getTo() {
		return to;
	}

	public boolean isCapturting() {
		return capturting;
	}

	public static Integer getFileValue(String m) {
		Character c = m.charAt(1);
		try{
			Positions p = Positions.valueOf(c.toString());
			return p.getNumericValue();
		} catch (IllegalStateException e){
			// do nothing. Check for rank value.
		}
		
		return null;
	}

	public static Integer getRankValue(String m) {
		Character c= m.charAt(1);
		return 8-Character.getNumericValue(c);
	}

}
