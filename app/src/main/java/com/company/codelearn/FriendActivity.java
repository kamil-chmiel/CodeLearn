package com.company.codelearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.company.codelearn.database.DatabaseHelper;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class FriendActivity extends AppCompatActivity {

    private enum EmailResult {EMAIL_INVALID, EMAIL_VALID, FIELD_EMPTY, ARE_FRIENDS, EMAIL_YOURSELF}

    private FriendListViewAdapter adapter;
    UserData currentUser = new UserData(FirebaseAuth.getInstance().getCurrentUser());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        currentUser = new UserData(FirebaseAuth.getInstance().getCurrentUser());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        getWindow().setBackgroundDrawableResource(R.drawable.hands);

        updateUserFriend();

        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(v -> {
            EditText friendEmailField = findViewById(R.id.friend_email);
            String friendEmail = friendEmailField.getText().toString();
            EmailResult result = validateEmail(friendEmail);
            switch (result) {
                case FIELD_EMPTY:
                    friendEmailField.setError("Field is empty");
                    break;
                case EMAIL_YOURSELF:
                    friendEmailField.setError("You can't add yourself to your friends");
                    break;
                case ARE_FRIENDS:
                    friendEmailField.setError("You are friends already");
                    break;
                case EMAIL_INVALID:
                    friendEmailField.setError("User don't exist!");
                    break;
                case EMAIL_VALID:
                default:
                    new DatabaseHelper(getApplicationContext()).addFriend(currentUser, new DatabaseHelper(getApplicationContext()).getUserDataFromEmail(friendEmail));
                    updateUserFriend();
                    break;
            }
        });
    }

    private EmailResult validateEmail(String friendEmail) {
        UserData friend = new DatabaseHelper(getApplicationContext()).getUserDataFromEmail(friendEmail);
        if(friendEmail.isEmpty()) {
            return EmailResult.FIELD_EMPTY;
        }
        if(friendEmail.equals(currentUser.getEmail())) {
            return EmailResult.EMAIL_YOURSELF;
        }
        if(friend == null) {
            return EmailResult.EMAIL_INVALID;
        }
        if(new DatabaseHelper(getApplicationContext()).areFriends(currentUser, friend)) {
            return EmailResult.ARE_FRIENDS;
        }
        return EmailResult.EMAIL_VALID;
    }

    private void updateUserFriend() {
        List<UserData> friendList = new DatabaseHelper(getApplicationContext()).getFriendList(currentUser);
        adapter = new FriendListViewAdapter(friendList, this);
        ListView lView = findViewById(R.id.friend_list_view);
        lView.setAdapter(adapter);
    }
}
