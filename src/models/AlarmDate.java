package models;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Alarm date class.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class AlarmDate {

	private final int FIRST_DAY = 1;
	private final int FIRST_MONTH = 1;
	private final int LAST_MONTH = 12;

	private int year;
	private int month;
	private int day;

	/**
	 * Creates a new alarm date with the current date.
	 */
	public AlarmDate() {
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		this.day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Creates a new alarm date with a year, month and a day.
	 * 
	 * @param year
	 *            The year for the date.
	 * @param month
	 *            The month for the date.
	 * @param day
	 *            The day for the date.
	 * @throws InvalidNumberException
	 *             If the date is a past date, or an invalid date.
	 */
	public AlarmDate(int year, int month, int day)
			throws InvalidNumberException {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	/**
	 * Returns the year of the date.
	 * 
	 * @return The year of the date.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year of the date.
	 * 
	 * @param year
	 *            The new year of the date.
	 * @throws InvalidNumberException
	 *             If is a past year.
	 */
	public void setYear(int year) throws InvalidNumberException {
		if (year < Calendar.getInstance().get(Calendar.YEAR)) {
			throw new InvalidNumberException(
					"The chosen year cannot be a past year");
		}
		this.year = year;
	}

	/**
	 * Returns the month of the date.
	 * 
	 * @return The month of the date.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Sets the month of the date.
	 * 
	 * @param month
	 *            The new month of the date.
	 * @throws InvalidNumberException
	 *             If the month is less than 1 or more than 12, if is a past
	 *             month.
	 */
	public void setMonth(int month) throws InvalidNumberException {

		if (month < FIRST_MONTH || month > LAST_MONTH) {
			throw new InvalidNumberException("Invalid month");
		}

		if (this.year == Calendar.getInstance().get(Calendar.YEAR)) {
			if (month < Calendar.getInstance().get(Calendar.MONTH) + 1) {
				throw new InvalidNumberException(
						"The chosen month cannot be a past month");
			}
		}
		this.month = month;
	}

	/**
	 * Returns the day of the date.
	 * 
	 * @return The day of the date.
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Sets the day of the date.
	 * 
	 * @param day
	 *            The new day of the date.
	 * @throws InvalidNumberException
	 *             If is a past day or if the day is not valid for the date
	 *             month and year.
	 */
	public void setDay(int day) throws InvalidNumberException {

		int y = this.year;
		int m = this.month - 1;
		int d = FIRST_DAY;

		Calendar cal = new GregorianCalendar(y, m, d);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		if (day < FIRST_DAY || day > daysInMonth) {
			throw new InvalidNumberException("Invalid day for the chosen month");
		}

		if (this.year == Calendar.getInstance().get(Calendar.YEAR)) {
			if (month == Calendar.getInstance().get(Calendar.MONTH) + 1) {
				if (day < Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
					throw new InvalidNumberException(
							"The chosen day cannot be a past day");
				}
			}
		}

		this.day = day;
	}
}
