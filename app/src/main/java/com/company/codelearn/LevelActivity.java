package com.company.codelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Button juniorButton = findViewById(R.id.button111);
        Button regularButton = findViewById(R.id.button222);
        Button seniorButton = findViewById(R.id.button333);

        UserData userData = (UserData) getIntent().getSerializableExtra("UserData");

        juniorButton.setOnClickListener(v -> {
            Intent intent = new Intent(LevelActivity.this, MainActivity.class);
            intent.putExtra("UserData", userData);
            startActivity(intent);
        });

        regularButton.setOnClickListener(v -> {
            Intent intent = new Intent(LevelActivity.this, MainActivity.class);
            intent.putExtra("UserData", userData);
            startActivity(intent);
        });

        seniorButton.setOnClickListener(v -> {
            Intent intent = new Intent(LevelActivity.this, MainActivity.class);
            intent.putExtra("UserData", userData);
            startActivity(intent);
        });
    }
}
