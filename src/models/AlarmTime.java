package models;

import java.util.Calendar;

/**
 * Alarm time class.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class AlarmTime {

	private final int MAX_HOUR = 23;
	private final int MAX_MINUTE = 59;
	private final int MINIMUM = 0;
	private int hour;
	private int minute;

	/**
	 * Creates a new alarm time with the current hour and the current minute.
	 */
	public AlarmTime() {
		this.hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		this.minute = Calendar.getInstance().get(Calendar.MINUTE);
	}

	/**
	 * Creates a new alarm time with an hour and a minute.
	 * 
	 * @param hour
	 *            The hour for the time.
	 * @param minute
	 *            The minute for the time.
	 * @throws InvalidNumberException
	 *             If the hour is less than 0 or more than 23, if the minute is
	 *             less than 0 or more than 59.
	 */
	public AlarmTime(int hour, int minute) throws InvalidNumberException {
		setHour(hour);
		setMinute(minute);
	}

	/**
	 * Returns the hour of the alarm time.
	 * 
	 * @return The hour of the alarm time.
	 */
	public int getHour() {
		return this.hour;
	}

	/**
	 * Sets the hour of the alarm time.
	 * 
	 * @param hour
	 *            The new hour of the alarm time.
	 * @throws InvalidNumberException
	 *             If the hour is less than 0 or more than 23.
	 */
	public void setHour(int hour) throws InvalidNumberException {
		if (hour < MINIMUM || hour > MAX_HOUR) {
			throw new InvalidNumberException("The hour must be from 0 to 23");
		}
		this.hour = hour;
	}

	/**
	 * Returns the alarm time minute.
	 * 
	 * @return The alarm time minute.
	 */
	public int getMinute() {
		return this.minute;
	}

	/**
	 * Sets the alarm time minute.
	 * 
	 * @param minute
	 *            The new minute for the alarm time.
	 * @throws InvalidNumberException
	 *             If the minute is less than 0 or more than 59.
	 */
	public void setMinute(int minute) throws InvalidNumberException {
		if (minute < MINIMUM || minute > MAX_MINUTE) {
			throw new InvalidNumberException("The minute must be from 0 to 59");
		}
		this.minute = minute;
	}
}
