package models;

public abstract class Alarm {

	private AlarmTime time;
	
	public Alarm() {}
	
	public AlarmTime getTime() {
		return time;
	}

	public void setTime(int hour, int minute) throws InvalidNumberException {
		this.time = new AlarmTime(hour, minute);
	}

}
