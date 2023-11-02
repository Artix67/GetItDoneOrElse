package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        selectDate = LocalDate.now();
        setMonthView();
    }

    private void initWidgets() {

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.MonthYearTV);
    }

    private void setMonthView() {

    }
}