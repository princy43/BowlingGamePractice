package com.dev.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
public class BowlingGameTest {

	private BowlingGame game;
	
	@Test
	public void validateSetUp() {
		assertTrue(true);
	}
	
	@Before
	public void setUp() {
		 game = new BowlingGame();
	}
	
	@Test
	public void testGameScoreForGutterBalls() {
		rollPins(20,0);

		assertEquals(0, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenTwoPinsDownPerRoll() {
		rollPins(20,2);

		assertEquals(40, game.calculateScore());
	}
	
	private void rollPins(int roll,int pins) {
		for(int index=0;index<roll;index++) {
			game.roll(pins);
		}
	}
	
	@Test
	public void testGameScoreWhenRollsAreMiss() {
		game.roll(5);
		rollMiss();
		rollMiss();
		rollPins(17,1);
		
		assertEquals(22, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenOneSpare() {
		rollSpare(2);
		game.roll(7);
		rollPins(17,2);
		
		assertEquals(58, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenLastRollSpare() {
		rollPins(18,2);
		rollSpare(5);
		game.roll(2);
		
		assertEquals(48, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenMultipleSpareOccur() {
		rollPins(16,2);
		rollSpare(5);
		rollSpare(2);
		game.roll(5);
		
		assertEquals(59, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenSpareAndMissOccur() {
		rollPins(16,2);
		rollSpare(5);
		rollMiss();
		rollMiss();
		
		assertEquals(42, game.calculateScore());
	}
	
	private void rollSpare(int pins) {
		game.roll(pins);
		game.roll(10-pins);
	}
	
	private void rollMiss() {
		game.roll(0);
	}
	
	@Test
	public void testGameScoreWhenAllRollsAreSpare() {
		rollPins(20,5);
		game.roll(5);
		
		assertEquals(150, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenOneStrikeInGame() {
		rollStrike();
		game.roll(5);
		game.roll(3);
		rollPins(16,2);

		assertEquals(58, game.calculateScore());
	}
	
	private void rollStrike() {
		  game.roll(10);
	}
	
	@Test
	public void testGameScoreWhenAllRollsAreStrike() {
		rollPins(12,10);
	    assertEquals(300, game.calculateScore());
	  }
	
	@Test
	public void testGameScoreWhenStrikeSpareMiss() {
		
		rollStrike();
		rollSpare(5);
		rollMiss();
		rollPins(15,1);
		
		assertEquals(45, game.calculateScore());
	  }
	@Test
	public void testGameScoreWhenTenthFrameHasStrike() {
		rollPins(18,1);
		rollStrike();
		game.roll(5);
		game.roll(5);
		
		assertEquals(38, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenTenthFrameHasSpare() {
		rollPins(18,1);
		rollSpare(5);
		game.roll(5);
		
		assertEquals(33, game.calculateScore());
	}
		
}