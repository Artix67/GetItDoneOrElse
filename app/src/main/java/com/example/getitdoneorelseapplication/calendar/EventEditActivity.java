package com.example.getitdoneorelseapplication.calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.R;

import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity {

    private EditText eventNameET;
    private TextView eventDateTV, eventTimeTV;

    private LocalTime time;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Date" + CalendarUtilities.formattedDate(CalendarUtilities.selectDate));
        eventTimeTV.setText("Date" + CalendarUtilities.formattedTime(time));
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);


    }

    public void saveEventAction(View view)

    {
        String eventName = eventNameET.getText().toString();
        Event newEvent =new Event(eventName, CalendarUtilities.selectDate, time);
        Event.eventList.add(newEvent);
        finish();
    }
}