package com.company.codelearn;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class QuizViewActivity extends AppCompatActivity  {

    int quizElementsAmount = DB.getInstance().quizElements.size()-1;
    int score = 0;
    int currentQuestion = 0;
    int correctAnswer = 0;
    int answer;
    int checkedAnswer;
    int fragmentID;
    Bundle args = new Bundle();
    RadioGroup answerGroup;
    Button buttonNext, buttonCheck;
    ArrayList<Integer> buttonIdList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_view);


        Intent quizIntent = getIntent();


        // SET TOOLBAR //

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;

        actionBar.setTitle(quizIntent.getStringExtra("quizTitle"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(view -> {

            Intent mainIntent = new Intent(this,MainActivity.class);
            view.getContext().startActivity(mainIntent);

        });

        // FILL BUTTON ID LIST

        fillButtonIdList();

        // SET FIRST QUESTION

        if (savedInstanceState == null) {

            args.putInt("currentQuestion",currentQuestion);

            QuestionFragment question = new QuestionFragment();
            question.setArguments(args);
            fragmentID = question.getId();

            changeFragment(question);
        }

        //SET BUTTON ONCLICK

        buttonCheck = findViewById(R.id.checkQuestionButton);
        buttonCheck.setOnClickListener(view -> {

            answerGroup = getFragmentManager()
                    .findFragmentById(fragmentID)
                    .getActivity()
                    .findViewById(R.id.radio_answer_group);

            checkedAnswer = answerGroup.getCheckedRadioButtonId();
            answer = parseAnswer(checkedAnswer);

            correctAnswer = DB.getInstance().quizElements.get(currentQuestion).correctAnswer;

            if(answer == correctAnswer) {
                Toast.makeText(this, "Correct Answer!", Toast.LENGTH_LONG).show();
                score += 10;
                setColorRadioGroup(true,answer);
            }
            else {
                Toast.makeText(this, "Incorrect Answer!", Toast.LENGTH_LONG).show();
                setColorRadioGroup(false,checkedAnswer);
            }

            buttonNext.setVisibility(View.VISIBLE);
            buttonCheck.setVisibility(View.GONE);

        });


        buttonNext = findViewById(R.id.nextQuestionButton);
        buttonNext.setOnClickListener(view -> {

            if (currentQuestion != quizElementsAmount) {

                args.clear();
                ++currentQuestion;
                args.putInt("currentQuestion", currentQuestion);

                QuestionFragment question = new QuestionFragment();
                fragmentID = question.getId();
                question.setArguments(args);

                changeFragment(question);

                buttonCheck.setVisibility(View.VISIBLE);
                buttonNext.setVisibility(View.GONE);
            }
            else{
                args.clear();
                args.putInt("score", score);
                endFragment end = new endFragment();
                end.setArguments(args);

                buttonCheck.setVisibility(View.GONE);
                buttonNext.setVisibility(View.GONE);

                changeFragment(end);
            }

        });
    }


    public static class QuestionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View question = inflater.inflate(R.layout.quiz_question_fragment, container, false);
            Bundle args = getArguments();
            int currentQuestion = args.getInt("currentQuestion",0);


            TextView questionText = question.findViewById(R.id.question);
            RadioButton answer1 = question.findViewById(R.id.answer_1);
            RadioButton answer2 = question.findViewById(R.id.answer_2);
            RadioButton answer3 = question.findViewById(R.id.answer_3);
            RadioButton answer4 = question.findViewById(R.id.answer_4);

            questionText.setText(DB.getInstance().quizElements.get(currentQuestion).question);
            answer1.setText(DB.getInstance().quizElements.get(currentQuestion).answers.get(0));
            answer2.setText(DB.getInstance().quizElements.get(currentQuestion).answers.get(1));
            answer3.setText(DB.getInstance().quizElements.get(currentQuestion).answers.get(2));
            answer4.setText(DB.getInstance().quizElements.get(currentQuestion).answers.get(3));

            return question;
        }
    }


    public static class endFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View end = inflater.inflate(R.layout.quiz_end_fragment, container, false);

            Bundle args = getArguments();
            Integer intScore = args.getInt("score",0);
            String score = intScore.toString()+"/50";

            TextView scoreText = end.findViewById(R.id.score);
            scoreText.setText(score);


            Button menuButton = end.findViewById(R.id.menuButton);
            menuButton.setOnClickListener(view -> {

                Intent mainIntent = new Intent(getActivity(),MainActivity.class);
                view.getContext().startActivity(mainIntent);

            });

            return end;
        }
    }

    @Override
    public void onBackPressed(){

    }


    // #RAK

    private void fillButtonIdList() {

        buttonIdList.add(-1);
        buttonIdList.add(R.id.answer_1);
        buttonIdList.add(R.id.answer_2);
        buttonIdList.add(R.id.answer_3);
        buttonIdList.add(R.id.answer_4);

    }

    private void changeFragment(Fragment newFragment){

        getFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.container, newFragment)
                .commit();

    }


    private int parseAnswer(int checkedAnswer) {

        int radio1 = getRadioButton(R.id.answer_1).getId();

        int radio2 = getRadioButton(R.id.answer_2).getId();

        int radio3 = getRadioButton(R.id.answer_3).getId();

        int radio4 = getRadioButton(R.id.answer_4).getId();


        if(checkedAnswer == radio1)
            return 1;
        if(checkedAnswer == radio2)
            return 2;
        if(checkedAnswer == radio3)
            return 3;
        if(checkedAnswer == radio4)
            return 4;

        return -1;

    }

    private void setColorRadioGroup(boolean isAnswerCorrect, int answer) {

        if(isAnswerCorrect)
                getRadioButton(buttonIdList.get(answer))
                                                .setBackgroundColor(Color.GREEN);
          else {

                if(parseAnswer(answer) == -1) // nie zaznaczono żadnej opcji

                    getRadioButton(buttonIdList.get(correctAnswer))
                            .setBackgroundColor(Color.GREEN);

                else {

                    getRadioButton(buttonIdList.get(parseAnswer(answer)))
                            .setBackgroundColor(Color.RED);

                    getRadioButton(buttonIdList.get(correctAnswer))
                            .setBackgroundColor(Color.GREEN);


                }
        }
    }

    private RadioButton getRadioButton(int id){

        return getFragmentManager()
                    .findFragmentById(fragmentID)
                    .getActivity()
                    .findViewById(id);

    }



}
