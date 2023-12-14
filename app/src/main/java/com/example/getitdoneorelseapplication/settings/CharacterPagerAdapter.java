package com.example.getitdoneorelseapplication.settings;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CharacterPagerAdapter extends FragmentStateAdapter {

    private final int[] characterImageIds;

    public CharacterPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, int[] characterImageIds) {
        super(fragmentManager, lifecycle);
        this.characterImageIds = characterImageIds;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Create a new fragment for each character image
        CharacterImageFragment fragment = new CharacterImageFragment();
        Bundle args = new Bundle();
        args.putInt(CharacterImageFragment.ARG_IMAGE_ID, characterImageIds[position]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        // Return the number of character images
        return characterImageIds.length;
    }
}
