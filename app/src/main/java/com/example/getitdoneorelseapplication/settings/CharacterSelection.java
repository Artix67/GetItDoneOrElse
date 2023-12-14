package com.example.getitdoneorelseapplication.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.getitdoneorelseapplication.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

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

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void handleHumorousMode() {
        // Actions specific to Humorous mode
        showToast("Humorous mode activated!");
        // Add more actions as needed
        // ...
    }

    private void handleAggressiveMode() {
        // Actions specific to Aggressive mode
        showToast("Aggressive mode activated!");
        // Add more actions as needed
        // ...
    }

    private void handleEnthusiasticMode() {
        // Actions specific to Enthusiastic mode
        showToast("Enthusiastic mode activated!");
        // Add more actions as needed
        // ...
    }

    private void handleNurturingMode() {
        // Actions specific to Nurturing mode
        showToast("Nurturing mode activated!");
        // Add more actions as needed
        // ...
    }

    private void performGeneralActions() {
        // Common actions for all modes when the switch is ON
        showToast("Common actions for all modes!");
        // Add more general actions as needed
        // ...
    }

    // Your switch listeners
    private void setSwitchListeners() {
        humorousSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                handleHumorousMode();
                performGeneralActions();
            }
        });

        aggressiveSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                handleAggressiveMode();
                performGeneralActions();
            }
        });

        enthusiasticSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                handleEnthusiasticMode();
                performGeneralActions();
            }
        });

        nurturingSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                handleNurturingMode();
                performGeneralActions();
            }
        });
    }

    public void onImageClicked(View view) {
    }
}
