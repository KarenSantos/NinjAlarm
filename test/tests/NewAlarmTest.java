package tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import models.AlarmByDate;
import models.AlarmByWeekday;
import models.AlarmDate;
import models.AlarmTime;
import models.AlarmType;
import models.InvalidNumberException;

import org.junit.Before;
import org.junit.Test;

public class NewAlarmTest {

	AlarmByDate alarmByDate;
	AlarmByWeekday alarmByWeekday;
	
	@Before
	public void setUp() throws Exception {
		alarmByDate = new AlarmByDate();
		alarmByWeekday = new AlarmByWeekday();
	}
	

	@Test
	public void shouldBeAbleToSetTime() throws InvalidNumberException {
		AlarmTime time1 = new AlarmTime(20, 15);
		AlarmTime time2 = new AlarmTime(4, 30);
		
		alarmByDate.setTime(time1);
		alarmByWeekday.setTime(time2);
		
		assertEquals(20, alarmByDate.getTime().getHour());
		assertEquals(15, alarmByDate.getTime().getMinute());
		assertEquals(4, alarmByWeekday.getTime().getHour());
		assertEquals(30, alarmByWeekday.getTime().getMinute());
	}

	@Test
	public void shouldThrowExceptionIfTimeIsNotValid() {
		AlarmTime time;
		try {
			time = new AlarmTime(24, 0);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The hour must be from 0 to 23", i.getMessage());
		}
		
		try {
			time = new AlarmTime(-1, 59);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The hour must be from 0 to 23", i.getMessage());
		}

		try {
			time = new AlarmTime(23, -1);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The minute must be from 0 to 59", i.getMessage());
		}
		
		try {
			time = new AlarmTime(15, 60);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The minute must be from 0 to 59", i.getMessage());
		}
	}
	
	@Test
	public void shouldBeAbleToChooseByDate() throws InvalidNumberException {
		
		int nextYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
		AlarmDate date = new AlarmDate(nextYear, 7, 19);
		
		alarmByDate.setDate(date);
		
		assertEquals(nextYear, alarmByDate.getDate().getYear());
		assertEquals(7, alarmByDate.getDate().getMonth());
		assertEquals(19, alarmByDate.getDate().getDay());
	}
	
	@Test
	public void shouldThrowExceptionIfDateIsPastDate() {
		AlarmDate date;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		try{
			date = new AlarmDate(currentYear, currentMonth, currentDay - 1);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The chosen day cannot be a past day", i.getMessage());
		}
		
		try{
			date = new AlarmDate(currentYear, currentMonth - 1, currentDay);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The chosen month cannot be a past month", i.getMessage());
		}
		
		try{
			date = new AlarmDate(currentYear - 1, currentMonth, currentDay);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The chosen year cannot be a past year", i.getMessage());
		}
	}
	
	@Test
	public void shouldThrowExceptionIfDateIsNotAValidDate() {
		AlarmDate date;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		try{
			date = new AlarmDate(currentYear, 9, 31);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid day for the chosen month", i.getMessage());
		}
		
		try{
			//not a leap year
			date = new AlarmDate(2401, 2, 29);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid day for the chosen month", i.getMessage());
		}
	}
	
	
	@Test
	public void shouldBeAbleToChooseByWeekDays() throws InvalidNumberException {

		Set<Integer> myDays = new HashSet<Integer>();
		myDays.add(2);
		myDays.add(4);
		
		alarmByWeekday.setDays(myDays);
		
		assertEquals("[2, 4]", alarmByWeekday.getDays().toString());
	}
	
	@Test
	public void shouldThrowExceptionIfWeekDayIsNotValid() {
		
		Set<Integer> myDays = new HashSet<Integer>();
		myDays.add(-1);
		myDays.add(4);
		
		try {
			alarmByWeekday.setDays(myDays);
			fail("Should have thrown exception");
		} catch (InvalidNumberException i){
			assertEquals("Invalid number for a weekday", i.getMessage());
		}

		myDays.remove(-1);
		myDays.add(1);
		myDays.add(3);
		myDays.add(8);
		
		try {
			alarmByWeekday.setDays(myDays);
			fail("Should have thrown exception");
		} catch (InvalidNumberException i){
			assertEquals("Invalid number for a weekday", i.getMessage());
		}
		
	}
	
	@Test
	public void shouldBeAbleToSetRepeatForWeekdays(){
		
		assertTrue(alarmByWeekday.getRepeat());
		
		alarmByWeekday.setRepeat(false);
		assertFalse(alarmByWeekday.getRepeat());
		
		alarmByWeekday.setRepeat(true);
		assertTrue(alarmByWeekday.getRepeat());
	}
	
	@Test
	public void shouldBeAbleToChooseAlarmType() throws InvalidNumberException{
		
		alarmByDate.setType(AlarmType.MELODY);
		alarmByWeekday.setType(AlarmType.MELODY_VIBRATION);
		
		assertEquals("MELODY", alarmByDate.getType().name());
		assertEquals("MELODY_VIBRATION", alarmByWeekday.getType().name());
	}
	
	@Test
	public void shouldBeAbleToSetAlarmVolume() throws InvalidNumberException {
		
		alarmByDate.setVolume(50);
		alarmByWeekday.setVolume(30);
		
		assertEquals(50, alarmByDate.getVolume());
		assertEquals(30, alarmByWeekday.getVolume());
		
		try{
			alarmByDate.setVolume(-5);
			fail("should have thrown exception");
		} catch (InvalidNumberException e){
			assertEquals("Invalid volume number", e.getMessage());
		}
		
		try{
			alarmByWeekday.setVolume(101);
			fail("should have thrown exception");
		} catch (InvalidNumberException e){
			assertEquals("Invalid volume number", e.getMessage());
		}
	}
	
	@Test
	public void shouldBeAbleToSetAlarmMelody(){
		
		alarmByDate.setMelody("my melody");
		alarmByWeekday.setMelody("my other melody");
		
		assertEquals("/path/my melody", alarmByDate.getMelody());
		assertEquals("/path/my other melody", alarmByWeekday.getMelody());
	}
	
	@Test
	public void shoulBeAbleToSetSnoozeOn(){
		
		assertFalse(alarmByWeekday.getSnooze());
		assertFalse(alarmByDate.getSnooze());
		
		alarmByDate.setSnooze(true);
		alarmByWeekday.setSnooze(true);
		
		assertTrue(alarmByDate.getSnooze());
		assertTrue(alarmByWeekday.getSnooze());
	}
	
	@Test
	public void shouldBeAbleToSetSnoozeInterval() throws InvalidNumberException{
		
		alarmByDate.setSnoozeInterval(20);
		alarmByWeekday.setSnoozeInterval(5);
		
		assertEquals(20, alarmByDate.getSnoozeInterval());
		assertEquals(5, alarmByWeekday.getSnoozeInterval());
		
	}
	
	@Test
	public void shouldThrowExceptionIfInvalidSnoozeInterval(){
		
		try {
			alarmByDate.setSnoozeInterval(0);
			fail("Should have thrown exception");
		} catch (InvalidNumberException i){
			assertEquals("Invalid snooze interval", i.getMessage());
		}
		
		try {
			alarmByDate.setSnoozeInterval(61);
			fail("Should have thrown exception");
		} catch (InvalidNumberException i){
			assertEquals("Invalid snooze interval", i.getMessage());
		}
	}
	
	@Test
	public void shouldBeAbleToSetAlarmOnAndOff(){
		
		assertTrue(alarmByDate.getPower());
		assertTrue(alarmByWeekday.getPower());
		
		alarmByDate.setPower(false);
		alarmByWeekday.setPower(false);
		
		assertFalse(alarmByDate.getPower());
		assertFalse(alarmByWeekday.getPower());
	}

}
