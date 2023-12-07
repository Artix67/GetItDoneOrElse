package com.example.getitdoneorelseapplication.artix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.databinding.ActivityMainArtixBinding;

public class MainActivityArtix extends AppCompatActivity {

    private ActivityMainArtixBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainArtixBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button myButton = binding.AddEventButton;

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use an Intent to start the EventEditActivity
                Intent intent = new Intent(MainActivityArtix.this, EventEditActivity.class);
                startActivity(intent);
            }
        });
    }
}