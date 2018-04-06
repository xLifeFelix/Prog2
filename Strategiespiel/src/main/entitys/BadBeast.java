package main.entitys;

import main.XY;

public class BadBeast extends Entity {
	
	private static final int DEFAULT_ENERGY = -150;
	
	public BadBeast(XY xy) {
		super(DEFAULT_ENERGY, xy);
	}
	
	public BadBeast(int x, int y) {
		super(DEFAULT_ENERGY, x, y);
	}

	@Override
	public void nextStep() {
		this.move(XY.getRandomVector());
	}
	
	public String toString() {
		return "BadBeast" + super.toString();
	}
	
}
