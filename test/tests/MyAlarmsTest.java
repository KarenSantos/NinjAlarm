package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import models.AlarmByDate;
import models.AlarmByWeekDay;
import models.AlarmDate;
import models.AlarmTime;
import models.InvalidNumberException;
import models.MyAlarms;
import models.Alarm;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyAlarmsTest {

	MyAlarms alarms;
	AlarmByDate alarm;
	ArrayList<Alarm> expected;
	
	@Before
	public void setUp() throws Exception {
		alarms = new MyAlarms();
		AlarmTime time = new AlarmTime(2, 35);
		AlarmDate date = new AlarmDate(2014, 8, 26);
		alarm = new AlarmByDate(time, date,1,2,"oi",true,3);
		expected = new ArrayList<Alarm>();
		
	}

	

	
	@Test
	public void AlarmShouldBeAddedToMyAlarmsList(){
		try{
			alarms.newAlarm(alarm);
			assertTrue(alarms.getMyAlarms().contains(alarm));
		} catch (Exception e){
			fail("Shouldn't have thrown exception");
		}
		
	}
	
	
	
	@Test
	public void alarmShouldBeRemovedFromMyAlarmsList(){
		try{
			alarms.newAlarm(alarm);
			alarms.deleteAlarm(alarm);
			assertFalse(alarms.getMyAlarms().contains(alarm));
		} catch (Exception e){
			fail("Shouldn't have thrown exception");
		}
		
	}

	@Test
	public void shouldThrowExceptionSettingDateForTodayIfPastTime() throws Exception{	
		try {
			alarms.editAlarmHour(alarm,Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE) -1);
			fail("Should have thrown exception");
		}catch (Exception i){
			assertEquals("Past time", i.getMessage());
		}
	}
	
	@Test
	public void shouldThrowExceptionSettingAlarmIfPastDate(){
		try{
			alarms.editAlarmByDate(alarm,Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) -1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		} catch (Exception e){
			assertEquals("This date has already passed", e.getMessage());
		}
		
	}
}
