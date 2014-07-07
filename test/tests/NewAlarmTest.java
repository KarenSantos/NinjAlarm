package tests;

import static org.junit.Assert.*;
import models.AlarmByDate;
import models.AlarmByWeekDay;
import models.AlarmDate;
import models.InvalidDateException;

import org.junit.Before;
import org.junit.Test;

public class NewAlarmTest {

	AlarmByDate alarmByDate;
	AlarmByWeekDay alarmByWeekDay;
	
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
	
	@Test
	public void shouldBeAbleToChooseTheDate() throws InvalidDateException {
		alarmByDate.setDate(new AlarmDate(2014, 7, 19));
		
		assertEquals(2014, alarmByDate.getDate().getYear());
		assertEquals(7, alarmByDate.getDate().getMonth());
		assertEquals(19, alarmByDate.getDate().getDay());
	}
	
	@Test
	public void shouldThrowExceptionSettingPastTimeIfDateIsToday(){
		
	}

	@Test
	public void shouldThrowExceptionIfDateIsNotValid() {
		
	}
	

}
