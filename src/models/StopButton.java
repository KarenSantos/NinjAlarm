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
	
	Tuple position = new Tuple(0,0);
	
	/**
	 * A standard StopButton begins with the level set as Normal. 
	 * 
	 */
	public StopButton(){
		level = Difficulty.Normal;
	}
	
	/**
	 * Change the difficulty level of the button.
	 * 
	 * @param level
	 *            The new level to be set.
	 * 
	 * @throws NullException
	 *			  If the parameter is null.
	 **/            
	public void setLevel(Difficulty level) throws Exception{
		if(level == null){
			throw new Exception("Level couldn't be null");
		}
		
		this.level = level;
	}
	
	/**
	 * Change the direction of the button.
	 *  
	 **/  
	public void changeDirection(){
		direction.setDirection();	
	}
	
	/**
	 * Change the position of the button, according to his level speed and direction.
	 *  
	 **/
	public void walk() {				
		position.x += level.getSpeed()*direction.getX();
		position.y += level.getSpeed()*direction.getY();		
	}	

}
