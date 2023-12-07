package com.example.getitdoneorelseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivityApplication extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private Button btn1;
    private  Button btn2;
    private Button btn3;

    private  Button btn4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        initWidgets();

        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }


    private void initWidgets() {

        btn = findViewById(R.id.buttonKevin);
        btn4 = findViewById(R.id.buttonSetting);
        btn2 =  findViewById(R.id.buttonMiki);
        btn3 = findViewById(R.id.buttonNatalie);
        btn1 = findViewById(R.id.buttonArtix);
    }


    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.buttonKevin) {
            // Your code for buttonKevin click
            Intent intent = new Intent(this, com.example.getitdoneorelseapplication.calendar.MainActivityCalendar.class);
            startActivity(intent);
        } else if (view.getId() == R.id.buttonMiki) {
            // Your code for buttonMiki click
            Intent intent = new Intent(this, com.example.getitdoneorelseapplication.login.RegistrationScreen.class);
            startActivity(intent);
        } else if (view.getId() == R.id.buttonNatalie) {
            // Your code for buttonNatalie click
            Intent intent = new Intent(this, com.example.getitdoneorelseapplication.natalie.DismissActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.buttonArtix) {
            // Your code for buttonArtix click
            Intent intent = new Intent(this, com.example.getitdoneorelseapplication.artix.MainActivityArtix.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.buttonSetting) {
            // Your code for buttonsettingclick
            Intent intent = new Intent(this, com.example.getitdoneorelseapplication.settings.SettingsActivity.class);
            startActivity(intent);
        }
    }
}