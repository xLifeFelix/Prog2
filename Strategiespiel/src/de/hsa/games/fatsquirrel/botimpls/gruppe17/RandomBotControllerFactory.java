package de.hsa.games.fatsquirrel.botimpls.gruppe17;

import de.hsa.games.fatsquirrel.botapi.BotController;
import de.hsa.games.fatsquirrel.botapi.BotControllerFactory;

/**
 * A simple bot that randomly moves.
 */
public class RandomBotControllerFactory implements BotControllerFactory {

	@Override
	public BotController createMasterBotController() {
		return new RandomBotController();
	}

	@Override
	public BotController createMiniBotController() {
		return new RandomBotController();
	}

}
