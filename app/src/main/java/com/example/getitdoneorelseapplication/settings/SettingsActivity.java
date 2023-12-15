package com.example.getitdoneorelseapplication.settings;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.R;
import com.google.android.material.textfield.TextInputEditText;

public class SettingsActivity extends AppCompatActivity {

    private TextInputEditText textInputEditText, emailEditText;
    private EditText editTextText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_kevin);

        textInputEditText = findViewById(R.id.textInputEditText);
        emailEditText = findViewById(R.id.emailEditText);
        findViewById(R.id.editTextText);
        findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
        findViewById(R.id.themeSwitch);
        findViewById(R.id.theme1Switch);

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
        emailEditText.setText("");
    }

    private void saveSettings() {
        String characterSelection = editTextText3.getText().toString();

        // Create an Intent to start the CharacterSelection activity
        Intent intent = new Intent(this, CharacterSelection.class);

        // Pass any necessary data to CharacterSelection using Intent extras
        intent.putExtra("Character Selection", characterSelection);

        // Start the CharacterSelection activity
        startActivity(intent);

        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
        }

    }
