package models;

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

	private AlarmTime time;
	private AlarmType type;
	private int volume;
	private String melody;
	private boolean snooze;
	private int snoozeInterval;
	private boolean power;
	
	public Alarm(){
		setDefaultConfig();
	}
	
	public Alarm(AlarmTime time, AlarmType type, int volume, String melody,
			boolean snooze, int snoozeInterval) throws InvalidNumberException, InvalidAlarmConfiguration {
		this.time = time;
		this.type = type;
		setVolume(volume);
		this.melody = melody;
		this.snooze = snooze;
		setSnoozeInterval(snoozeInterval);
	}
	
	public AlarmTime getTime() {
		return time;
	}

	public void setTime(int hour, int minute) throws InvalidNumberException {
		this.time = new AlarmTime(hour, minute);
	}

	public AlarmType getType(){
		return this.type;
	}
	
	public void setType(int typeNum) throws InvalidNumberException {
		if (typeNum < AlarmType.MELODY.getValue() || typeNum > AlarmType.VIBRATION.getValue()){
			throw new InvalidNumberException("Invalid type number");
		}
		
		if (typeNum == AlarmType.MELODY.getValue()){
			this.type = AlarmType.MELODY;
		}
		else if (typeNum == AlarmType.MELODY_VIBRATION.getValue()){
			this.type = AlarmType.MELODY_VIBRATION;
		} else {
			this.type = AlarmType.VIBRATION;
			this.volume = MIN_VOLUME;
		}
	}
	
	public int getVolume(){
		return this.volume;
	}
	
	public void setVolume(int volume) throws InvalidNumberException, InvalidAlarmConfiguration{
		
		if (this.type == AlarmType.VIBRATION){
			throw new InvalidAlarmConfiguration("Volume cannot be set to vibration type");
		}
		
		if (volume < MIN_VOLUME || volume > MAX_VOLUME){
			throw new InvalidNumberException("Invalid volume number");
		}
		
		if (volume == MIN_VOLUME){
			this.type = AlarmType.VIBRATION;
		}
		this.volume = volume;
	}
	
	public String getMelody(){
		return this.melody;
	}
	
	public void setMelody(String melody){
		this.melody = MELODY_PATH + melody;
	}
	
	public boolean getSnooze(){
		return this.snooze;
	}
	
	public void setSnoozeOn(){
		this.snooze = true;
	}
	
	public void setSnoozeOff(){
		this.snooze = false;
	}
	
	public int getSnoozeInterval(){
		return this.snoozeInterval;
	}
	
	public void setSnoozeInterval(int interval)throws InvalidNumberException{
		if (interval < MIN_SNOOZE_INTERVAL || interval > MAX_SNOOZE_INTERVAL){
			throw new InvalidNumberException("Invalid snooze interval");
		}
		this.snoozeInterval = interval;
	}
	
	public boolean getPower(){
		return this.power;
	}
	
	public void setPowerOn(){
		this.power = true;
	}
	
	public void setPowerOff(){
		this.power = false;
	}
	
	public void setDefaultConfig() {
		this.time = new AlarmTime();
		try {
			setType(DEFAULT_TYPE);
		} catch (InvalidNumberException e) {
			e.printStackTrace();
		}
		try {
			setVolume(DEFAULT_VOLUME);
		} catch (InvalidNumberException | InvalidAlarmConfiguration e) {
			e.printStackTrace();
		}
		this.melody = DEFAULT_MELODY;
		this.snooze = DEFAULT_SNOOZE;
		this.snoozeInterval = DEFAULT_SNOOZE_INTERVAL;
	}
	
}
