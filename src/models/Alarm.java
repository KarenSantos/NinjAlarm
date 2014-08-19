package com.ufcg.es.ninjalarm.models;

/**
 * Alarm class
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public abstract class Alarm implements Comparable<Alarm> {

	public static final int MAX_VOLUME = 100;

	private final AlarmType DEFAULT_TYPE = AlarmType.MELODY;
	private final int MIN_VOLUME = 0;
	private final int DEFAULT_VOLUME = 50;
	private final String MELODY_PATH = "/path/";
	private final String DEFAULT_MELODY = "";
	private final boolean DEFAULT_SNOOZE = false;
	private final int MIN_SNOOZE_INTERVAL = 1;
	private final int MAX_SNOOZE_INTERVAL = 60;
	private final int DEFAULT_SNOOZE_INTERVAL = 10;
	private final boolean DEFAULT_POWER = true;

	private int id;
	private AlarmTime time;
	private AlarmType type;
	private int volume;
	private String melody;
	private StopButton stopButton;
	private boolean snooze;
	private int snoozeInterval;
	private AlarmTime snoozeTime;
	private String name;
	private boolean power;

	/**
	 * Creates an alarm with the default configuration for time, type, volume,
	 * melody, snooze and snooze interval.
	 */
	public Alarm() {
		setDefaultConfig();
	}

	/**
	 * Returns the alarm id
	 * 
	 * @return the alarm id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the alarm id
	 * 
	 * @param id
	 *            the new alarm id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the alarm time.
	 * 
	 * @return The alarm time.
	 */
	public AlarmTime getTime() {
		return time;
	}

	/**
	 * Sets the alarm time.
	 * 
	 * @param time
	 *            The new time for the alarm to go off.
	 */
	public void setTime(AlarmTime time) {
		this.time = time;
		this.snoozeTime = this.time;
	}

	/**
	 * Returns the alarm type.
	 * 
	 * @return The alarm type.
	 */
	public AlarmType getType() {
		return this.type;
	}

	/**
	 * Sets the alarm type from 1 to 3.
	 * 
	 * @param typeNum
	 *            The new number for the alarm type.
	 */
	public void setType(AlarmType type) {
		this.type = type;
	}

	/**
	 * Returns the alarm volume.
	 * 
	 * @return The alarm volume.
	 */
	public int getVolume() {
		return this.volume;
	}

	/**
	 * Sets the alarm volume from 1 to 100.
	 * 
	 * @param volume
	 *            The new volume for the alarm.
	 * @throws InvalidNumberException
	 *             If the number for the volume is less than 0 or more than 100.
	 */
	public void setVolume(int volume) throws InvalidNumberException {

		if (volume < MIN_VOLUME || volume > MAX_VOLUME) {
			throw new InvalidNumberException("Invalid volume number");
		}

		if (volume == MIN_VOLUME) {
			this.type = AlarmType.VIBRATION;
		}
		this.volume = volume;
	}

	/**
	 * Returns the path for the alarm melody.
	 * 
	 * @return The path for the alarm melody.
	 */
	public String getMelody() {
		return this.melody;
	}

	/**
	 * Sets the alarm melody.
	 * 
	 * @param melody
	 *            The name of the new alarm melody.
	 */
	public void setMelody(String melody) {
		this.melody = MELODY_PATH + melody;
	}

	/**
	 * Returns the stop button of the alarm.
	 * 
	 * @return The stop button of the alarm.
	 */
	public StopButton getStopButton() {
		return this.stopButton;
	}

	/**
	 * Sets the stop button of the alarm.
	 * 
	 * @param stopButton
	 *            The new stop button of the alarm.
	 */
	public void setStopButton(StopButton stopButton) {
		this.stopButton = stopButton;
	}

	/**
	 * Returns the indication if the snooze is on.
	 * 
	 * @return The indication if the snooze is on.
	 */
	public boolean getSnooze() {
		return this.snooze;
	}

	/**
	 * Sets the snooze of the alarm.
	 */
	public void setSnooze(boolean snooze) {
		this.snooze = snooze;
	}

	/**
	 * Returns the snooze time interval.
	 * 
	 * @return The snooze time interval.
	 */
	public int getSnoozeInterval() {
		return this.snoozeInterval;
	}

	/**
	 * Sets the snooze time interval from 1 to 60.
	 * 
	 * @param interval
	 *            The new snooze time interval.
	 * @throws InvalidNumberException
	 *             If the snooze time interval is less than 1 or more than 60.
	 */
	public void setSnoozeInterval(int interval) throws InvalidNumberException {
		if (interval < MIN_SNOOZE_INTERVAL || interval > MAX_SNOOZE_INTERVAL) {
			throw new InvalidNumberException("Invalid snooze interval");
		}
		this.snoozeInterval = interval;
	}

	/**
	 * Returns the snooze time.
	 * 
	 * @return The snooze time.
	 */
	public AlarmTime getSnoozeTime() {
		return this.snoozeTime;
	}

	/**
	 * Adds the snooze interval time to the snooze time;
	 */
	public void activateSnooze() {
		if (this.snooze) {
			this.snoozeTime.addTime(snoozeInterval);
		}
	}

	/**
	 * Dismisses the alarm and resets the snooze time.
	 */
	public void dismissAlarm() {
		this.snoozeTime = getTime();
	}

	/**
	 * Returns the name of the alarm.
	 * 
	 * @return The name of the alarm.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the alarm.
	 * 
	 * @param name
	 *            The new name of the alarm.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns if the alarm is on.
	 * 
	 * @return True if the alarm is on and False if not.
	 */
	public boolean getPower() {
		return this.power;
	}

	/**
	 * Sets the alarm power on of off.
	 * 
	 * @param power
	 *            The new alarm power option.
	 * 
	 */
	public void setPower(boolean power) {
		this.power = power;
	}

	/**
	 * Sets a default alarm configuration.
	 */
	public void setDefaultConfig() {
		this.time = new AlarmTime();
		this.snoozeTime = this.time;
		setType(DEFAULT_TYPE);
		try {
			setVolume(DEFAULT_VOLUME);
		} catch (InvalidNumberException e) {
			e.printStackTrace();
		}
		this.melody = DEFAULT_MELODY;
		this.snooze = DEFAULT_SNOOZE;
		this.snoozeInterval = DEFAULT_SNOOZE_INTERVAL;
		this.power = DEFAULT_POWER;
	}

	/**
	 * Returns if the alarm is set for today.
	 * 
	 * @return True if the alarm date is today of False otherwise.
	 */
	abstract boolean isForToday();

	/**
	 * Compares two alarms by time
	 */
	@Override
	public int compareTo(Alarm a) {
		return this.getTime().changeToMinutes() - a.getTime().changeToMinutes();
	}

}
