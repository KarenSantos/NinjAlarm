package tests;

import static org.junit.Assert.*;
import models.Difficulty;
import models.Direction;
import models.StopButton;
import models.Tuple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ButtonTest {

	
	StopButton stop;
	
	@Before
	public void setUp(){
		stop = new StopButton();
	}
	
	@Test
	public void testDefaultButton() {
		Assert.assertEquals(stop.getLevel(), Difficulty.Normal);
		
		Assert.assertTrue(stop.getPositionX() == 0 && stop.getPositionY() == 0);
		
	}
	
	@Test
	public void testSetLevel() {
		
		try {
			stop.setLevel(null);
		} catch (Exception e) {
			Assert.assertEquals("Level cannot be null", e.getMessage());
		}
		
		try {
			
			Assert.assertEquals(stop.getLevel(), Difficulty.Normal);
			stop.setLevel(Difficulty.Hard);
			Assert.assertEquals(stop.getLevel(), Difficulty.Hard);			
		} catch (Exception e) {}
	}
	
	@Test
	public void testWalk() {
		int pX, pY;
		
		Tuple dir = stop.getDirection();
		
		pX = stop.getPositionX();
		pY = stop.getPositionY();
		
		stop.walk();
				
		Assert.assertEquals(stop.getPositionX(), pX + dir.getX());
		Assert.assertEquals(stop.getPositionY(), pY + dir.getY());
		
		stop.walk();
		stop.walk();
		
		Assert.assertEquals(stop.getPositionX(), pX + 3*dir.getX());
		Assert.assertEquals(stop.getPositionY(), pY + 3*dir.getY());
	}
	
	@Test
	public void testWalkAndChange() {
		int pX, pY;
		
		Tuple dir = stop.getDirection();
		
		pX = stop.getPositionX();
		pY = stop.getPositionY();
		
		stop.walk();
				
		Assert.assertEquals(stop.getPositionX(), pX + dir.getX());
		Assert.assertEquals(stop.getPositionY(), pY + dir.getY());
		
		pX = stop.getPositionX();
		pY = stop.getPositionY();
		
		stop.changeDirection();
						
		Assert.assertEquals(stop.getPositionX(), pX );
		Assert.assertEquals(stop.getPositionY(), pY );
		
		dir = stop.getDirection();
		
		stop.walk();
		
		Assert.assertEquals(stop.getPositionX(), pX + dir.getX());
		Assert.assertEquals(stop.getPositionY(), pY + dir.getY());
		
		
	}
	
}
