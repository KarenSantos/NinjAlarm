package tests;

import models.Direction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectionTest {

	Direction dir;
	
	@Before
	public void setUp(){
		dir =  new Direction();
	}
	
	@Test
	public void testBeginWithZero(){
		Assert.assertTrue(dir.getX() == 0 && dir.getY() == 0);
	}
	
	@Test
	public void testFirstChange(){
		
		Assert.assertTrue(dir.getX() == 0 && dir.getY() == 0);
		dir.changeDirection();
		Assert.assertFalse(dir.getX() == 0 && dir.getY() == 0);
	}
	
	@Test
	public void testCouldntBackToZeroZero(){
		
		for (int i = 0; i < 50; i++) {
			dir.changeDirection();
			Assert.assertFalse(dir.getX() == 0 && dir.getY() == 0);
		}
	}
	
}

