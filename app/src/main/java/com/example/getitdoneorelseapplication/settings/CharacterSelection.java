package com.example.getitdoneorelseapplication.settings;

import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.R;

import java.util.Objects;

public class CharacterSelection extends AppCompatActivity {

    public final ThreadLocal<Switch> humorousSwitch = new ThreadLocal<>();
    public final ThreadLocal<Switch> aggressiveSwitch = new ThreadLocal<>();
    public final ThreadLocal<Switch> enthusiasticSwitch = new ThreadLocal<>();
    public final ThreadLocal<Switch> nurturingSwitch = new ThreadLocal<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_selection);

        humorousSwitch.set(findViewById(R.id.HumorousSwitch));
        aggressiveSwitch.set(findViewById(R.id.AggressiveSwitch));
        enthusiasticSwitch.set(findViewById(R.id.EnthusiasticSwitch));
        nurturingSwitch.set(findViewById(R.id.NurturingSwitch));

        // Set listeners for switches if needed
        setSwitchListeners();
    }

    private void setSwitchListeners() {
        Objects.requireNonNull(humorousSwitch.get()).setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle Humorous switch state change
        });

        Objects.requireNonNull(aggressiveSwitch.get()).setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle Aggressive switch state change
        });

        Objects.requireNonNull(enthusiasticSwitch.get()).setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle Enthusiastic switch state change
        });

        Objects.requireNonNull(nurturingSwitch.get()).setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle Nurturing switch state change
        });
    }

    // TODO: Add your logic for handling ImageButtons

    // TODO: Add any additional logic or listeners as needed
}


