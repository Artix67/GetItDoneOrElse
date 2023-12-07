package com.example.getitdoneorelseapplication.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.getitdoneorelseapplication.R;


import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.material.switchmaterial.SwitchMaterial;



import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    private TextInputEditText textInputEditText;
    private EditText editTextText, editTextText2, editTextText3;
    private SwitchMaterial themeSwitch, theme1Switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_kevin);

        textInputEditText = findViewById(R.id.textInputEditText);
        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
      SwitchMaterial  themeSwitch = findViewById(R.id.themeSwitch);
      SwitchMaterial theme1Switch = findViewById(R.id.theme1Switch);

        Button editNameButton = findViewById(R.id.editNameButton);
        Button editEmailButton = findViewById(R.id.editEmailButton);
        Button saveButton = findViewById(R.id.button4);

        editNameButton.setOnClickListener(view -> editName());

        editEmailButton.setOnClickListener(view -> editEmail());

        saveButton.setOnClickListener(view -> saveSettings());
    }

    private void editName() {

        textInputEditText.setText("");
    }

    private void editEmail() {

        editTextText.setText("");
    }

    private void saveSettings() {


        String name = Objects.requireNonNull(textInputEditText.getText()).toString();
        String panicMode = editTextText.getText().toString();
        String timeoutMode = editTextText2.getText().toString();
        String characterSelection = editTextText3.getText().toString();
        boolean isThemeSwitchChecked = themeSwitch.isChecked();
        boolean isTheme1SwitchChecked = theme1Switch.isChecked();


        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
    }
}