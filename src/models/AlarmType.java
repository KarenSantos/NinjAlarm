package models;

/**
 * Alarm type enumeration class.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public enum AlarmType {

	MELODY(1), MELODY_VIBRATION(2), VIBRATION(3);

	private int typeNum;

	/**
	 * Creates a new alarm type.
	 * 
	 * @param type
	 */
	private AlarmType(int type) {
		this.typeNum = type;
	}

	/**
	 * Returns the value of the alarm type.
	 * 
	 * @return The value of the alarm type.
	 */
	public int getValue() {
		return typeNum;
	}
}
