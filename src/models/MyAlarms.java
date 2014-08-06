package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * My alarms manager class
 * 
 * @author Ana, Felipe, Karen, Marcos and Maysa
 * 
 */

public class MyAlarms {

	private final int MAX_MINUTES = 1440;

	private int idCount;
	private List<Alarm> myAlarms;

	/**
	 * Creates a new MyAlarms with an id counter and a list of alarms
	 */
	public MyAlarms() {
		this.idCount = 1;
		this.myAlarms = new ArrayList<Alarm>();
	}

	/**
	 * Retrieves the ArrayList of the alarms that have already been set up
	 * 
	 * @return The ArrayList of the Alarms
	 */
	public List<Alarm> getAlarms() {
		return myAlarms;
	}

	/**
	 * Returns an alarm by id
	 * 
	 * @param id
	 *            The id of the alarm
	 * @return the alarm or null if the alarm is not in my alarms
	 */
	public Alarm getAlarmById(int id) {
		Alarm alarm = null;
		for (Alarm a : myAlarms) {
			if (a.getId() == id) {
				alarm = a;
			}
		}
		return alarm;
	}

	/**
	 * Adds an Alarm to MyAlarms List.
	 * 
	 * @param alarm
	 *            The alarm to be added.
	 */
	public void addAlarm(Alarm alarm) {
		alarm.setId(idCount);
		myAlarms.add(alarm);
		idCount++;
		Collections.sort(myAlarms);
	}

	/**
	 * Removes an Alarm from MyAlarms List
	 * 
	 * @param id
	 *            The id of the alarm to be deleted
	 */
	public void deleteAlarm(int id) {
		Alarm alarm = getAlarmById(id);
		if (alarm != null) {
			myAlarms.remove(alarm);
		}
	}

	/**
	 * Sets an alarm time.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param time
	 *            The new time of the alarm.
	 * @throws InvalidConfigurationException
	 *             If the alarm is an alarmByDate set for today and time is a past time.
	 */
	public void setAlarmTime(int id, AlarmTime time)
			throws InvalidConfigurationException {
		Alarm alarm = getAlarmById(id);
		if (alarm != null) {
			if (alarm instanceof AlarmByDate && alarm.isForToday()) {
				if (time.isPastTime()) {
					throw new InvalidConfigurationException(
							"Invalid time for today.");
				}
			}
			alarm.setTime(time);
		}
	}

	/**
	 * Sets an AlarmByDate date.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param date
	 *            The new date of the alarm.
	 */
	public void setAlarmDate(int id, AlarmDate date) {
		Alarm alarm = getAlarmById(id);
		if (alarm != null && alarm instanceof AlarmByDate) {
			((AlarmByDate) alarm).setDate(date);
		}
	}

	/**
	 * Sets an AlarmByWeekday days.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param days
	 *            The new days list of the alarm.
	 * @throws InvalidNumberException
	 *             If any of the weekdays are not valid or if the set is null or
	 *             bigger than 7.
	 */
	public void setAlarmDays(int id, Set<Integer> days)
			throws InvalidNumberException {
		Alarm alarm = getAlarmById(id);
		if (alarm != null && alarm instanceof AlarmByWeekday) {
			((AlarmByWeekday) alarm).setDays(days);
		}
	}

	/**
	 * Sets an alarm repeat option.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param repeat
	 *            The new repeat option of the alarm.
	 */
	public void setAlarmRepeat(int id, boolean repeat)
			throws InvalidNumberException {
		Alarm alarm = getAlarmById(id);
		if (alarm != null && alarm instanceof AlarmByWeekday) {
			((AlarmByWeekday) alarm).setRepeat(repeat);
		}
	}

	/**
	 * Sets an alarm type.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param type
	 *            The new type of the alarm.
	 */
	public void setAlarmType(int id, AlarmType type)
			throws InvalidNumberException {
		Alarm alarm = getAlarmById(id);
		if (alarm != null) {
			alarm.setType(type);
		}
	}

	/**
	 * Sets an alarm volume.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param volume
	 *            The new volume of the alarm.
	 * @throws InvalidNumberException
	 *             If the number for the volume is less than 0 or more than 100.
	 */
	public void setAlarmVolume(int id, int volume)
			throws InvalidNumberException {
		Alarm alarm = getAlarmById(id);
		if (alarm != null) {
			alarm.setVolume(volume);
		}
	}

	/**
	 * Sets an alarm melody.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param melody
	 *            The new melody of the alarm.
	 */
	public void setAlarmMelody(int id, String melody) {
		Alarm alarm = getAlarmById(id);
		if (alarm != null) {
			alarm.setMelody(melody);
		}
	}

	/**
	 * Sets an alarm snooze option.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param snooze
	 *            The new snooze option of the alarm.
	 */
	public void setAlarmSnooze(int id, boolean snooze) {
		Alarm alarm = getAlarmById(id);
		if (alarm != null) {
			alarm.setSnooze(snooze);
		}
	}

	/**
	 * Sets an alarm snooze interval.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param snoozeInterval
	 *            The new snoozeInterval of the alarm.
	 * @throws InvalidNumberException
	 *             If the snooze time interval is less than 1 or more than 60.
	 */
	public void setAlarmSnoozeInterval(int id, int snoozeInterval)
			throws InvalidNumberException {
		Alarm alarm = getAlarmById(id);
		if (alarm != null) {
			alarm.setSnoozeInterval(snoozeInterval);
		}
	}

	/**
	 * Sets an alarm power option on of off.
	 * 
	 * @param id
	 *            The id of the alarm to be set.
	 * @param power
	 *            The new power option of the alarm.
	 */
	public void setAlarmPower(int id, boolean power) {
		Alarm alarm = getAlarmById(id);
		if (alarm != null) {
			alarm.setPower(power);
		}
	}

	/**
	 * Activates the snooze of the alarm with the given id;
	 * 
	 * @param id
	 *            The id of the alarm to activate the snooze.
	 */
	public void activateSnooze(int id) {
		getAlarmById(id).activateSnooze();
	}

	/**
	 * Dismisses the alarm with the given id and resets the snooze time.
	 * 
	 * @param id
	 *            The id of the alarm to be dismissed.
	 */
	public void dismissAlarm(int id) {
		getAlarmById(id).dismissAlarm();
	}

	/**
	 * Returns the alarm with the closest alarm time
	 * 
	 * @return the alarm with the closest alarm time
	 */
	public Alarm getNextAlarm() {
		Alarm nextAlarm = null;
		if (!myAlarms.isEmpty()) {
			int now = new AlarmTime().changeToMinutes();
			int nextBest = MAX_MINUTES;

			for (Alarm a : myAlarms) {
				if (a.getPower() && a.isForToday()) {
					int next = a.getTime().changeToMinutes();
					int num = next - now;
					if (num > 0 && num < nextBest) {
						nextBest = num;
						nextAlarm = a;
					}
					if (a.getSnooze()) {
						next = a.getSnoozeTime().changeToMinutes();
						num = next - now;
						if (num > 0 && num < nextBest) {
							nextBest = num;
							nextAlarm = a;
						}
					}
				}
			}
		}
		return nextAlarm;
	}
}
