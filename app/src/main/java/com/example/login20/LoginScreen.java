package com.example.login20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


    }

    public void signIn(View view) {
        startActivity(new Intent(LoginScreen.this, MainActivityMiki.class));

    }

    public void signUp(View view) {
        startActivity(new Intent(LoginScreen.this,RegistrationScreen.class));

    }

}