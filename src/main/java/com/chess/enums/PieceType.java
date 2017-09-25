package com.chess.enums;

public enum PieceType {
	//white is upper case
	r(PieceName.ROOK,Color.BLACK,10),
	n(PieceName.KNIGHT,Color.BLACK,10),
	b(PieceName.BISHOP,Color.BLACK,10),
	q(PieceName.QUEEN,Color.BLACK,9),
	k(PieceName.KING,Color.BLACK,1),
	p(PieceName.PAWN,Color.BLACK,8),
	
	R(PieceName.ROOK,Color.WHITE,10),
	N(PieceName.KNIGHT,Color.WHITE,10),
	B(PieceName.BISHOP,Color.WHITE,10),
	Q(PieceName.QUEEN,Color.WHITE,9),
	K(PieceName.KING,Color.WHITE,1),
	P(PieceName.PAWN,Color.WHITE,8);
	
	private int maxCountOnBoard;
	private Color color;
	private PieceName name;
	
	private PieceType(PieceName name, Color color, int maxCountOnBoard){
		this.name= name;
		this.color = color;
		this.maxCountOnBoard = maxCountOnBoard;
	}

	public int getMaxCountOnBoard() {
		return maxCountOnBoard;
	}

	public Color getColor() {
		return color;
	}

	public PieceName getName() {
		return name;
	}
	
}
