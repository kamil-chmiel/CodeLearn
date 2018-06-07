package com.company.codelearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
    private Button editProfileButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initEditProfileButton();
    }

    private void initEditProfileButton() {
        editProfileButton = findViewById(R.id.editProfileButton);

        editProfileButton.setOnClickListener(view -> {
            Intent intentEditProfile = new Intent(ProfileActivity.this, EditProfile.class);
            startActivity(intentEditProfile);
        });
    }
}
