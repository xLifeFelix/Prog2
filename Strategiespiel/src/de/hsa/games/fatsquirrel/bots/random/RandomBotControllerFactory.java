package de.hsa.games.fatsquirrel.bots.random;

import de.hsa.games.fatsquirrel.botapi.BotController;
import de.hsa.games.fatsquirrel.botapi.BotControllerFactory;

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