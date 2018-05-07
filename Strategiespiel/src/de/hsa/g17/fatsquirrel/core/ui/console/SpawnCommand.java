package de.hsa.g17.fatsquirrel.core.ui.console;

import de.hsa.g17.fatsquirrel.core.GameCommand;
import de.hsa.g17.fatsquirrel.core.XY;

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