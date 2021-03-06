package de.hsa.games.fatsquirrel.core;

import de.hsa.games.fatsquirrel.util.XY;

public class SpawnCommand extends GameCommand {
	
	private int energy;
	private XY spawnXY;
	
	public SpawnCommand(int energy, XY spawnXY) {
		super(Type.SPAWN);
		this.energy = energy;
		this.spawnXY = spawnXY;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public XY getSpawnXY() {
		return spawnXY;
	}
	
	
	
}
