package com.chess.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.chess.enums.Color;
import com.chess.enums.PieceType;
import com.chess.exceptions.InvalidFENException;

public class FENValidator {
	
	private static final int MAX_COUNT_FOR_COLOR = 16;
	
	private FENValidator(){}
	
	public static void validateFEN(String fenString) throws InvalidFENException {
		Map<PieceType, Integer> map = new HashMap<>();
		int totalWhiteCount = 0;
		int totalBlackCount = 0;
		
		String []fenStringAry = fenString.split(" ");
		if(fenStringAry.length < 3){
			throw new InvalidFENException("Not a valid FEN string. Please find the sample here - 'rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1'.");
		}
		
		String []fenAry = fenStringAry[0].split("/");
		if(fenAry.length != 8){
			throw new InvalidFENException("Not a valid FEN string. Please find the sample here - 'rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1'.");
		}
		
		for(String f : fenAry){
			for(int i = 0 ; i < f.length(); i++){
				Character c = f.charAt(i);
				if(Character.isDigit(c) && Character.getNumericValue(c) > 8){
					throw new InvalidFENException("Not a valid FEN string. Empty space for each row cannot be greater than 8.");
				} else if(Character.isAlphabetic(c)) {
					try{
						PieceType pt = PieceType.valueOf(c.toString());
						if(map.containsKey(pt)){
							Integer count = map.get(pt);
							map.put(pt, ++count);
						}else{
							map.put(pt, 1);
						}
						
						if(pt.getColor() == Color.WHITE){
							totalWhiteCount++;
						} else {
							totalBlackCount++;
						}
					} catch (IllegalArgumentException e){
						throw new InvalidFENException("Not a valid FEN string. Please enter a valid piece notation. Please find the sample here - 'rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1'.");
					}
				}
			}
		}
		
		if(totalBlackCount == 0 || totalBlackCount > MAX_COUNT_FOR_COLOR){
			throw new InvalidFENException("Not a valid FEN string. Black piece count is not valid.");
		}
		
		if(totalWhiteCount == 0 || totalWhiteCount > MAX_COUNT_FOR_COLOR){
			throw new InvalidFENException("Not a valid FEN string. White piece count is not valid.");
		}
		
		for(Entry<PieceType, Integer> e : map.entrySet()){
			if(e.getValue()>e.getKey().getMaxCountOnBoard()){
				throw new InvalidFENException("Not a valid FEN string. Piece count is more than the what is allowed. For piece " + e.getKey() + ", max allowed count is : " + e.getKey().getMaxCountOnBoard());
			}
		}
		
	}
}
