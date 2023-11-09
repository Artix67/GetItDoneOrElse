package com.example.login20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
    }

    public void signin(View view) {
        startActivity(new Intent(RegistrationScreen.this,LoginScreen.class));

    }

    public void signup(View view) {
        startActivity(new Intent(RegistrationScreen.this,MainActivity.class));
    }
}