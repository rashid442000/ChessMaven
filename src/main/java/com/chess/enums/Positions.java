package com.chess.enums;

public enum Positions {
	a(0),b(1),c(2),d(3),e(4),f(5),g(6),h(7);
	
	private int numericValue;
	
	private Positions(int numericValue){
		this.numericValue = numericValue;
	}

	public int getNumericValue() {
		return numericValue;
	}

}
