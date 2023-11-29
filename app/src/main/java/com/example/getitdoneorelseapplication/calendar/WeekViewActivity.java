package com.example.getitdoneorelseapplication.calendar;

import static com.example.getitdoneorelseapplication.calendar.CalendarUtilities.daysInWeekArray;
import static com.example.getitdoneorelseapplication.calendar.CalendarUtilities.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getitdoneorelseapplication.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeekViewActivity extends AppCompatActivity  implements  CalendarAdapter.OnItemListener {

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;

    private ListView eventListView;
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
        eventListView = findViewById(R.id.eventListView);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtilities.selectDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtilities.selectDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days,this );
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        setEventAdapter();
    }

    public void previousWeekAction(View view)
    {
        CalendarUtilities.selectDate = CalendarUtilities.selectDate.minusWeeks(1);
        setWeekView();
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
    @Override
    protected void onResume() {

        super.onResume();
        setEventAdapter();
    }
    private void setEventAdapter()
    {

        ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtilities.selectDate);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(),dailyEvents);
        eventListView.setAdapter(eventAdapter);
    }








    public void newEventAction(View view)
    {
        startActivity(new Intent(this, EventEditActivity.class));
    }

    public void dailyAction(View view)
    {
        startActivity(new Intent(this, DailyCalendarActivity.class));
    }
}