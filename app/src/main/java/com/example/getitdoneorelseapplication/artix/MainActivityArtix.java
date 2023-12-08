package com.example.getitdoneorelseapplication.artix;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.getitdoneorelseapplication.calendar.EventEditActivity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.R;
import com.example.getitdoneorelseapplication.calendar.EventEditActivity;
import com.example.getitdoneorelseapplication.databinding.ActivityMainArtrixBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivityArtix extends AppCompatActivity {

    private ActivityMainArtrixBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainArtrixBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FloatingActionButton myButton = findViewById(R.id.AddEventButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventEditActivity eventEditActivity = new EventEditActivity();
                eventEditActivity.onCreate(savedInstanceState);
            }
        });
    }
}