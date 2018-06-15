package com.company.codelearn;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


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


        assert actionBar != null;

        if(lectureNumber == 0)
            actionBar.setTitle("Błędna lekcja!");
        else
            actionBar.setTitle(DB.getInstance().titles.get(lectureNumber));
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

        lectureText.setText(DB.getInstance().lessons.get(lectureNumber));
        toolbar.setNavigationOnClickListener(view -> {

            Intent mainIntent = new Intent(this,MainActivity.class);
            view.getContext().startActivity(mainIntent);

        });


        Button continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(view -> {

                lectureViewIntent.putExtra("lessonNumber", lectureNumber + 1);
                view.getContext().startActivity(lectureViewIntent);

        });

        if(lectureNumber == 41)
            continueButton.setVisibility(View.GONE);

        Button previousButton = findViewById(R.id.previousButton);
        previousButton.setOnClickListener(view -> {

                lectureViewIntent.putExtra("lessonNumber", lectureNumber - 1);
                view.getContext().startActivity(lectureViewIntent);

        });

        if(lectureNumber == 1)
            previousButton.setVisibility(View.GONE);

    }

    @Override
    public void onBackPressed(){

    }


}
