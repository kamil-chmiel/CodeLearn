package com.company.codelearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class InviteFriendActivity extends AppCompatActivity {
    private Button inviteButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Invite Friend", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_invite_friends);

        inviteButton = findViewById(R.id.inviteButton);
        inviteButton.setOnClickListener(view -> {
            Toast.makeText(this,"Clicked", Toast.LENGTH_SHORT).show();
        });
    }
}
