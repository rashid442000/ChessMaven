package com.chess.game;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chess.exceptions.InvalidFENException;

public class GameTest {
	
	@Test
	public void testMoveAllPiece() {
		try {
			Game game = Game.getNewInstance();
			game.move("Pa3");
			game.move("pa6");
			game.move("Pb3");
			game.move("pb6");
			game.move("Pc3");
			game.move("pc6");
			game.move("Pd3");
			game.move("pd6");
			game.move("Pe3");
			game.move("pe6");
			game.move("Pf3");
			game.move("pf6");
			game.move("Pg3");
			game.move("pg6");
			game.move("Ph3");
			game.move("ph6");
			
			game.move("Ra2");
			game.move("ra7");
			
			game.move("Bb2");
			game.move("bb7");
			
			game.move("Nd2");
			game.move("nd7");
			
			game.move("Qc2");
			game.move("qc7");
			
			game.move("Ke2");
			game.move("ke7");
			
			
			
		} catch (InvalidFENException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMove() {
		try {
			Game game = Game.getNewInstance();
			game.move("Pb3");
			game.move("nc6");
			game.move("Pb4");
			game.move("nxb4");
		} catch (InvalidFENException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMoveWrongPlayerTurn() {
		Game game;
		try {
			game = Game.getNewInstance();
			game.move("Pb3");
			game.move("Pc3");
		} catch (InvalidFENException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void illegalMove() {
		Game game;
		try {
			game = Game.getNewInstance();
			game.move("PPPPb3");
			game.move("c3");
			game.move("mmc3");
			game.move("Pl9");
			game.move("Pa9");
		} catch (InvalidFENException e) {
			e.printStackTrace();
		}
	}

}
