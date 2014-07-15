package models;

import java.util.HashSet;
import java.util.Set;

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

	public AlarmByWeekDay() {
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

	public AlarmByWeekDay(AlarmTime time, Set<Integer> days, AlarmType type,
			int volume, String melody, boolean snooze, int snoozeInterval)
			throws InvalidNumberException, InvalidAlarmConfiguration {
		super(time, type, volume, melody, snooze, snoozeInterval);
		setDays(days);
	}

	public Set<Integer> getDays() {
		return days;
	}

	public void setDays(Set<Integer> days) throws InvalidNumberException {

		for (Integer i : days) {
			if (i < MONDAY || i > SATURDAY) {
				throw new InvalidNumberException("Invalid number for a weekday");
			}
		}
		this.days.clear();
		this.days.addAll(days);
	}

	public void setRepeatOn() {
		this.repeat = true;
	}

	public void setRepeatOff() {
		this.repeat = false;
	}

	public boolean repeat() {
		return this.repeat;
	}

}
