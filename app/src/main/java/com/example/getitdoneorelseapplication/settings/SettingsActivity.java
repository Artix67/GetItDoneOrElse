package com.example.getitdoneorelseapplication.settings;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.R;
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
        themeSwitch = findViewById(R.id.themeSwitch);  // Removed the redeclaration
        theme1Switch = findViewById(R.id.theme1Switch);  // Removed the redeclaration

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

        // Create an Intent to start the ActivityCharacters activity
        Intent intent = new Intent(this, CharacterSelection.class);

        // Pass any necessary data to ActivityCharacters using Intent extras
        intent.putExtra("Character Selection", characterSelection);

        // Start the ActivityCharacters activity
        startActivity(intent);

        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
    }
}
