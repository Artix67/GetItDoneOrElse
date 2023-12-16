package com.example.getitdoneorelseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getitdoneorelseapplication.settings.CharacterSelection;

public class ComicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_selection);

        ImageView alexOneImageView = findViewById(R.id.comic_alex_one);
        ImageView alexTwoImageView = findViewById(R.id.comic_alex_two);
        ImageView alexThreeImageView = findViewById(R.id.comic_alex_three);

        alexOneImageView.setOnClickListener(v -> {
            // Handle the click event for AlexOneImageView
            launchPopUpActivity(R.layout.comic_alex_two);
        });

        alexTwoImageView.setOnClickListener(v -> {
            // Handle the click event for AlexTwoImageView
            launchPopUpActivity(R.layout.comic_alex_one);
        });

        alexThreeImageView.setOnClickListener(v -> {
            // Handle the click event for AlexThreeImageView
            launchPopUpActivity(R.layout.comic_alex_three);
        });
    }

    private void launchPopUpActivity(int layoutResourceId) {
        Intent intent = new Intent(this, CharacterSelection.class);
        intent.putExtra("layoutResourceId", layoutResourceId);

        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onImageClicked(View view) {
        int imageId = view.getId();
        Log.d("ImageClick", "Image clicked with ID: " + imageId);

        Intent intent = new Intent(this, CharacterSelection.class);

        // Determine which image was clicked based on its ID
        int layoutResourceId;
        if (imageId == R.id.comic_alex_one) {
            layoutResourceId = R.layout.comic_alex_two;
        } else if (imageId == R.id.comic_alex_two) {
            layoutResourceId = R.layout.comic_alex_one;
        } else if (imageId == R.id.comic_alex_three) {
            layoutResourceId = R.layout.comic_alex_three;
        } else {
            return;
        }

        intent.putExtra("layoutResourceId", layoutResourceId);
        startActivity(intent);
    }

}
