package com.example.getitdoneorelseapplication.artix;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class RecyclerView extends AppCompatActivity {

    private ArrayList<Event> menuEventList = Event.eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home.xml);

        NestedScrollView nestedScrollView = findViewById(R.id.nested_calendar_event_viewer);

        androidx.recyclerview.widget.RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new EventAdapter(menuEventList)); // Replace with your array of Event
    }
}