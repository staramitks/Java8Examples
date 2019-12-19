package home.amit.java8.examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class ThirdThursdayOfYearAndMonth {
	
	
	private int getDate(int year, int month)
	{
		LocalDate ldate= LocalDate.of(year, month, 1)
						.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY))
						.with(TemporalAdjusters.next(DayOfWeek.THURSDAY))
						.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
		int day=ldate.getDayOfMonth();
		return day;
	}
	
	public static void main (String args[])
	{
		ThirdThursdayOfYearAndMonth thirdThursdayOfYearAndMonth= new ThirdThursdayOfYearAndMonth();
		System.out.println(thirdThursdayOfYearAndMonth.getDate(2019,11));
		
	}

}
