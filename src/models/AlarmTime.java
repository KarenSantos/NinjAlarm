package models;

import java.util.Calendar;

public class AlarmTime {
	
	private final int MAX_HOUR = 23;
	private final int MAX_MIN = 59;
	private int hour;
	private int minute;
	
	public AlarmTime(){
		this.hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		this.minute = Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	public AlarmTime(int hour, int minute) throws InvalidNumberException {
		
		setHour(hour);
		setMinute(minute);
	}
	
	public int getHour(){
		return this.hour;
	}
	
	public void setHour(int hour) throws InvalidNumberException{
		if (hour < 0 || hour > MAX_HOUR){
			throw new InvalidNumberException("Invalid hour");
		}
		this.hour = hour;
	}
	
	public int getMinute(){
		return this.minute;
	}
	
	public void setMinute(int minute) throws InvalidNumberException{
		if (minute < 0 || minute > MAX_MIN) {
			throw new InvalidNumberException("Invalid minute");
		}
		this.minute = minute;
	}
}
