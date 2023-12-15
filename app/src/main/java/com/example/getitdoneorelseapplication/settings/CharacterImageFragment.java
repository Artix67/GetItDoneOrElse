package com.example.getitdoneorelseapplication.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.getitdoneorelseapplication.R;

public class CharacterImageFragment extends Fragment {
    public static final String ARG_IMAGE_ID = "imageId";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_character_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.characterImageView);

        // Set the image resource based on the argument passed to the fragment
        int imageId = requireArguments().getInt(ARG_IMAGE_ID);
        imageView.setImageResource(imageId);

        // Set content description for accessibility
        imageView.setContentDescription(getString(R.string.description_of_the_image));
    }
}
