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
	 * @param date
	 *            The new date of the date.
	 */
	public void setDate(AlarmDate date) {
		this.date = date;
	}

	/**
	 * Returns if the alarm is set for today.
	 * 
	 * @return True if the alarm date is today of False otherwise.
	 */
	@Override
	public boolean isForToday() {
		boolean resp = false;
		if (this.date.isCurrentDate()) {
			resp = true;
		}
		return resp;
	}
}
