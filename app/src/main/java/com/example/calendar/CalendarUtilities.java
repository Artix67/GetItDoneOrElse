package com.example.calendar;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendarUtilities
{
    public static LocalDate selectDate;

    public static String monthYearFromDate(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }
    public static ArrayList<LocalDate> daysInMonthArray(LocalDate Date)
    {
        ArrayList<LocalDate> dayInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(Date);
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstOfMonth = CalendarUtilities.selectDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for (int i = 1; i <= 42; i++)
        {
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
            {
                dayInMonthArray.add(null);
            }
            else
            {
                dayInMonthArray.add(LocalDate.of(selectDate.getYear(),selectDate.getMonth(), i - dayOfWeek));
            }

        }
        return  dayInMonthArray;
    }



    public static ArrayList<LocalDate> daysInWeekArray(LocalDate selectDate)
    {
        ArrayList<LocalDate> days = new ArrayList<>();
        LocalDate current = sundayForDate(selectDate);
        LocalDate endDate = current.plusWeeks(1);

        while(current.isBefore(endDate))
        {
            days.add(current);
            current = current.plusDays(1);
        }
        return days;
    }

    private static LocalDate sundayForDate(LocalDate current)
    {
        LocalDate oneWeekAgo = current.minusWeeks(1);
        while (current.isAfter(oneWeekAgo))
        {
            if (current.getDayOfWeek() == DayOfWeek.SUNDAY)
                return current;
            current = current.minusDays(1);

        }
        return  null;
    }

}

