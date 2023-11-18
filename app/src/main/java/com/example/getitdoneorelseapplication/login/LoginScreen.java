package com.example.getitdoneorelseapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.getitdoneorelseapplication.R;

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