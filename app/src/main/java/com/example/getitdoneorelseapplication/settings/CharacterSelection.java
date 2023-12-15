package com.example.getitdoneorelseapplication.settings;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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

        ViewPager viewPager = findViewById(R.id.viewPager);

        // Set listeners for switches if needed
        setSwitchListeners();

        // Set an OnPageChangeListener to detect page changes
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Not needed for this implementation
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void handleHumorousMode() {
        // Actions specific to Humorous mode
        showToast("Humorous mode activated!");
    }

    private void handleAggressiveMode() {
        // Actions specific to Aggressive mode
        showToast("Aggressive mode activated!");

    }

    private void handleEnthusiasticMode() {
        // Actions specific to Enthusiastic mode
        showToast("Enthusiastic mode activated!");

    }

    private void handleNurturingMode() {
        // Actions specific to Nurturing mode
        showToast("Nurturing mode activated!");

    }

    // Your switch listeners
    private void setSwitchListeners() {
        humorousSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                handleHumorousMode();
            }
        });

        aggressiveSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                handleAggressiveMode();
            }
        });

        enthusiasticSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                handleEnthusiasticMode();
            }
        });

        nurturingSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                handleNurturingMode();
            }
        });
    }
}
