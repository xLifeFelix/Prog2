package de.hsa.g17.fatsquirrel.entities;

import de.hsa.g17.fatsquirrel.core.Board;
import de.hsa.g17.fatsquirrel.core.Entity;
import de.hsa.g17.fatsquirrel.core.EntityContext;
import de.hsa.g17.fatsquirrel.core.XY;

public abstract class Character extends Entity {

	public Character(int energy, XY xy) {
		super(energy, xy);
	}

	public Character(int energy, Board board) {
		super(energy, board);
	}
	
	abstract public void nextStep(EntityContext context);

}
