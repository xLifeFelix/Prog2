package de.hsa.g17.fatsquirrel.entities;

import de.hsa.g17.fatsquirrel.core.Board;
import de.hsa.g17.fatsquirrel.core.EntityContext;
import de.hsa.g17.fatsquirrel.core.XY;

public class GoodBeast extends Character {
	
	private static final int DEFAULT_ENERGY = 200;
	private int stepCount = 1;
	
	public GoodBeast(XY xy) {
		super(DEFAULT_ENERGY, xy);
	}
	
	public GoodBeast(Board board) {
		super(DEFAULT_ENERGY, board);
	}
	
	@Override
	public void nextStep(EntityContext context) {
		stepCount--;
		if(stepCount > 0)
			return;
		
		stepCount = 4;
		
		Squirrel s = context.nearestSquirrel(getXY());
		
		if (s != null) {
			XY squirrelPos = s.getXY();
			int x, y;
			int diff = squirrelPos.x() - getXY().x();
			if (diff > 0)
				x = -1;
			else if (diff < 0)
				x = 1;
			else
				x = 0;
			diff = squirrelPos.y() - getXY().y();
			if (diff > 0)
				y = -1;
			else if (diff < 0)
				y = 1;
			else
				y = 0;
			context.tryMove(this, new XY(x, y));
		} else {
			context.tryMove(this, XY.getRandomVector());
		}
	}
	
	public String toString() {
		return "GoodBeast" + super.toString();
	}
}
