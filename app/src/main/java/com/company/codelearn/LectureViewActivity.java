package com.company.codelearn;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;


public class LectureViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_view);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        TextView lectureText = findViewById(R.id.lectureText);

        Intent lectureViewIntent = getIntent();
        Integer lectureNumber = lectureViewIntent.getIntExtra("lessonNumber",0);
        String lectureTitle = lectureViewIntent.getStringExtra("lessonTitle");

        assert actionBar != null;

        if(lectureNumber == 0)
            actionBar.setTitle("Błędna lekcja!");
        else
            actionBar.setTitle(lectureTitle);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

        lectureText.setText(DB.getInstance().lessons.get(lectureNumber));
        toolbar.setNavigationOnClickListener(view -> super.onBackPressed());


        Button doneButton = findViewById(R.id.doneButton);
        doneButton.setOnClickListener(view -> super.onBackPressed());


    }

    @Override
    public void onBackPressed(){

    }


}
