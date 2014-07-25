package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
	
	/**
	 * My alarms manager class
	 * @author Ana, Felipe, Karen, Marcos and Maysa
	 *
	 */

public class MyAlarms {
	
	
	private ArrayList<Alarm> myAlarms = new ArrayList<Alarm>();
	/**
	 * Retrieves the ArrayList of the alarms that have already been set up
	 * @return The ArrayList of the Alarms
	 */
	public ArrayList<Alarm> getMyAlarms(){
		return myAlarms;
	}
	/**
	 * Adds an Alarm to the MyAlarms List.
	 * @param alarm 
	 * @throws Exception If the the ArrayList(MyAlarms) already contains the Alarm.
	 */
	
	public void newAlarm(Alarm alarm) throws Exception{
		if (myAlarms.contains(alarm)){
			throw new Exception("Alarm has already been created");
		}
		myAlarms.add(alarm);
	}
	/**
	 * Removes an Alarm from MyAlarms List
	 * @param alarm
	 * @throws Exception If the Alarm is not in the MyAlars List
	 */
	
	public void deleteAlarm(Alarm alarm) throws Exception{
		if (!myAlarms.contains(alarm)){
			throw new Exception("Alarm doesn't exist");
		}
		myAlarms.remove(alarm);
	}
	/**
	 * Edits the date of an AlarmByDate 
	 * @param alarm
	 * The Alarm chosen
	 * @param year
	 * The year of the new date
	 * @param month
	 * The month of the new date
	 * @param day
	 * The day of the new date
	 * @throws Exception If the Alarm was not set by date or if the new date of the alarm has already passed..
	 */
	
	public void editAlarmByDate(AlarmByDate alarm, int year, int month, int day) throws Exception{
		if(year<Calendar.getInstance().get(Calendar.YEAR) || month<Calendar.getInstance().get(Calendar.MONTH) || day<Calendar.getInstance().get(Calendar.DAY_OF_MONTH)){
			throw new Exception ("This date has already passed");
		}
		
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
	/**
	 * Edit the hour of an Alarm
	 * @param alarm
	 * The Alarm which will be edited
	 * @param hour
	 * The new hour of the Alarm
	 * @param minute
	 * The new minute of the Alarm
	 * @throws Exception  If the hour or the minute of the day set has already passed.
	 */
	public void editAlarmHour(Alarm alarm, int hour, int minute) throws Exception{
		if (minute<Calendar.getInstance().get(Calendar.MINUTE) || hour<Calendar.getInstance().get(Calendar.HOUR)){
			throw new Exception ("Past time");
		}
		
		for (Alarm alarm2 : myAlarms) {
			if (alarm2.equals(alarm) ){	
				alarm2.setTime(hour, minute);
	}
		}
}
	/**
	 * Edits the working days of an AlarmByWeekDay
	 * @param alarm
	 * The alarm which will be edited
	 * @param days
	 * The new days of the Alarm
	 * @throws Exception If any of the weekdays are not valid or if the set is null.
	 */
	public void editAlarmByWeekDay(AlarmByWeekDay alarm, Set<Integer> days) throws Exception{
		
		for (Alarm alarm2 : myAlarms) {
			if(alarm2 instanceof AlarmByWeekDay){
				((AlarmByWeekDay) alarm2).setDays(days);
			} else {
				throw new Exception("This alarm was not set by week day!");
			}
			
		}
	}
	

}


