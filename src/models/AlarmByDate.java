package models;

public class AlarmByDate extends Alarm {
	
	private AlarmDate date;
	
	public AlarmByDate(){
		this.date = new AlarmDate();
	}
	
	public AlarmDate getDate(){
		return date;
	}
	
	public void setDate(AlarmDate date){
		this.date = date;
	}

}
