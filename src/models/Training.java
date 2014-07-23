package models;

import java.util.List;

/**
 * Training class 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 *
 */
public class Training {
	
	private StopButton stopButton;
	private List<Round> rank;
	
	/**
	 * Creates a section of training with a button
	 * @param stopButton
	 */
	public Training (StopButton stopButton) {
		this.stopButton = stopButton;
	}
	
	/**
	 * Add the round to the rank
	 * @param round
	 * 		The round that was completed
	 */
	public void addRound(Round round) {
		rank.add(round);
	}

	/**
	 * Returns the rank
	 * @return the existing rank 
	 */
	public List<Round> getRank() {
		return rank;
	}

	/**
	 * Change the actual Rank 
	 * @param rank
	 * 		The new rank 
	 */
	public void setRank(List<Round> rank) {
		this.rank = rank;
	}

	/**
	 * Returns the stop Button 
	 * @return the stop button
	 */
	public StopButton getStopButton() {
		return stopButton;
	}

	/**
	 * Change the actual stop Button
	 * @param stopButton
	 * 		The new stop button
	 */
	public void setStopButton(StopButton stopButton) {
		this.stopButton = stopButton;
	}
	
	

}
