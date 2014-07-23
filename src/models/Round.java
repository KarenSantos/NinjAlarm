package models;

/**
 * Round class 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 *
 */
public class Round {
	
	private int time;
	private StopButton level;
	
	/**
	 * Returns the time obtained in the round
	 * @return the time obtained
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * Change the actual time with the new one
	 * @param time
	 * 		the new time
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * Returns the level of the round
	 * @return the level
	 */
	public StopButton getLevel() {
		return level;
	}
	
	/**
	 * Sets the level 
	 * @param level
	 * 		The new level 
	 */
	public void setLevel(StopButton level) {
		this.level = level;
	}
	
	

}
