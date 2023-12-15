package com.example.getitdoneorelseapplication.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.ComicAlexOneActivity;
import com.example.getitdoneorelseapplication.ComicAlexThreeActivity;
import com.example.getitdoneorelseapplication.ComicAlexTwoActivity;
import com.example.getitdoneorelseapplication.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class CharacterSelection extends AppCompatActivity {

    private SwitchMaterial humorousSwitch;
    private SwitchMaterial aggressiveSwitch;
    private SwitchMaterial enthusiasticSwitch;
    private SwitchMaterial nurturingSwitch;

    public CharacterSelection() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_selection);

        // Initialize switches
        humorousSwitch = findViewById(R.id.HumorousSwitch);
        aggressiveSwitch = findViewById(R.id.AggressiveSwitch);
        enthusiasticSwitch = findViewById(R.id.EnthusiasticSwitch);
        nurturingSwitch = findViewById(R.id.NurturingSwitch);

        // Set listeners for switches
        setSwitchListeners();
    }

    private void showToast(String message) {
        // Show a short toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void handleModeActivation(String mode) {
        // Handle mode-specific actions
        showToast(mode + " mode activated!");

    }

    private void performGeneralActions() {
        // Perform common actions for all modes when the switch is ON
        showToast("");

    }

    // Switch listeners
    private void setSwitchListeners() {
        humorousSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Handle Humorous mode activation
                handleModeActivation("Humorous");
                performGeneralActions();
            }
        });

        aggressiveSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Handle Aggressive mode activation
                handleModeActivation("Aggressive");
                performGeneralActions();
            }
        });

        enthusiasticSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Handle Enthusiastic mode activation
                handleModeActivation("Enthusiastic");
                performGeneralActions();
            }
        });

        nurturingSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Handle Nurturing mode activation
                handleModeActivation("Nurturing");
                performGeneralActions();
            }
        });
    }

    public void onImageClicked(View view) {
        int imageId = view.getId();

        Intent intent;
        if (imageId == R.id.comic_alex_one) {
            intent = new Intent(this, ComicAlexOneActivity.class);
        } else if (imageId == R.id.comic_alex_two) {
            intent = new Intent(this, ComicAlexTwoActivity.class);
        } else if (imageId == R.id.comic_alex_three) {
            intent = new Intent(this, ComicAlexThreeActivity.class);
        } else {
            return;
        }
        // Start the appropriate activity
        startActivity(intent);
    }
}
