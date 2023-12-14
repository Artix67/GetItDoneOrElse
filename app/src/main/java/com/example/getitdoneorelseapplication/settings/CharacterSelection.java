package com.example.getitdoneorelseapplication.settings;

import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Objects;

public class CharacterSelection extends AppCompatActivity {

    private SwitchMaterial humorousSwitch;
    private SwitchMaterial aggressiveSwitch;
    private SwitchMaterial enthusiasticSwitch;
    private SwitchMaterial nurturingSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_selection);

        humorousSwitch = findViewById(R.id.HumorousSwitch);
        aggressiveSwitch = findViewById(R.id.AggressiveSwitch);
        enthusiasticSwitch = findViewById(R.id.EnthusiasticSwitch);
        nurturingSwitch = findViewById(R.id.NurturingSwitch);

        // Set listeners for switches if needed
        setSwitchListeners();
    }

    private void setSwitchListeners() {
        humorousSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle Humorous switch state change
        });

        aggressiveSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle Aggressive switch state change
        });

        enthusiasticSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle Enthusiastic switch state change
        });

        nurturingSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle Nurturing switch state change
        });
    }

    // TODO: Add your logic for handling ImageButtons

    // TODO: Add any additional logic or listeners as needed
}


