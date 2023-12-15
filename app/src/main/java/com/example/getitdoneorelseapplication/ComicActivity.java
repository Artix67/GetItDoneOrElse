package com.example.getitdoneorelseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ComicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_selection);

        ImageView alexOneImageView = findViewById(R.id.comic_alex_one);
        ImageView alexTwoImageView = findViewById(R.id.comic_alex_two);
        ImageView alexThreeImageView = findViewById(R.id.comic_alex_three);

        alexOneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for AlexOneImageView
                launchPopUpActivity(ComicAlexOneActivity.class);
            }
        });

        alexTwoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for AlexTwoImageView
                launchPopUpActivity(ComicAlexTwoActivity.class);
            }
        });

        alexThreeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for AlexThreeImageView
                launchPopUpActivity(ComicAlexThreeActivity.class);
            }
        });
    }

    private void launchPopUpActivity(Class<?> popUpActivityClass) {
        Intent intent = new Intent(this, popUpActivityClass);
        startActivity(intent);
    }
}
