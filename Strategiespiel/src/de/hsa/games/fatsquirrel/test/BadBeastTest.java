package de.hsa.games.fatsquirrel.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import de.hsa.games.fatsquirrel.core.EntityContext;
import de.hsa.games.fatsquirrel.entities.BadBeast;
import de.hsa.games.fatsquirrel.entities.HandOperatedMasterSquirrel;
import de.hsa.games.fatsquirrel.util.XY;

class BadBeastTest {

	@Test
	void testSimpleMove() {
		EntityContext con = mock(EntityContext.class);
		when(con.getSize()).thenReturn(new XY(10, 10));
		
		BadBeast badBeast = new BadBeast(new XY(1, 2));

		badBeast.nextStep(con);

		verify(con).tryMove(eq(badBeast), any(XY.class));
	}
	
	@Test
	void testEvery4Steps() {
		EntityContext con = mock(EntityContext.class);
		when(con.getSize()).thenReturn(new XY(10, 10));
		
		BadBeast badBeast = new BadBeast(new XY(3, 3));
		
		badBeast.nextStep(con);
		
		verify(con).tryMove(eq(badBeast), any(XY.class));
		
		for (int i = 0; i < 3; i++)
			badBeast.nextStep(con);
		
		verify(con, times(1)).tryMove(eq(badBeast), any(XY.class));
		
		badBeast.nextStep(con);

		verify(con, times(2)).tryMove(eq(badBeast), any(XY.class));
	}
	
	@Test
	void testBite() {
		EntityContext con = mock(EntityContext.class);
		when(con.getSize()).thenReturn(new XY(10, 10));
		
		BadBeast badBeast = new BadBeast(new XY(3, 3));
		
		assertEquals(badBeast.getBites(), 7);
		
		assertTrue(badBeast.bites(con));
		
		assertEquals(badBeast.getBites(), 6);
	}
	
	@Test
	void testFalseBooleanAfter7Bites() {
		EntityContext con = mock(EntityContext.class);
		when(con.getSize()).thenReturn(new XY(10, 10));
		
		BadBeast badBeast = new BadBeast(new XY(3, 3));
		
		
		for(int i = 0; i < 6; i++) {
			assertTrue(badBeast.bites(con));
		}
		assertFalse(badBeast.bites(con));
	}
	
	@Test
	void testChaseSquirrel() {
		EntityContext con = mock(EntityContext.class);
		
		when(con.getSize()).thenReturn(new XY(10, 10));
		when(con.nearestSquirrel(new XY(3,3))).thenReturn(new HandOperatedMasterSquirrel(new XY(5,5)));
		
		BadBeast badBeast = new BadBeast(new XY(3, 3));
		
		badBeast.nextStep(con);
		
		verify(con).tryMove(badBeast, new XY(1, 1));
	}	
}


















