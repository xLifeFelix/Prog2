package main.entitys;

import main.XY;

abstract class MasterSquirrel extends Squirrel {
	
	private final static int DEFAULT_ENERGY = 1000;
	
	public MasterSquirrel( XY xy) {
		super(DEFAULT_ENERGY, xy);
	}
	
	public MasterSquirrel(int x, int y) {
		super(DEFAULT_ENERGY, x, y);
	}
	
	public boolean isChild(Entity e) {
		
		if(e instanceof MiniSquirrel) {
			MiniSquirrel child = (MiniSquirrel) e;
			
			if(child.getMasterID() == this.getID())
				return true;
		}
		
		return false;
	}

}
