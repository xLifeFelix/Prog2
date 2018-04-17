package de.hsa.g17.fatsquirrel.core;

import java.util.Random;

public class XY {
	private final int x;
	private final int y;
	
	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public XY add(XY vector) {
		return new XY(x + vector.x, y + vector.y);
	}
	
	public static XY getRandomVector() {
		Random rand = new Random();
		int x, y;
		
		do {
			x = rand.nextInt(3) - 1;
			y = rand.nextInt(3) - 1;
		} while(x == 0 && y == 0);
		
		return new XY(x, y);
		
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}

	public String toString() {
		return "(" + x + "|" + y + ")";
	}
	
	public double distance(XY xy) {
		return Math.sqrt(Math.pow(x-xy.x, 2) + Math.pow(y-xy.y, 2));
	}
	
	public boolean equals(XY xy2) {
		return x == xy2.x && y == xy2.y;
	}
}