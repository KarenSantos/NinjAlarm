package models;

/**
 * Round class 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 *
 */
public class Round implements Comparable<Round>{
	
	private int time;
	private StopButton button;
	
	/**
	 * Creates a new Round with time and a stopButton level 
	 * @param time
	 * 		the time of the round 
	 * @param button
	 * 		the button level
	 */
	public Round(int time, StopButton button) {
		this.time = time;
		this.button = button;
	}

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
	 * Returns the button of the round
	 * @return the button
	 */
	public StopButton getButton() {
		return button;
	}
	
	/**
	 * Sets the button 
	 * @param button
	 * 		The new button 
	 */
	public void setButton(StopButton button) {
		this.button = button;
	}

	@Override
	public int compareTo(Round r) {
		return this.time - r.getTime();
	}
	
	

}
