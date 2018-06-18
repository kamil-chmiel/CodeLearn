package com.company.codelearn;

import java.util.ArrayList;

class QuizElement{

        int quizID;
        String question;
        ArrayList<String> answers;
        int correctAnswer;

        QuizElement(int quizID, String question, ArrayList<String> answers, int correctAnswer){
            this.quizID = quizID;
            this.question = question;
            this.answers = answers;
            this.correctAnswer = correctAnswer;
        }
}

