package models;

/**
 * StopButton class
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class StopButton {

	private Difficulty level;
	private Direction direction;
	private Tuple position;

	/**
	 * A standard StopButton begins with the level set as Normal, a default
	 * direction and the zero position.
	 */
	public StopButton() {
		level = Difficulty.Normal;
		direction = new Direction();
		position = new Tuple(0, 0);
	}

	/**
	 * Returns the stop button level 
	 * @return the stop button level 
	 */
	public Difficulty getLevel() {
		return level;
	}


	/**
	 * Change the difficulty level of the button.
	 * 
	 * @param level
	 *            The new level to be set.
	 * 
	 * @throws NullException
	 *             If the parameter is null.
	 **/
	public void setLevel(Difficulty level) throws InvalidConfigurationException {
		if (level == null) {
			throw new InvalidConfigurationException("Level cannot be null");
		}

		this.level = level;
	}

	/**
	 * Change the direction of the button.
	 * 
	 **/
	public void changeDirection() {
		direction.changeDirection();
	}
	
	/**
	 * Change the direction of the button.
	 * 
	 * @return The tuple representing the actual direction.
	 * 
	 **/
	public Tuple getDirection() {
		return direction.getDirection();
	}

	/**
	 * Change the position of the button, according to his level speed and
	 * direction.
	 * 
	 **/
	public void walk() {
		
		if(direction.getX() == 0 && direction.getY() == 0){
			direction.changeDirection();
		}
		
		position.setX(position.getX() + direction.getX());
		position.setY(position.getY() + direction.getY());
	}
	
	/**
	 * Returns the X value of the position.
	 * 
	 * @return The X value of the position.
	 */
	public int getPositionX(){
		return position.getX();
	}	

	/**
	 * Returns the Y value of the position.
	 * 
	 * @return The Y value of the position.
	 */
	public int getPositionY(){
		return position.getY();
	}
	
}
