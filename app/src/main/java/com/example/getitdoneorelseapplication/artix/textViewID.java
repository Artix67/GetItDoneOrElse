package com.example.getitdoneorelseapplication.artix;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.calendar.Event;

public class textViewID extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_layout);

        LinearLayout layout = findViewById(R.id.yourLinearLayout); // Replace with your actual layout ID

        for (Event event : Event.eventList) {
            TextView textView = new TextView(this);

            // Set the ID dynamically based on Event properties
            int eventId = generateEventId(event);
            textView.setId(eventId);

            // Set other properties for your TextView
            textView.setText(event.getName());
            // Add the TextView to your layout
            layout.addView(textView);
        }
    }

    private int generateEventId(Event event) {
        // Use a combination of event properties to generate a unique ID
        // You can use hashCode() or any other logic that suits your requirements
        return event.getName().hashCode() ^ event.getDate().hashCode() ^ event.getTime().hashCode();
    }
}