package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import models.AlarmByDate;
import models.AlarmByWeekDay;
import models.AlarmDate;
import models.InvalidNumberException;

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
	public void shouldBeAbleToSetTime() throws InvalidNumberException {
		alarmByDate.setTime(20, 15);
		alarmByWeekDay.setTime(4, 30);
		
		assertEquals(20, alarmByDate.getTime().getHour());
		assertEquals(15, alarmByDate.getTime().getMinute());
		assertEquals(4, alarmByWeekDay.getTime().getHour());
		assertEquals(30, alarmByWeekDay.getTime().getMinute());
	}

	@Test
	public void shouldNotSetInvalidTime() {
		try {
			alarmByDate.setTime(24, 0);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid hour", i.getMessage());
		}
		
		try {
			alarmByWeekDay.setTime(-1, 59);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid hour", i.getMessage());
		}

		try {
			alarmByDate.setTime(23, -1);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid minute", i.getMessage());
		}
		
		try {
			alarmByWeekDay.setTime(15, 60);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid minute", i.getMessage());
		}
	}
	
	@Test
	public void shouldBeAbleToChooseByDate() throws InvalidNumberException {
		alarmByDate.setDate(2014, 7, 19);
		
		assertEquals(2014, alarmByDate.getDate().getYear());
		assertEquals(7, alarmByDate.getDate().getMonth());
		assertEquals(19, alarmByDate.getDate().getDay());
	}
	
	@Test
	public void shouldThrowExceptionSettingPastTimeIfDateIsToday() throws InvalidNumberException{
		alarmByDate.setDate(Calendar.getInstance().get(Calendar.YEAR), 
				Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		
		try {
			alarmByDate.setTime(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE) -1);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid time for this day", i.getMessage());
		}
	}

	@Test
	public void shouldThrowExceptionIfDateIsNotValid() {
		
	}
}
