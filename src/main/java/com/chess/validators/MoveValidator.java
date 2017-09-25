package com.chess.validators;

import com.chess.enums.Color;
import com.chess.enums.PieceType;
import com.chess.enums.Positions;
import com.chess.exceptions.InvalidMoveException;

public class MoveValidator {

	private MoveValidator() {
	}

	public static void validateMove(String m, Color playerTurn) throws InvalidMoveException {

		if (m.length() > 5) {
			throw new InvalidMoveException("Move cannot be more than 5 characters.");
		}
		
		if (m.length() < 3) {
			throw new InvalidMoveException("Move cannot be less than 3 characters.");
		}

		Character c0 = m.charAt(0);
		try {
			PieceType pt = PieceType.valueOf(c0.toString());
			if(pt.getColor() != playerTurn){
				throw new InvalidMoveException("Wrong piece seleted. Its " + playerTurn + " player turn.");
			}
		} catch (IllegalArgumentException e) {
			throw new InvalidMoveException("Move should start with correct piece type.");
		}

		String position = m.substring(m.length() - 2, m.length());
		try {
			Positions.valueOf(((Character) position.charAt(0)).toString());
		} catch (IllegalArgumentException e) {
			throw new InvalidMoveException("Please enter positions within range : a-h,1-8.");
		}

		Character c2 = position.charAt(1);

		if (Character.getNumericValue(c2) < 1 || Character.getNumericValue(c2) > 8) {
			throw new InvalidMoveException("Please enter positions within range : a-h,1-8.");
		}

		/*
		 * if(m.length() > 5){ throw new
		 * InvalidMoveException("Move cannot be more than 5 characters."); }
		 * 
		 * if(m.length() == 5){ Character c1 = m.charAt(0); try{
		 * PieceType.valueOf(c1.toString()); } catch (IllegalArgumentException
		 * e){ throw new
		 * InvalidMoveException("Move should start with correct piece type."); }
		 * finally { m = m.substring(1, m.length()); } }
		 * 
		 * if(m.length() == 4){ boolean b = false; Character c1 = m.charAt(0);
		 * for(PieceType pt : PieceType.values()){ if(c1.toString() ==
		 * pt.toString()){ b = true; break; } }
		 * 
		 * if(!b){ for(Positions p : Positions.values()){ if(c1.toString() ==
		 * p.toString()){ b = true; break; } } } if(!b){ throw new
		 * InvalidMoveException("Move should start with correct piece type or position."
		 * ); } m = m.substring(1, m.length()); }
		 * 
		 * if(m.length() == 3){ boolean b = false; Character c1 = m.charAt(0);
		 * for(PieceType pt : PieceType.values()){
		 * if(c1.toString().equals(pt.toString())){ b = true; break; } }
		 * 
		 * if(!b){ for(Positions p : Positions.values()){ if(c1.toString() ==
		 * p.toString()){ b = true; break; } } }
		 * 
		 * if(!b && "x".equalsIgnoreCase(c1.toString())){ b = true; } if(!b){
		 * throw new
		 * InvalidMoveException("Move should start with correct piece type or position."
		 * ); } m = m.substring(1, m.length()); }
		 * 
		 * if(m.length() == 2){ Character c1 = m.charAt(0); try{
		 * Positions.valueOf(c1.toString()); } catch (IllegalArgumentException
		 * e){ throw new
		 * InvalidMoveException("Please enter positions within range : a-h,1-8."
		 * ); }
		 * 
		 * Character c2 = m.charAt(1);
		 * 
		 * if(Character.getNumericValue(c2) < 1 || Character.getNumericValue(c2)
		 * > 8 ){ throw new
		 * InvalidMoveException("Please enter positions within range : a-h,1-8."
		 * ); } }
		 */
	}

}
