package fr.excilys.formation.bowliwood;


import static org.junit.Assert.*;

import org.junit.Test;

public class ContinuousIntegrationTest {

	@Test
	/**
	 * Failing test. Should be changed for CI.
	 */
	public void TestMain()
	{
		assertEquals(1,Affichage.splashScreen());
		
	}
	
	public void TestPlayer(){
		Player p = new Player("toto") ;
		assertEquals(p.getName(), "toto") ;
 	}
	
	public void TestGame(){
		
	}
	
	public void TestScore(){
		assertTrue("Too high", 10 >= Game.getScore()) ;
		assertTrue("Too low", 0 <= Game.getScore()) ;
	}
}
