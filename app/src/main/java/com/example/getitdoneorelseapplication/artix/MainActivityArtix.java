package com.example.getitdoneorelseapplication.artix;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.getitdoneorelseapplication.R;
import com.example.getitdoneorelseapplication.databinding.ActivityMainArtrixBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityArtix extends AppCompatActivity {

    private ActivityMainArtrixBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainArtrixBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(navView, navController);

    }

    newEvent newobj = new newEvent();

}