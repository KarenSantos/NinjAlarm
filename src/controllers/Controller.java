package controllers;

import java.util.List;
import java.util.Set;

import models.Alarm;
import models.AlarmDate;
import models.AlarmTime;
import models.AlarmType;
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

	private static Controller controller;

	private Training training;
	private MyAlarms myAlarms;

	/**
	 * Creates a new NinjAlarm Controller.
	 */
	private Controller() {
		training = new Training();
		myAlarms = new MyAlarms();
	}

	/**
	 * Returns a singleton NinjAlarm Controller.
	 * 
	 * @return A NinjAlarm Controller.
	 */
	public static Controller getController() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	/**
	 * Retrieves the ArrayList of the alarms that have already been set up.
	 * 
	 * @return The ArrayList of the Alarms.
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
	 * Adds an Alarm to MyAlarms.
	 * 
	 * @param alarm
	 *            The alarm to be added.
	 */
	public void addAlarm(Alarm alarm) {
		myAlarms.addAlarm(alarm);
	}

	/**
	 * Removes an Alarm from MyAlarms
	 * 
	 * @param id
	 *            The id of the alarm to be deleted
	 */
	public void deleteAlarm(int id) {
		myAlarms.deleteAlarm(id);
	}

	/**
	 * Sets an alarm time.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param time
	 *            The new time of the alarm.
	 * @throws InvalidConfigurationException
	 *             If the alarm is an alarmByDate set for today and time is a
	 *             past time.
	 */
	public void editAlarmTime(int id, AlarmTime time)
			throws InvalidConfigurationException {
		myAlarms.setAlarmTime(id, time);
	}

	/**
	 * Sets an AlarmByDate date.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param date
	 *            The new date of the alarm.
	 */
	public void editAlarmDate(int id, AlarmDate date) {
		myAlarms.setAlarmDate(id, date);
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
	public void editAlarmDays(int id, Set<Integer> days)
			throws InvalidNumberException {
		myAlarms.setAlarmDays(id, days);
	}

	/**
	 * Sets an alarm repeat option.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param repeat
	 *            The new repeat option of the alarm.
	 */
	public void editAlarmRepeat(int id, boolean repeat)
			throws InvalidNumberException {
		myAlarms.setAlarmRepeat(id, repeat);
	}

	/**
	 * Sets an alarm type.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param type
	 *            The new type of the alarm.
	 */
	public void editAlarmType(int id, AlarmType type)
			throws InvalidNumberException {
		myAlarms.setAlarmType(id, type);
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
	public void editAlarmVolume(int id, int volume)
			throws InvalidNumberException {
		myAlarms.setAlarmVolume(id, volume);
	}

	/**
	 * Sets an alarm melody.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param melody
	 *            The new melody of the alarm.
	 */
	public void editAlarmMelody(int id, String melody) {
		myAlarms.setAlarmMelody(id, melody);
	}

	/**
	 * Sets an alarm snooze option.
	 * 
	 * @param id
	 *            The alarm to be edited.
	 * @param snooze
	 *            The new snooze option of the alarm.
	 */
	public void editAlarmSnooze(int id, boolean snooze) {
		myAlarms.setAlarmSnooze(id, snooze);
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
	public void editAlarmSnoozeInterval(int id, int snoozeInterval)
			throws InvalidNumberException {
		myAlarms.setAlarmSnoozeInterval(id, snoozeInterval);
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

	/**
	 * Returns the alarm with the closest alarm time
	 * 
	 * @return the alarm with the closest alarm time
	 */
	public Alarm getNextAlarm() {
		return myAlarms.getNextAlarm();
	}

}
