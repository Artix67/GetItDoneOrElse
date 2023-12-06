package com.example.getitdoneorelseapplication.artix;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home.xml); // Replace with your layout file

        android.widget.CalendarView calendarView = findViewById(R.id.calendarView);

        // Set the OnDateChangeListener
        calendarView.setOnDateChangeListener(new android.widget.CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull android.widget.CalendarView view, int year, int month, int dayOfMonth) {
                // Launch the MainActivityCalendar when a date is selected
                launchMainActivityCalendar(year, month, dayOfMonth);
            }
        });
    }

    private void launchMainActivityCalendar(int year, int month, int dayOfMonth) {
        Intent intent = new Intent(this, MainActivityCalendar.class);
        // Pass the selected date information to the MainActivityCalendar
        intent.putExtra("year", year);
        intent.putExtra("month", month);
        intent.putExtra("dayOfMonth", dayOfMonth);
        startActivity(intent);
    }
}