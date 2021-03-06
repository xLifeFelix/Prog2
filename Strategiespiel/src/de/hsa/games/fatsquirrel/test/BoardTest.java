package de.hsa.games.fatsquirrel.test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.hsa.games.fatsquirrel.botapi.BotControllerFactory;
import de.hsa.games.fatsquirrel.core.Board;
import de.hsa.games.fatsquirrel.core.BoardConfig;
import de.hsa.games.fatsquirrel.core.Entity;
import de.hsa.games.fatsquirrel.core.EntityContext;
import de.hsa.games.fatsquirrel.core.EntityType;
import de.hsa.games.fatsquirrel.core.FlattenedBoard;
import de.hsa.games.fatsquirrel.entities.GoodBeast;
import de.hsa.games.fatsquirrel.util.XY;

class BoardTest {
	
	BoardConfig cfg;
	BoardConfig cfgEmpty;
	
	@BeforeEach
	void setUp() {
		cfg = mock(BoardConfig.class);
		when(cfg.getNumBadBeast()).thenReturn(1);
		when(cfg.getNumBadPlant()).thenReturn(2);
		when(cfg.getNumGoodBeast()).thenReturn(3);
		when(cfg.getNumGoodPlant()).thenReturn(4);
		when(cfg.getNumWall()).thenReturn(5);
		when(cfg.getBots()).thenReturn(new LinkedList<Class<? extends BotControllerFactory>>());
		when(cfg.getSize()).thenReturn(new XY(20, 20));
		
		cfgEmpty = mock(BoardConfig.class);
		when(cfgEmpty.getNumBadBeast()).thenReturn(0);
		when(cfgEmpty.getNumBadPlant()).thenReturn(0);
		when(cfgEmpty.getNumGoodBeast()).thenReturn(0);
		when(cfgEmpty.getNumGoodPlant()).thenReturn(0);
		when(cfgEmpty.getNumWall()).thenReturn(0);
		when(cfgEmpty.getBots()).thenReturn(new LinkedList<Class<? extends BotControllerFactory>>());
		when(cfgEmpty.getSize()).thenReturn(new XY(20, 20));
	}
	
	@Test
	void testUpdate() {
		GoodBeast goodBeast = mock(GoodBeast.class);
		when(goodBeast.getXY()).thenReturn(new XY(5,5));
		when(goodBeast.getEntityType()).thenReturn(EntityType.GOOD_BEAST);
		Board board = new Board(cfgEmpty);
		board.insert(goodBeast);
		EntityContext con = board.flatten();
		
		board.update(con);
		
		verify(goodBeast).nextStep(con);
	}

	@Test
	void testFlatten() {
		Board board = new Board(cfg);
		
		FlattenedBoard flatBoard= board.flatten();
		assertTrue(flatBoard != null);
	}
	
	@Test
	void testInsert() {
		Board board = new Board(cfg);
		
		GoodBeast goodBeast = new GoodBeast(new XY(5, 5));
		board.insert(goodBeast);
		boolean found = false;
		for (Entity e : board.getEntitys()) {
			if (e.equals(goodBeast))
				found = true;
		}
		assertTrue(found);
	}
	
	@Test
	void testRemove() {
		Board board = new Board(cfg);
		GoodBeast goodBeast = new GoodBeast(new XY(5, 5));
		board.insert(goodBeast);
		board.remove(goodBeast);
		boolean found = false;
		for (Entity e : board.getEntitys()) {
			if (e.equals(goodBeast)) {
				found = true;
				break;
			}
		}
		
		assertFalse(found);
		
	}

	@Test
	void testGetEntitys() {
		Board board = new Board(cfg);
		Entity[] entities = board.getEntitys();
		int numBadBeast = 0;
		int numGoodBeast = 0;
		int numGoodPlant = 0;
		int numBadPlant = 0;
		int numWall = 0;
		for (Entity e : entities) {
			switch (e.getEntityType()) {
			case BAD_BEAST:
				numBadBeast++;
				break;
			case BAD_PLANT:
				numBadPlant++;
				break;
			case GOOD_BEAST:
				numGoodBeast++;
				break;
			case GOOD_PLANT:
				numGoodPlant++;
				break;
			case WALL:
				numWall++;
				break;
			default:
				break;
			}
		}
		
		assertEquals(1, numBadBeast);
		assertEquals(2, numBadPlant);
		assertEquals(3, numGoodBeast);
		assertEquals(4, numGoodPlant);
		assertEquals(20 + 20 + 18 + 18 + 5, numWall);
	}

	@Test
	void testGetConfig() {
		Board board = new Board(cfg);
		assertTrue(cfg == board.getConfig());
	}

}
