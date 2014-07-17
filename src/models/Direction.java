package models;

import java.util.Random;

public class Direction {

	private Random rand = new Random();
	
	private int[] possibleDirections = {1,0,-1};
	
	private Tuple direction;
	
	public Direction(){
		direction = new Tuple(0,0);
	}
	
	public Tuple getDirection(){
		return direction;		
	}
	
	public int getX(){
		return direction.x;
	}
	
	public int getY(){
		return direction.y;
	}
	
	public void setDirection(){
		int randX = possibleDirections[rand.nextInt(3)];
		int randY = possibleDirections[rand.nextInt(3)];
		
		direction.x = randX;
		direction.y = randY;
	}
	
	
}
