package com.example.getitdoneorelseapplication.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.ComicActivity;
import com.example.getitdoneorelseapplication.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class CharacterSelection extends AppCompatActivity {

    private SwitchMaterial humorousSwitch;
    private SwitchMaterial aggressiveSwitch;
    private SwitchMaterial enthusiasticSwitch;
    private SwitchMaterial nurturingSwitch;

    // Constant for intent extra key
    private static final String LAYOUT_RESOURCE_ID_KEY = "layoutResourceId";

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
        // Add more actions as needed
        // ...
    }

    private void performGeneralActions() {
        // Perform common actions for all modes when the switch is ON
        showToast("Common actions for all modes!");
        // Add more general actions as needed
        // ...
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

        // Create an intent to start the ComicActivity
        Intent intent = new Intent(this, ComicActivity.class);

        // Determine which image was clicked based on its ID
        int layoutResourceId = 0;  // Default value for unknown image ID

        if (imageId == R.id.comic_alex_one) {
            layoutResourceId = R.layout.comic_alex_one;
        } else if (imageId == R.id.comic_alex_two) {
            layoutResourceId = R.layout.comic_alex_two;
        } else if (imageId == R.id.comic_alex_three) {
            layoutResourceId = R.layout.comic_alex_three;
        }

        // If layoutResourceId is still 0, it means an unknown image ID, do nothing
        if (layoutResourceId == 0) {
            return;
        }

        // Add the layout resource ID as an extra to the intent
        intent.putExtra(LAYOUT_RESOURCE_ID_KEY, layoutResourceId);

        // Start the ComicActivity
        startActivity(intent);
    }



}
