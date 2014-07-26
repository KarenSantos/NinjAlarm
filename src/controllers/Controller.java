package controllers;

import java.util.List;
import java.util.Set;

import models.Alarm;
import models.AlarmByDate;
import models.AlarmDate;
import models.AlarmTime;
import models.InvalidConfigurationException;
import models.InvalidNumberException;
import models.MyAlarms;
import models.Round;
import models.StopButton;
import models.Training;

/**
 * NinjAlarm Controller class
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class Controller {

	private Training training;
	private MyAlarms myAlarms;

	/**
	 * Creates a new NinjAlarm Controller
	 */
	public Controller() {
		training = new Training();
		myAlarms = new MyAlarms();
	}

	/**
	 * Retrieves the ArrayList of the alarms that have already been set up
	 * 
	 * @return The ArrayList of the Alarms
	 */
	public List<Alarm> getAlarms() {
		return myAlarms.getAlarms();
	}

	/**
	 * Returns an alarm by id
	 * 
	 * @param id
	 *            The id of the alarm
	 * @return the alarm or null if the alarm is not in my alarms
	 */
	public Alarm getAlarmById(int id) {
		return myAlarms.getAlarmById(id);
	}

	/**
	 * Adds an Alarm to the MyAlarms List.
	 * 
	 * @param hour
	 *            The hour of the alarm time.
	 * @param minute
	 *            The minute of the alarm time.
	 * @param year
	 *            The year of the alarm date.
	 * @param month
	 *            The month of the alarm date.
	 * @param day
	 *            The day of the alarm date.
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
	 *             If time is not valid or if the type number is not valid or if
	 *             the volume number is not valid or if the snooze interval is
	 *             not valid.
	 * @throws InvalidConfigurationException
	 *             If the date is a past date
	 */
	public void addAlarm(int hour, int minute, int year, int month, int day,
			Set<Integer> days, int AlarmType, int volume, String melody,
			boolean snooze, int snoozeInterval) throws InvalidNumberException,
			InvalidConfigurationException {

		AlarmTime time = new AlarmTime(hour, minute);
		if (year < 0) {
			myAlarms.addAlarmByWeekDay(time, days, AlarmType, volume, melody,
					snooze, snoozeInterval);
		} else {
			AlarmDate date = new AlarmDate(year, month, day);
			myAlarms.addAlarmByDate(time, date, AlarmType, volume, melody,
					snooze, snoozeInterval);
		}
	}

	/**
	 * Removes an Alarm from MyAlarms List
	 * 
	 * @param id
	 *            The id of the alarm to be deleted
	 */
	public void deleteAlarm(int id) {
		myAlarms.deleteAlarm(id);
	}

	/**
	 * Edits an alarm
	 * 
	 * @param id
	 *            The id of the alarm
	 * @param hour
	 *            The hour of the alarm time.
	 * @param minute
	 *            The minute of the alarm time.
	 * @param year
	 *            The year of the alarm date.
	 * @param month
	 *            The month of the alarm date.
	 * @param day
	 *            The day of the alarm date.
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
	public void editAlarmByDate(int id, int hour, int minute, int year,
			int month, int day, Set<Integer> days, int type, int volume,
			String melody, boolean snooze, int snoozeInterval)
			throws InvalidNumberException, InvalidConfigurationException {
		AlarmTime time = new AlarmTime(hour, minute);

		Alarm alarm = myAlarms.getAlarmById(id);
		if (alarm != null) {
			if (alarm instanceof AlarmByDate) {
				if (year < 0) {
					myAlarms.deleteAlarm(id);
					myAlarms.addAlarmByWeekDay(time, days, type, volume,
							melody, snooze, snoozeInterval);
				} else {
					AlarmDate date = new AlarmDate(year, month, day);
					myAlarms.editAlarmByDate(id, time, date, type, volume,
							melody, snooze, snoozeInterval);
				}
			} else {
				if (year < 0) {
					myAlarms.editAlarmByWeekDay(id, time, days, type, volume,
							melody, snooze, snoozeInterval);
				} else {
					AlarmDate date = new AlarmDate(year, month, day);
					myAlarms.deleteAlarm(id);
					myAlarms.addAlarmByDate(time, date, type, volume, melody,
							snooze, snoozeInterval);
				}
			}
		}
	}

	/**
	 * Returns the alarm with the closest alarm time
	 * 
	 * @return the alarm with the closest alarm time
	 */
	public Alarm getNextAlarm() {
		return myAlarms.getNextAlarm();
	}

	/**
	 * Activates the snooze of the alarm with the given id;
	 * 
	 * @param id
	 *            The id of the alarm to activate the snooze.
	 */
	public void activateSnooze(int id) {
		myAlarms.activateSnooze(id);
	}

	/**
	 * Dismisses the alarm with the given id and resets the snooze time.
	 * 
	 * @param id
	 *            The id of the alarm to be dismissed.
	 */
	public void dismissAlarm(int id) {
		myAlarms.dismissAlarm(id);
	}

	/**
	 * Returns the rounds list
	 * 
	 * @return the rounds
	 */
	public List<Round> getRounds() {
		return training.getRounds();
	}

	/**
	 * Adds the round to the rounds list
	 * 
	 * @param round
	 *            The round that was completed
	 */
	public void addRound(int time, StopButton button) {
		training.addRound(new Round(time, button));
	}

}
