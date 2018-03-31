package main;

public class Wall extends Entity{
	
	private static final int DEFAULT_ENERGY = -10;
	
	public Wall(int id, XY xy) {
		super(id, DEFAULT_ENERGY, xy);
	}

}
