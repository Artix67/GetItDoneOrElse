package com.example.getitdoneorelse;

import static com.example.getitdoneorelse.R.id.TEXTVIEW1;
import static com.example.getitdoneorelse.R.id.TEXTVIEW2;
import static com.example.getitdoneorelse.R.id.TEXTVIEW3;
import static com.example.getitdoneorelse.R.id.TEXTVIEW4;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomActivity extends Activity {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private List<String> taskList;
    private List<TextView> textViews;
    private int spin;
    private int taskWordIndex;
    private String currentTaskWord;
    private List<String> originalTaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        // Initialize the button and set the click listeners
        Button randomButton = findViewById(R.id.randomButton);
        randomButton.setOnClickListener(this::onRandomClick);

        // Create a copy of the original task list
        originalTaskList = new ArrayList<>();
        originalTaskList.add("MOP");
        originalTaskList.add("SWEEP");
        originalTaskList.add("VACUUM");
        originalTaskList.add("DISHES");
        originalTaskList.add("LAUNDRY");
        originalTaskList.add("TAKE OUT TRASH");
        originalTaskList.add("MAKE DINNER");

        // Initialize the list of TextViews
        textViews = new ArrayList<>();
        for (int i : new int[]{TEXTVIEW1, TEXTVIEW2, TEXTVIEW3, TEXTVIEW4}) {
            textViews.add(findViewById(i));
        }

        // Populate the task list
        taskList = new ArrayList<>(originalTaskList);
    }

    // Handle the click event for the random button
    public void onRandomClick(View view) {
        if (!taskList.isEmpty()) {
            spin = 0;
            taskWordIndex = 0;
            currentTaskWord = "";
            scrollForward(0);
        }
    }

    // Scroll the text forward in the text views
    private void scrollForward(int currentViewIndex) {
        int maxSpin = 6;
        if (spin < maxSpin) {
            updateCurrentTaskWord(currentViewIndex);

            for (int i = 0; i < textViews.size(); i++) {
                textViews.get(i).setText((i == currentViewIndex) ? currentTaskWord : "");
            }

            startAnimation(textViews.get(currentViewIndex));

            // Delay the next scroll forward action
            handler.postDelayed(() -> scrollForward((currentViewIndex + 1) % textViews.size()), 42);

            // Update the spin count
            if (currentViewIndex == 1) {
                spin++;
            }
        } else {
            // Display a random task word
            displayRandomTaskWord();
        }
    }

    // Update the current task word based on the current view index
    private void updateCurrentTaskWord(int currentViewIndex) {
        if (currentViewIndex == 0) {
            currentTaskWord = taskList.get(taskWordIndex);
            taskWordIndex = (taskWordIndex + 1) % taskList.size();
        }
    }

    // Start the animation to move the text view
    private void startAnimation(TextView textView) {
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(textView, "translationY", 1, 48);
        translationAnimator.setDuration(1200);
        translationAnimator.setInterpolator(new DecelerateInterpolator());
        translationAnimator.start();
    }

    // Display a random task word in the second text view
    private void displayRandomTaskWord() {
        if (taskList.isEmpty()) {
            // Reset the task list when it becomes empty
            taskList = new ArrayList<>(originalTaskList);
        }
        Random randomizer = new Random();
        int randomTaskIndex = randomizer.nextInt(taskList.size());
        String randomTask = taskList.get(randomTaskIndex);
        textViews.get(1).setText(randomTask);
        taskList.remove(randomTask);
    }
}