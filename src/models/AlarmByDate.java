package models;

public class AlarmByDate extends Alarm {
	
	private AlarmDate date;
	
	public AlarmByDate(){
		super();
		this.date = new AlarmDate();
	}
	
	public AlarmByDate(AlarmTime time, AlarmDate date, AlarmType type,
			int volume, String melody, boolean snooze, int snoozeInterval)
			throws InvalidNumberException, InvalidAlarmConfiguration{
		super(time, type, volume, melody, snooze, snoozeInterval);
		this.date = date;
	}
	
	public AlarmDate getDate(){
		return date;
	}
	
	public void setDate(int year, int month, int day)throws InvalidNumberException{
		this.date = new AlarmDate(year, month, day);
	}
}
