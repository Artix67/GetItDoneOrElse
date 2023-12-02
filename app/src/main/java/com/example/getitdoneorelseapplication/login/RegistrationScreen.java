package com.example.getitdoneorelseapplication.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.getitdoneorelseapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationScreen extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText username;
    EditText password;
    EditText reEnter;

    private FirebaseAuth auth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);


        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() !=null){
            startActivity(new Intent(RegistrationScreen.this, MainActivityMiki.class));
            finish();
        }


        name = findViewById(R.id.editText4);
        email = findViewById(R.id.editText3);
        username = findViewById(R.id.editText7);
        password = findViewById(R.id.editText5);
        reEnter = findViewById(R.id.editText8);

    }

    public void signin(View view) {
        startActivity(new Intent(RegistrationScreen.this,LoginScreen.class));

    }

    public void signup(View view) {

        String nameUser = name.getText().toString();
        String userName = username.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        String userReEnter = reEnter.getText().toString();

        if (TextUtils.isEmpty(nameUser)){

            Toast.makeText(this, "Name", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(userEmail)){

            Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(userName)){

            Toast.makeText(this, "Username", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(userPassword)){

            Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(userReEnter)){

            Toast.makeText(this, "Repeat Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userPassword.length() < 6){

            Toast.makeText(this, "Password too short, minimum of 6 characters. ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userReEnter.matches(userPassword))
        {
            Toast.makeText(this, "Passwords match!", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Passwords needs to match.", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(RegistrationScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task. isSuccessful()){
                            Toast.makeText(RegistrationScreen.this, "Successful Login!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationScreen.this, MainActivityMiki.class));
                        }else {
                            Toast.makeText(RegistrationScreen.this, " Failed Connection." +task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });


        //startActivity(new Intent(RegistrationScreen.this, MainActivityMiki.class));
    }



}
