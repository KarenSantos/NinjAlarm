package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import models.AlarmByDate;
import models.AlarmByWeekDay;
import models.InvalidAlarmConfiguration;
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
	public void shouldThrowExceptionIfTimeIsNotValid() {
		try {
			alarmByDate.setTime(24, 0);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The hour must be from 0 to 23", i.getMessage());
		}
		
		try {
			alarmByWeekDay.setTime(-1, 59);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The hour must be from 0 to 23", i.getMessage());
		}

		try {
			alarmByDate.setTime(23, -1);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The minute must be from 0 to 59", i.getMessage());
		}
		
		try {
			alarmByWeekDay.setTime(15, 60);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The minute must be from 0 to 59", i.getMessage());
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
	public void shouldThrowExceptionIfDateIsNotValid() {
		
		try{
			alarmByDate.setDate(2014, 7, 1);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The chosen day cannot be a past day", i.getMessage());
		}
		
		try{
			alarmByDate.setDate(2014, 6, 1);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The chosen month cannot be a past month", i.getMessage());
		}
		
		try{
			alarmByDate.setDate(2013, 7, 1);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("The chosen year cannot be a past year", i.getMessage());
		}
		
		try{
			alarmByDate.setDate(2014, 9, 31);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid day for the chosen month", i.getMessage());
		}
		
		try{
			alarmByDate.setDate(2015, 2, 29);
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
		
		alarmByWeekDay.setDays(myDays);
		
		assertEquals("[2, 4]", alarmByWeekDay.getDays().toString());
	}
	
	@Test
	public void shouldThrowExceptionIfWeekDayIsNotValid() {
		
		Set<Integer> myDays = new HashSet<Integer>();
		myDays.add(-1);
		myDays.add(4);
		
		try {
			alarmByWeekDay.setDays(myDays);
			fail("Should have thrown exception");
		} catch (InvalidNumberException i){
			assertEquals("Invalid number for a weekday", i.getMessage());
		}

		myDays.remove(-1);
		myDays.add(1);
		myDays.add(3);
		myDays.add(8);
		
		try {
			alarmByWeekDay.setDays(myDays);
			fail("Should have thrown exception");
		} catch (InvalidNumberException i){
			assertEquals("Invalid number for a weekday", i.getMessage());
		}
		
	}
	
	@Test
	public void shouldBeAbleToSetRepeatForWeekDays(){
		
		assertTrue(alarmByWeekDay.repeat());
		
		alarmByWeekDay.setRepeatOff();
		assertFalse(alarmByWeekDay.repeat());
		
		alarmByWeekDay.setRepeatOn();
		assertTrue(alarmByWeekDay.repeat());
	}
	
	@Test
	public void shouldBeAbleToChooseAlarmType() throws InvalidNumberException{
		
		alarmByDate.setType(1);
		alarmByWeekDay.setType(2);
		
		assertEquals("MELODY", alarmByDate.getType().name());
		assertEquals("MELODY_VIBRATION", alarmByWeekDay.getType().name());
		
		try{
			alarmByDate.setType(0);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid type number", i.getMessage());
		}
		
		try{
			alarmByWeekDay.setType(4);
			fail("Should have thrown exception");
		}catch (InvalidNumberException i){
			assertEquals("Invalid type number", i.getMessage());
		}
	}
	
	@Test
	public void shouldBeAbleToSetAlarmVolume() throws InvalidNumberException, InvalidAlarmConfiguration {
		
		alarmByDate.setVolume(50);
		alarmByWeekDay.setVolume(30);
		
		assertEquals(50, alarmByDate.getVolume());
		assertEquals(30, alarmByWeekDay.getVolume());
	}
	
	@Test
	public void shouldNotSetAlarmVolumeIfTypeIsVibration() throws InvalidNumberException{
		
		alarmByDate.setType(3);
		
		try {
			alarmByDate.setVolume(10);
			fail("Should have thrown exception");
		} catch (InvalidAlarmConfiguration i){
			assertEquals("Volume cannot be set to vibration type", i.getMessage());
		}
	}
	
	@Test
	public void shouldBeAbleToSetAlarmMelody(){
		
		alarmByDate.setMelody("my melody");
		alarmByWeekDay.setMelody("my other melody");
		
		assertEquals("/path/my melody", alarmByDate.getMelody());
		assertEquals("/path/my other melody", alarmByWeekDay.getMelody());
	}
	
	@Test
	public void shoulBeAbleToSetSnoozeOn(){
		
		alarmByDate.setSnoozeOn();
		alarmByWeekDay.setSnoozeOff();
		
		assertTrue(alarmByDate.getSnooze());
		assertFalse(alarmByWeekDay.getSnooze());
	}
	
	@Test
	public void shouldBeAbleToSetSnoozeInterval() throws InvalidNumberException{
		
		alarmByDate.setSnoozeInterval(20);
		alarmByWeekDay.setSnoozeInterval(5);
		
		assertEquals(20, alarmByDate.getSnoozeInterval());
		assertEquals(5, alarmByWeekDay.getSnoozeInterval());
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
		
		alarmByDate.setPowerOn();
		alarmByWeekDay.setPowerOff();
		
		assertTrue(alarmByDate.getPower());
		assertFalse(alarmByWeekDay.getPower());
	}

}
