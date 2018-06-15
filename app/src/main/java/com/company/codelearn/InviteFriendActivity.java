package com.company.codelearn;

import android.content.Intent;
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
            Intent shareIt = new Intent(Intent.ACTION_SEND);
            shareIt.setType("text/plain");
            String shareMsgBody = "Let's learn code together. \n Download CodeLearn app from Google Play";
            String shareMsgSub = "Join me know! Improve your skill";
            shareIt.putExtra(Intent.EXTRA_SUBJECT,shareMsgSub);
            shareIt.putExtra(Intent.EXTRA_TEXT,shareMsgBody);

            startActivity(Intent.createChooser(shareIt,"Invite Friend by using:"));
            });
    }
}
