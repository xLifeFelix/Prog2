package de.hsa.g17.fatsquirrel.core;

import java.io.IOException;

public class ConsoleUI implements UI {

	@Override
	public MoveCommand getCommand() {
		System.out.println("Where do you want to go?\n"
				+ "123\n"
				+ "4S5\n"
				+ "678\n"
				+ "> ");
		
		int i;
		
		try {
			do {
				i = System.in.read();
			} while (i < '1' || i > '8');
			
			i -= '0';
			
		} catch (IOException e) {
			i = 2;
			e.printStackTrace();
		}
		
		// Richtungsvektor in X-Richtung
		// i Modulo 3 gibt Zahlen zwischen 0 und 2
		// i muss ab der 4 nur um eines verschoben werden, da
		// 5 nicht die Mitte ist sondern um eines verschoben ist
		int x = (i>4?i:i-1) % 3 - 1;
		
		// Richtungsvektor in Y-Richtung
		int y;
		
		if (i > 5)
			y = 1;
		else if (i > 3)
			y = 0;
		else
			y = -1;
		
		return new MoveCommand(new XY (x, y));
	}

	@Override
	public void render(BoardView view) {
		for (int y = 0; y < view.getSize().y(); y++) {
			for (int x = 0; x < view.getSize().x(); x++) {
				char c;
				switch(view.getEntityType(new XY(x, y))) {
				case GOOD_BEAST:
					c = 'G';
					break;
				case BAD_BEAST:
					c = 'B';
					break;
				case GOOD_PLANT:
					c = 'g';
					break;
				case BAD_PLANT:
					c = 'b';
					break;
				case MASTER_SQUIRREL:
					c = 'M';
					break;
				case MINI_SQUIRREL:
					c = 'm';
					break;
				case WALL:
					c = '#';
					break;
				default:
					c = ' ';
					break;
				}
				System.out.print(c);
			}
			System.out.println();
		}

	}

}