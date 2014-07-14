package models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AlarmDate {
	
	private final int FIRST_DAY = 1;
	private final int FIRST_MONTH = 1;
	private final int LAST_MONTH = 12;
	
	private int year;
	private int month;
	private int day;
	
	public AlarmDate(){
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		this.day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}
	
	public AlarmDate(int year, int month, int day) throws InvalidNumberException{
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year) throws InvalidNumberException{
		if (year < Calendar.getInstance().get(Calendar.YEAR)){
			throw new InvalidNumberException("The chosen year cannot be a past year");
		}
		this.year = year;
	}
	
	public int getMonth(){
		return month;
	}
	
	public void setMonth(int month) throws InvalidNumberException{
		
		if (month < FIRST_MONTH || month > LAST_MONTH){
			throw new InvalidNumberException("Invalid month");
		}
		
		if (this.year == Calendar.getInstance().get(Calendar.YEAR)){
			if (month < Calendar.getInstance().get(Calendar.MONTH)+1){
				throw new InvalidNumberException("The chosen month cannot be a past month");
			}
		}
		this.month = month;
	}
	
	public int getDay(){
		return day;
	}
	
	public void setDay(int day) throws InvalidNumberException {
		
		int y = this.year;
		int m = this.month - 1;
		int d = FIRST_DAY;
		
		Calendar cal = new GregorianCalendar(y, m, d);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		if (day < FIRST_DAY || day > daysInMonth){
			throw new InvalidNumberException("Invalid day for the chosen month");
		}

		if (this.year == Calendar.getInstance().get(Calendar.YEAR)){
			if (month == Calendar.getInstance().get(Calendar.MONTH)+1){
				if (day < Calendar.getInstance().get(Calendar.DAY_OF_MONTH)){
					throw new InvalidNumberException("The chosen day cannot be a past day");
				}
			}
		}
		
		this.day = day;
	}
}
