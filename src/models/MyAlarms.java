package models;

import java.util.ArrayList;


public class MyAlarms {
	
	public MyAlarms(){}
	
	private ArrayList<Alarm> myAlarms = new ArrayList<Alarm>();
	
	public ArrayList<Alarm> getMyAlarms(){
		return myAlarms;
	}
	
	public void newAlarm(Alarm alarm) throws Exception{
		if (myAlarms.contains(alarm)){
			throw new Exception("Alarm has already been created");
		}
		myAlarms.add(alarm);
	}
	
	public void deleteAlarm(Alarm alarm) throws Exception{
		if (!myAlarms.contains(alarm)){
			throw new Exception("Alarm doesn't exist");
		}
		myAlarms.remove(alarm);
	}
	
	public void editAlarmByDate(AlarmByDate alarm, int year, int month, int day) throws Exception{
		
		for (Alarm alarm2 : myAlarms) {
			if (alarm2.equals(alarm) ){	
				if ((alarm2 instanceof AlarmByDate)){
				((AlarmByDate) alarm2).setDate(year,month,day);
			} else {
				throw new Exception("This alarm was not set by date");
			}
			}	
		}
		
	}
	public void editAlarmHour(Alarm alarm, int hour, int minute) throws Exception{
		for (Alarm alarm2 : myAlarms) {
			if (alarm2.equals(alarm) ){	
				alarm2.setTime(hour, minute);
	}
		}
	

}
}
