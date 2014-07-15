package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import models.InvalidNumberException;

import org.junit.BeforeClass;
import org.junit.Test;

public class MyAlarmsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldThrowExceptionSettingDateForTodayIfPastTime() throws InvalidNumberException{
//		alarmByDate.setDate(Calendar.getInstance().get(Calendar.YEAR), 
//				Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
//		
//		try {
//			alarmByDate.setTime(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE) -1);
//			fail("Should have thrown exception");
//		}catch (InvalidNumberException i){
//			assertEquals("Invalid time for this day", i.getMessage());
//		}
	}
	
}
