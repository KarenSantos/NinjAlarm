package models;

import java.util.Random;

/**
 * Direction class
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class Direction {

	private Random rand = new Random();
	
	private int[] possibleDirections = {1,0,-1};
	
	private Tuple direction;
	
	/**
	 * A standard Direction begins with the coordinates set as a tuple of zeros. 
	 * 
	 */
	public Direction(){
		direction = new Tuple(0,0);
	}
	
	/**
	 * Return this direction in a tuple.
	 *             
	 * @return Tuple that represents this direction.
	 * 
	 **/
	public Tuple getDirection(){
		return direction;		
	}
	
	/**
	 * Return the first coordinate of the direction.
	 * 
	 * @return The first coordinate.
	 * 
	 **/
	public int getX(){
		return direction.x;
	}
	
	/**
	 * Return the second coordinate of the direction.
	 * 
	 * @return The second coordinate.
	 * 
	 **/
	public int getY(){
		return direction.y;
	}
	
	/**
	 * Change the direction to random coordinates.
	 * Each coordinate could be: 1, 0 or -1.
	 *  
	 **/
	public void setDirection(){
		int randX = possibleDirections[rand.nextInt(3)];
		int randY = possibleDirections[rand.nextInt(3)];
		
		direction.x = randX;
		direction.y = randY;
	}
	
	
}
