package fr.excilys.formation.bowliwood;


import static org.junit.Assert.*;

import org.junit.Test;

public class ContinuousIntegrationTest {

	@Test
	/**
	 * Failing test. Should be changed for CI.
	 */
	public void TestSkipped()
	{
		Player p = new Player("toto") ;
		p.setSkippedScore(false, 5);
		assertEquals(p.getNextTurn(0), 5) ;
	}
	@Test
	public void TestPreviousSkipped()
	{
		Player p = new Player("toto") ;
		p.setSkippedScore(false, 5);
		assertEquals(p.getPreviousTurn(5), 0) ;
	}
	@Test
	public void TestNextScore(){
		Player p = new Player("toto") ;
		p.setSkippedScore(false, 5);
		p.updateScore(10, 5);
		assertEquals(p.getNextScore(0), 10) ;
	}
	@Test
	public void TestNextNextScore(){
		Player p = new Player("toto") ;
		p.setSkippedScore(false, 5);
		p.setSkippedScore(false, 7);
		p.updateScore(3, 5);
		p.updateScore(10, 7);
		assertEquals(p.getNextNextScore(0), 10) ;
	}
	@Test
	public void TestNextScoreDefault(){
		Player p = new Player("toto") ;
		p.setSkippedScore(false, 5);
		assertEquals(p.getNextScore(0), 0) ;
	}
	@Test
	public void TestNextNextScoreDefault(){
		Player p = new Player("toto") ;
		p.setSkippedScore(false, 5);
		p.setSkippedScore(false, 7);
		assertEquals(p.getNextNextScore(0), 0) ;
	}
	
	public void TestPlayTurn(){
		
 	}
	
	public void TestGame(){
		
	}
	
	
}
