package com.example.getitdoneorelseapplication.calendar;

import static com.example.getitdoneorelseapplication.calendar.CalendarUtilities.daysInMonthArray;
import static com.example.getitdoneorelseapplication.calendar.CalendarUtilities.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getitdoneorelseapplication.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivityCalendar extends AppCompatActivity implements  CalendarAdapter.OnItemListener {
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kevin);
        initWidgets();
        CalendarUtilities.selectDate = LocalDate.now();
        setMonthView();
    }

    private void initWidgets() {

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.MonthYearTV);
    }

    private void setMonthView()
    {
     monthYearText.setText(monthYearFromDate(CalendarUtilities.selectDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray();

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth,this );
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }


    public  void previousMonthAction(View view)

    {
        CalendarUtilities.selectDate = CalendarUtilities.selectDate.minusMonths(1);
          setMonthView();
    }

    public void nextMonthAction(View view)
    {
        CalendarUtilities.selectDate = CalendarUtilities.selectDate.plusMonths(1);
        setMonthView();
    }

    public void onItemClick(int position, LocalDate date)
    {
        if(date !=null) {
            CalendarUtilities.selectDate = date;
            setMonthView();
        }

    }

    public void weeklyAction(View view)
    {
        startActivity( new Intent(this,WeekViewActivity.class));
    }
}