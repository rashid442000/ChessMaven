package com.chess.board;

import com.chess.enums.Positions;

public class Coordinates {
	private Integer x;
	private Integer y;
	
	private static Coordinates EMPTY_INSTANCE = new Coordinates();
	
	private Coordinates(){}
	
	private Coordinates(Integer x, Integer y) {
		super();
		this.setX(x);
		this.setY(y);
	}
	
	public static Coordinates getEmptyInstance(){
		return EMPTY_INSTANCE;
	}
	
	public static Coordinates getNewInstance(Integer x, Integer y){
		Coordinates c = null;
		if(x>=0 && x<8 && y>=0 && y<8){
			c = new Coordinates(x,y);
		} else {
			c = EMPTY_INSTANCE;
		}
		
		return c;
	}
	
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		if(x>=0 && x<8){
			this.x = x;
		}
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		if(y>=0 && y<8){
			this.y = y;
		}
	}
	
	public static Coordinates getCoordinateFromLocation(String m) {
		if(m.length() == 2){
			Character c1= m.charAt(0);
			Character c2= m.charAt(1);
			
			Positions p = Positions.valueOf(c1.toString());
			int y = p.getNumericValue();
			int x = 8-Character.getNumericValue(c2);
			
			return getNewInstance(x,y);
		}
		return EMPTY_INSTANCE;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

}
