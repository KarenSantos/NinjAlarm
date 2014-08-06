package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Calendar;

import models.AlarmByDate;
import models.AlarmByWeekday;
import models.AlarmTime;
import models.InvalidConfigurationException;
import models.InvalidNumberException;
import models.MyAlarms;

import org.junit.Before;
import org.junit.Test;

public class MyAlarmsTest {

	MyAlarms myAlarms;
	
	@Before
	public void setUp() throws Exception {
		myAlarms = new MyAlarms();
	}
	
	@Test
	public void shouldBeAbleToAddAlarmToMyAlarmsList(){
		
		AlarmByDate alarm1 = new AlarmByDate();
		AlarmByWeekday alarm2 = new AlarmByWeekday();
		
		myAlarms.addAlarm(alarm1);
		myAlarms.addAlarm(alarm2);
		
		assertEquals(2, myAlarms.getAlarms().size());
		assertNotNull(myAlarms.getAlarmById(1));
		assertNotNull(myAlarms.getAlarmById(2));
	}
	
	
	
	@Test
	public void shouldBeAbleToDeleteAlarmFromMyAlarmsList(){
		AlarmByDate alarm1 = new AlarmByDate();
		AlarmByWeekday alarm2 = new AlarmByWeekday();
		
		myAlarms.addAlarm(alarm1);
		myAlarms.addAlarm(alarm2);
		
		assertEquals(2, myAlarms.getAlarms().size());
		
		myAlarms.deleteAlarm(1);
		
		assertEquals(1, myAlarms.getAlarms().size());
		assertNull(myAlarms.getAlarmById(1));
	}
	
	@Test
	public void shouldThrowExceptionSettingPastTimeForToday() throws InvalidNumberException {	

		AlarmByDate alarm = new AlarmByDate();
		myAlarms.addAlarm(alarm);
		
		try {
			AlarmTime time = new AlarmTime(Calendar.getInstance().get(Calendar.HOUR) - 1, 0);
			myAlarms.setAlarmTime(1, time);
			fail("Should have thrown exception");
		} catch (InvalidConfigurationException e){
			assertEquals("Invalid time for today.", e.getMessage());
		}
	}
}
