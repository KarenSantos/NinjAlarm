package models;

/**
 * Alarm class
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public abstract class Alarm {

	private final int DEFAULT_TYPE = 1;
	private final int MIN_VOLUME = 0;
	private final int DEFAULT_VOLUME = 50;
	private final int MAX_VOLUME = 100;
	private final String MELODY_PATH = "/path/";
	private final String DEFAULT_MELODY = "";
	private final boolean DEFAULT_SNOOZE = false;
	private final int MIN_SNOOZE_INTERVAL = 1;
	private final int MAX_SNOOZE_INTERVAL = 60;
	private final int DEFAULT_SNOOZE_INTERVAL = 10;

	private int id;
	private AlarmTime time;
	private AlarmType type;
	private int volume;
	private String melody;
	private boolean snooze;
	private int snoozeInterval;
	private boolean power;

	/**
	 * Creates an alarm with the default configuration for time, type, volume,
	 * melody, snooze and snooze interval.
	 */
	public Alarm() {
		setDefaultConfig();
	}

	/**
	 * Creates an alarm with a time, type, volume, melody, snooze and snooze
	 * interval.
	 * 
	 * @param id
	 *            The id of the alarm
	 * 
	 * @param time
	 *            The time when the alarm will go off.
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
	 */
	public Alarm(int id, AlarmTime time, int AlarmType, int volume,
			String melody, boolean snooze, int snoozeInterval)
			throws InvalidNumberException {
		this.id = id;
		setDefaultConfig();
		if (time != null) {
			this.time = time;
		}
		setType(AlarmType);
		setVolume(volume);
		if (melody != null) {
			this.melody = melody;
		}
		this.snooze = snooze;
		setSnoozeInterval(snoozeInterval);
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
	 * @throws InvalidNumberException
	 *             If hour is less than 0 or more than 23, or if minute is less
	 *             than 0 or more than 59.
	 */
	public void setTime(AlarmTime time) throws InvalidNumberException {
		this.time = time;
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
	 * @throws InvalidNumberException
	 *             If the number is less than 1 or more than 3.
	 */
	public void setType(int typeNum) throws InvalidNumberException {
		if (typeNum < AlarmType.MELODY.getValue()
				|| typeNum > AlarmType.VIBRATION.getValue()) {
			throw new InvalidNumberException("Invalid type number");
		}

		if (typeNum == AlarmType.MELODY.getValue()) {
			this.type = AlarmType.MELODY;
		} else if (typeNum == AlarmType.MELODY_VIBRATION.getValue()) {
			this.type = AlarmType.MELODY_VIBRATION;
		} else {
			this.type = AlarmType.VIBRATION;
			this.volume = MIN_VOLUME;
		}
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
	 * Returns the indication if the alarm is on.
	 * 
	 * @return The indication if the alarm is on.
	 */
	public boolean getPower() {
		return this.power;
	}

	/**
	 * Sets the alarm on.
	 */
	public void setPowerOn() {
		this.power = true;
	}

	/**
	 * Sets the alarm off.
	 */
	public void setPowerOff() {
		this.power = false;
	}

	/**
	 * Sets a default alarm configuration.
	 */
	public void setDefaultConfig() {
		this.time = new AlarmTime();
		try {
			setType(DEFAULT_TYPE);
		} catch (InvalidNumberException e) {
			e.printStackTrace();
		}
		try {
			setVolume(DEFAULT_VOLUME);
		} catch (InvalidNumberException e) {
			e.printStackTrace();
		}
		this.melody = DEFAULT_MELODY;
		this.snooze = DEFAULT_SNOOZE;
		this.snoozeInterval = DEFAULT_SNOOZE_INTERVAL;
	}

}
