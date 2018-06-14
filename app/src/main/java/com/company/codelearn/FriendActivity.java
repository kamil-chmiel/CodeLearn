package com.company.codelearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendActivity extends AppCompatActivity {
    private FriendListViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom Cruise");
        list.add("Kamil Majerczyk");
        list.add("Adrian Playboy to ja");
        getWindow().setBackgroundDrawableResource(R.drawable.hands);
        adapter = new FriendListViewAdapter(list, this);

        ListView lView = (ListView) findViewById(R.id.friend_list_view);
        lView.setAdapter(adapter);
        Button addBtn = (Button) findViewById(R.id.add_btn);

        addBtn.setOnClickListener(v -> {
            EditText friendEmail = (EditText) findViewById(R.id.friend_email);
            adapter.addUser(friendEmail.getText().toString());
        });
    }

}
