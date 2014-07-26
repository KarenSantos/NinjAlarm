package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Training class 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 *
 */
public class Training {
	
	private List<Round> rounds;
	private final int MAX_ROUNDS = 15;

	/**
	 * Creates a new Training section
	 */
	public Training() {
		rounds = new ArrayList<Round>();
	}
	
	/**
	 * Returns the rounds list
	 * @return the rounds 
	 */
	public List<Round> getRounds() {
		return rounds;
	}
	
	/**
	 * Adds the round to the rounds list
	 * @param round
	 * 		The round that was completed
	 */
	public void addRound(Round round) {
		rounds.add(round);
		Collections.sort(rounds);
		if(rounds.size() > MAX_ROUNDS) {
			rounds.remove(rounds.get(MAX_ROUNDS));
		}
	}


}
