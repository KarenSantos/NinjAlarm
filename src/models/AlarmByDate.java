package models;

/**
 * Alarm by date class.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class AlarmByDate extends Alarm {

	private AlarmDate date;

	/**
	 * Creates a new alarm by date with the default configuration for time,
	 * type, volume, melody, snooze, snooze interval and the current date.
	 */
	public AlarmByDate() {
		super();
		this.date = new AlarmDate();
	}

	/**
	 * Creates an alarm with a time, a date, type, volume, melody, snooze and
	 * snooze interval.
	 * 
	 * @param time
	 *            The time when the alarm will go off.
	 * @param date
	 *            The date when the alarm will go off.
	 * @param type
	 *            The number for the type of the alarm.
	 * @param volume
	 *            The volume for the melody of the alarm.
	 * @param melody
	 *            The melody to be played when the alarm goes off.
	 * @param snooze
	 *            The on or off snooze indication.
	 * @param snoozeInterval
	 *            The time interval set when snooze function is on.
	 * @throws InvalidNumberException
	 *             If time is not valid or if the type number is not valid or if
	 *             the volume number is not valid or if the snooze interval is
	 *             not valid.
	 */
	public AlarmByDate(AlarmTime time, AlarmDate date, int type, int volume,
			String melody, boolean snooze, int snoozeInterval)
			throws InvalidNumberException {
		super(time, type, volume, melody, snooze, snoozeInterval);
		if (date == null){
			this.date = new AlarmDate();
		} else {
			this.date = date;
		}
	}

	/**
	 * Returns the alarm date.
	 * 
	 * @return The alarm date.
	 */
	public AlarmDate getDate() {
		return date;
	}

	/**
	 * Sets the alarm date with a year, month and day.
	 * 
	 * @param year
	 *            The year of the date.
	 * @param month
	 *            The month of the date.
	 * @param day
	 *            The day of the date.
	 * @throws InvalidNumberException
	 *             If the date is a past date, or an invalid date.
	 */
	public void setDate(int year, int month, int day)
			throws InvalidNumberException {
		this.date = new AlarmDate(year, month, day);
	}
}
