package models;

import java.util.HashSet;
import java.util.Set;

public class AlarmByWeekDay extends Alarm {

	private Set<Integer> days;
	private boolean repeat;
	
	public AlarmByWeekDay(){
		this.days = new HashSet<Integer>();
		days.add(1);
		days.add(2);
		days.add(3);
		days.add(4);
		days.add(5);
		days.add(6);
		days.add(7);
		
		this.repeat = true;
	}
	
	public Set<Integer> getDays() {
		return days;
	}

	public void setDays(Set<Integer> days) throws InvalidNumberException {
		
		for (Integer i : days){
			if (i < 0 || i > 7){
				throw new InvalidNumberException("Invalid number for a weekday");
			}
		}
		
		this.days.clear();
		this.days.addAll(days);
	}
	
	public void setRepeatOn(){
		this.repeat = true;
	}
	
	public void setRepeatOff(){
		this.repeat = false;
	}
	
	public boolean repeat(){
		return this.repeat;
	}
	
}
