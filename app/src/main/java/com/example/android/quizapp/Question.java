package com.example.android.quizapp;

import java.util.List;

/**
 * Created by Dimitar Dimitrov  on 25/03/2017.
 */

/**
 * This is the main "question" body
 */

public class Question {

    public String questionContent;
    public List<String> answers;
    public int correctAnswers;

    /**
     *
     * @param questionContent the content of the question
     * @param answers  then it provides multiple choice options and only one is correct.
     * @param correctAnswers then within the choices there is one correct answer hard coded. No logical pattern !
     *
     *
     *
     */
    public Question (String questionContent, List<String> answers, int correctAnswers){

        this.questionContent = questionContent;
        this.answers = answers;
        this.correctAnswers = correctAnswers;

    }

/*
This gets the String question and in my case this it is the same question all the time, only the country changes.
 */
    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent (String questionContent){
        this.questionContent = questionContent;
    }

    public List<String> getAnswers (){return answers;
    }
        public void setAnaswers (List<String> answers){
            this.answers = answers;

        }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers (int correctAnswers){
        this.correctAnswers = correctAnswers;
    }
}
