package models;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Alarm by weekday class.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class AlarmByWeekday extends Alarm {

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
	public AlarmByWeekday() {
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
	 *             If any of the weekdays are not valid or if the set is null or
	 *             bigger than 7.
	 */
	public void setDays(Set<Integer> days) throws InvalidNumberException {

		if (days == null) {
			throw new InvalidNumberException("Invalid set.");
		}
		if (days.size() > SATURDAY) {
			throw new InvalidNumberException("Invalid size for the days set");
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
	public boolean getRepeat() {
		return this.repeat;
	}

	/**
	 * Sets the repeat option of the alarm.
	 * 
	 * @param repeat
	 *            The new repeat option of the alarm.
	 * 
	 */
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	/**
	 * Returns if the alarm is set for today.
	 * 
	 * @return True if the alarm date is today of False otherwise.
	 */
	@Override
	public boolean isForToday(){
		boolean response = false;
		int today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		if (this.days.contains(today)) {
			response = true;
		}
		return response;
	}

}
