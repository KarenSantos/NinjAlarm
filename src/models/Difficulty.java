package models;

/**
 * Difficulty enumeration class.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public enum Difficulty {

	Normal("Normal", 1), Hard("Hard", 2), Ninja("Ninja", 3);

	private int speed;
	private String level;

	Difficulty(String level, int speed) {
		this.speed = speed;
		this.level = level;
	}

	/**
	 * Returns the speed value of the difficulty.
	 * 
	 * @return The speed value of the difficulty.
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Returns the type of the difficulty.
	 * 
	 * @return The type of the difficulty.
	 */
	public String getLevel() {
		return this.level;
	}
}
