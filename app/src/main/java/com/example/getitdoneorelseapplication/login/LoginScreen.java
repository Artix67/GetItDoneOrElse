package com.example.getitdoneorelseapplication.login;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.getitdoneorelseapplication.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class LoginScreen extends AppCompatActivity {

    EditText email;
    EditText password;

    private FirebaseAuth auth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.editText7);
        password = findViewById(R.id.editText5);


    }



    public void signIn(View view) {

        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if (TextUtils.isEmpty(userEmail)){

            Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
            return;



        }
        if (TextUtils.isEmpty(userPassword)){

            Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show();
            return;

        }
        if (userPassword.length() < 6){

            Toast.makeText(this, "Password too short, minimum of 6 characters. ", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(LoginScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            Toast.makeText(LoginScreen.this, "Successful Login!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginScreen.this, MainActivityMiki.class));

                        }else {
                            Toast.makeText(LoginScreen.this, "Please check your email or password."+task.getException(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });



    }

    public void signUp(View view) {
        startActivity(new Intent(LoginScreen.this,RegistrationScreen.class));

    }

}