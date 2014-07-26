package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * My alarms manager class
 * 
 * @author Ana, Felipe, Karen, Marcos and Maysa
 * 
 */

public class MyAlarms {

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
	public List<Alarm> getMyAlarms() {
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
	 * Adds an Alarm by date to the MyAlarms List.
	 * 
	 * @param id
	 *            The id of the alarm
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
	 * @throws InvalidConfigurationException
	 *             If the date is a past date
	 */
	public void addAlarmByDate(AlarmTime time, AlarmDate date, int AlarmType,
			int volume, String melody, boolean snooze, int snoozeInterval)
			throws InvalidNumberException, InvalidConfigurationException {
		if (date.isPastDate()) {
			throw new InvalidConfigurationException(
					"The date can't be a past date");
		}

		if (date.isCurrentDate() && time.isPastTime()) {
			throw new InvalidConfigurationException(
					"The time can't be a past time for today");
		}

		myAlarms.add(new AlarmByDate(idCount, time, date, AlarmType, volume,
				melody, snooze, snoozeInterval));
		idCount++;
	}

	/**
	 * Adds an Alarm by date to the MyAlarms List.
	 * 
	 * @param id
	 *            The id of the alarm
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
	public void addAlarmByWeekDay(AlarmTime time, Set<Integer> days,
			int AlarmType, int volume, String melody, boolean snooze,
			int snoozeInterval) throws InvalidNumberException {
		myAlarms.add(new AlarmByWeekDay(idCount, time, days, AlarmType, volume,
				melody, snooze, snoozeInterval));
		idCount++;
	}

	/**
	 * Removes an Alarm from MyAlarms List
	 * 
	 * @param id
	 *            The id of the alarm to be deleted
	 */
	public void deleteAlarm(int id) {
		Alarm alarm = getAlarmById(id);
		if (alarm != null && myAlarms.contains(alarm)) {
			myAlarms.remove(alarm);
		}
	}

	/**
	 * Edits an alarm by date
	 * 
	 * @param id
	 *            The id of the alarm
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
	 *             If the alarm id is not valid or if time is not valid or if
	 *             the type number is not valid or if the volume number is not
	 *             valid or if the snooze interval is not valid.
	 * @throws InvalidConfigurationException
	 *             If the date is a past date
	 */
	public void editAlarmByDate(int id, AlarmTime time, AlarmDate date,
			int type, int volume, String melody, boolean snooze,
			int snoozeInterval) throws InvalidNumberException,
			InvalidConfigurationException {

		AlarmByDate alarm = (AlarmByDate) getAlarmById(id);
		if (alarm == null) {
			throw new InvalidNumberException("This alarm does not exist");
		}

		if (date.isPastDate()) {
			throw new InvalidConfigurationException(
					"The date can't be a past date");
		}

		if (date.isCurrentDate() && time.isPastTime()) {
			throw new InvalidConfigurationException(
					"The time can't be a past time for today");
		}

		alarm.setTime(time);
		alarm.setDate(date);
		alarm.setType(type);
		alarm.setVolume(volume);
		alarm.setMelody(melody);
		alarm.setSnooze(snooze);
		alarm.setSnoozeInterval(snoozeInterval);
	}

	/**
	 * Edits an alarm by date
	 * 
	 * @param id
	 *            The id of the alarm
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
	 *             If the alarm id is not valid or if time is not valid or if
	 *             the type number is not valid or if the volume number is not
	 *             valid or if the snooze interval is not valid.
	 * @throws InvalidConfigurationException
	 *             If the date is a past date
	 */
	public void editAlarmByWeekDay(int id, AlarmTime time, Set<Integer> days,
			int type, int volume, String melody, boolean snooze,
			int snoozeInterval) throws InvalidNumberException,
			InvalidConfigurationException {

		AlarmByWeekDay alarm = (AlarmByWeekDay) getAlarmById(id);
		if (alarm == null) {
			throw new InvalidNumberException("This alarm does not exist");
		}
		alarm.setTime(time);
		alarm.setDays(days);
		alarm.setType(type);
		alarm.setVolume(volume);
		alarm.setMelody(melody);
		alarm.setSnooze(snooze);
		alarm.setSnoozeInterval(snoozeInterval);
	}

	/**
	 * Returns the alarm with the closest alarm time
	 * @return the alarm with the closest alarm time
	 */
	public Alarm getNextAlarm() {
		Alarm nextAlarm = null;
		if (!myAlarms.isEmpty()) {
			int now = new AlarmTime().changeToMinutes();
			nextAlarm = myAlarms.get(0);

			for (Alarm a : myAlarms) {
				int next = a.getTime().changeToMinutes();
				int num = next - now;
				if (num > 0 && num < nextAlarm.getTime().changeToMinutes()) {
					nextAlarm = a;
				}
			}
		}
		return nextAlarm;
	}
}
