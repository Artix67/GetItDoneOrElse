package com.example.calendar;

import static com.example.calendar.CalendarUtilities.daysInMonthArray;
import static com.example.calendar.CalendarUtilities.daysInWeekArray;
import static com.example.calendar.CalendarUtilities.monthYearFromDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WeekViewActivity extends AppCompatActivity  implements  CalendarAdapter.OnItemListener {

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        setWeekView();
    }
    private void initWidgets() {

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.MonthYearTV);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtilities.selectDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtilities.selectDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days,this );
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }



    public static ArrayList<String> daysInMonthArray(LocalDate Date)
    {
        ArrayList<String> dayInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(Date);
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstOfMonth = CalendarUtilities.selectDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for (int i = 1; i <= 42; i++)
        {
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
            {
                dayInMonthArray.add("");
            }
            else
            {
                dayInMonthArray.add(String.valueOf(i - dayOfWeek));
            }

        }
        return  dayInMonthArray;
    }

    public String monthYearFromDate(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    public void nextWeekAction(View view)
    {
        CalendarUtilities.selectDate = CalendarUtilities.selectDate.plusWeeks(1);
        setWeekView();
    }
    @Override
    public void onItemClick(int position, LocalDate date)
    {
       CalendarUtilities.selectDate = date;
       setWeekView();

    }

    public void previousWeekAction(View view)
    {
        CalendarUtilities.selectDate = CalendarUtilities.selectDate.minusWeeks(1);
        setWeekView();
    }

    public void newEventAction(View view) {
    }
}