package models;

public abstract class Alarm {

	private int time;
	
	public Alarm() {}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
