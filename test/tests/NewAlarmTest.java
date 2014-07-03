package tests;

import static org.junit.Assert.*;
import models.Alarm;
import models.AlarmByDate;
import models.AlarmByWeekDay;

import org.junit.Before;
import org.junit.Test;

public class NewAlarmTest {

	Alarm alarmByDate;
	Alarm alarmByWeekDay;
	
	@Before
	public void setUp() throws Exception {
		alarmByDate = new AlarmByDate();
		alarmByWeekDay = new AlarmByWeekDay();
	}
	

	@Test
	public void shouldBeAbleToSetTime() {
		alarmByDate.setTime(20);
		alarmByWeekDay.setTime(9);
		
		assertEquals(20, alarmByDate.getTime());
		assertEquals(9, alarmByWeekDay.getTime());
		
	}

}
