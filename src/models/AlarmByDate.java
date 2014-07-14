package models;

public class AlarmByDate extends Alarm {
	
	private AlarmDate date;
	
	public AlarmByDate(){
		this.date = new AlarmDate();
	}
	
	public AlarmDate getDate(){
		return date;
	}
	
	public void setDate(int year, int month, int day)throws InvalidNumberException{
		this.date = new AlarmDate(year, month, day);
	}
}
