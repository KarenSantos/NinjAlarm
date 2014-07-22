package models;

import java.util.HashSet;
import java.util.Set;

/**
 * Alarm by weekday class.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class AlarmByWeekDay extends Alarm {

	private final int SUNDAY = 1;
	private final int MONDAY = 2;
	private final int TUESDAY = 3;
	private final int WEDNESDAY = 4;
	private final int THURSDAY = 5;
	private final int FRIDAY = 6;
	private final int SATURDAY = 7;

	private Set<Integer> days;
	private boolean repeat;

	/**
	 * Creates a new alarm by weekday with the default configuration for time,
	 * type, volume, melody, snooze, snooze interval and for all weekdays.
	 */
	public AlarmByWeekDay() {
		super();
		this.days = new HashSet<Integer>();
		days.add(SUNDAY);
		days.add(MONDAY);
		days.add(TUESDAY);
		days.add(WEDNESDAY);
		days.add(THURSDAY);
		days.add(FRIDAY);
		days.add(SATURDAY);

		this.repeat = true;
	}

	/**
	 * Creates an alarm with a time, a date, type, volume, melody, snooze and
	 * snooze interval.
	 * 
	 * @param time
	 *            The time when the alarm will go off.
	 * @param days
	 *            The set of the chosen weekdays.
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
	 *             If time is not valid or if the numbers for the weekdays are
	 *             not valid or if the type number is not valid or if the volume
	 *             number is not valid or if the snooze interval is not valid.
	 */
	public AlarmByWeekDay(AlarmTime time, Set<Integer> days, int type,
			int volume, String melody, boolean snooze, int snoozeInterval)
			throws InvalidNumberException {
		super(time, type, volume, melody, snooze, snoozeInterval);
		setDays(days);
	}

	/**
	 * Returns the set of the chosen weekdays for the alarm to go off.
	 * 
	 * @return The set of the weekdays.
	 */
	public Set<Integer> getDays() {
		return days;
	}

	/**
	 * Sets the weekdays for the alarm to go off from 1 Sunday to 7 Saturday.
	 * 
	 * @param days
	 *            The new set with the weekdays.
	 * @throws InvalidNumberException
	 *             If any of the weekdays are not valid or if the set is null.
	 */
	public void setDays(Set<Integer> days) throws InvalidNumberException {

		if (days == null){
			throw new InvalidNumberException("Invalid set.");
		}
		for (Integer i : days) {
			if (i < MONDAY || i > SATURDAY) {
				throw new InvalidNumberException("Invalid number for a weekday");
			}
		}
		this.days.clear();
		this.days.addAll(days);
	}

	/**
	 * Returns the indication if the repeat function is on.
	 * 
	 * @return The indication if the repeat function is on.
	 */
	public boolean repeat() {
		return this.repeat;
	}

	/**
	 * Sets the repeat function on.
	 */
	public void setRepeatOn() {
		this.repeat = true;
	}

	/**
	 * Sets the repeat function off.
	 */
	public void setRepeatOff() {
		this.repeat = false;
	}

}
