package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private Integer correctAnswer = 0;
    private int score = 0;
    private boolean questionModeIsOn = true;
    public String questionContent;
    public List<String> answers;
    public int correctAnswers;
    public String currentQuestion;
    public String getQuestionContent;

    @Override
    protected  void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("afterRotationScore", score);

        outState.putString("afterRotationQuestion", currentQuestion );



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**Loads the preserved order amount after screen rotation*/
        if (savedInstanceState !=null){
            score= savedInstanceState.getInt("afterRotationScore");

            //This displays the score after rotation on screen
            TextView scoreView = (TextView) findViewById(R.id.Score_summary);
            scoreView.setText(String.valueOf(score));

            /**
             * This loads the questions after rotation
             */
            if (savedInstanceState !=null)  {

                currentQuestion=  savedInstanceState.getString ("afterRotationQuestion");
                Question currentQuestion = questions.get (currentQuestionIndex);

                TextView textView = (TextView) findViewById(R.id.MainQuestionGrid);
                textView.setText (currentQuestion.getQuestionContent());

        }


        }


        initializeQuiz();
    }





    /**
     * resetting the quiz and start again
     */
    private void resetQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        TextView scoreView = (TextView) findViewById(R.id.Score_summary);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Get questions and set first question
     *
     */
    private void initializeQuiz() {
        QuestionsFeeder questionsFeeder = new QuestionsFeeder();
        questions = questionsFeeder.generateQuestions();
        toggleQuestion();
    }


    /**
     *
     * Toggle next question on the screen also the answers below and check for the correct answers
     *
     *
     */
    private void toggleQuestion (){
        Question currentQuestion = questions.get (currentQuestionIndex);

        TextView textView = (TextView) findViewById(R.id.MainQuestionGrid);
        textView.setText (currentQuestion.getQuestionContent());

        List<String> answers = currentQuestion.getAnswers();
        int buttonNumber = 1;
        for (String ans : answers){
            int buttonResources = getResources().getIdentifier("answers"+ buttonNumber++, "id", getPackageName());
            Button button = (Button) findViewById(buttonResources);
             button.setText(ans);
        }

        correctAnswer = currentQuestion.getCorrectAnswers();
        currentQuestionIndex++;


    }

    /**
     *  disables and enables answers buttons
     * @param enableButtons
     */
    private void setButtonsEnable(boolean enableButtons) {
        System.out.println(enableButtons);

        for (int i = 1; i <= 4; i++) {
            int buttonResource = getResources().getIdentifier("answers" + i, "id", getPackageName());
            Button button = (Button) findViewById(buttonResource);
            button.setEnabled(enableButtons);
        }
    }

    /**
     * shows score in summary and hides in questions
     *
     * @param visibility
     */
    private void displayScore(int visibility) {
        TextView scoreText = (TextView) findViewById(R.id.score_display_box);
        scoreText.setText("Your score: " + score + " / " + questions.size());
        scoreText.setVisibility(visibility);

    }


    /**
     *
     * question summary
     *  this is the View for the answers choices listed
     * @param view
     *
     *
     */

    public void submitDisplayNextQuestion(View view) {
    setButtonsEnable(true);
    if (currentQuestionIndex == questions.size()) {
        turnOffQuestionViewVisibility();
        displayScore(View.VISIBLE);
        displayNextQuestionAndReplayAgainVisibilityMode();
    } else {
        TextView answersInfo = (TextView) findViewById(R.id.answerInfoDisplay);
        answersInfo.setVisibility(View.VISIBLE);
        toggleQuestion();
    }


}


/**
 *
 *Score message in the e-mail
 * @param addMr
 * @param name
 * @param addMrs
 * @param score
 *
 */
public String createOrderSummary (String name,int score, boolean addMr, boolean addMrs){
    String scoreMessage = "Name: " + name;
    scoreMessage = scoreMessage + "\n" + "My Score " + score;
    scoreMessage = scoreMessage + "\n" + "Title" + addMr + name;
    scoreMessage = scoreMessage + "\n" + "Title" + addMrs + name;
    scoreMessage = scoreMessage + "\n" + "Thanks!";
    return scoreMessage;
}



/**
 * Submit Share Button
 */

public void submitShare (View view) {
    //This gets the name name of the TextField and store it as String
    EditText textNameFieldBox = (EditText) findViewById(R.id.name_text_field);
    String name = textNameFieldBox.getText().toString();

    //This checkBox check the user status
    CheckBox hasMr = (CheckBox) findViewById(R.id.title_name1);
    boolean hasMrChecked = hasMr.isChecked();

    //This checkBox the user status
    CheckBox hasMrs = (CheckBox) findViewById(R.id.title_name2);
    boolean hasMrsChecked = hasMrs.isChecked();

    String scoreMessage = createOrderSummary(name,score,hasMrChecked,hasMrsChecked);



    //This will sent an E-mail with the results
    Intent intent = new Intent(Intent.ACTION_SENDTO);
    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
    intent.putExtra(Intent.EXTRA_SUBJECT, "Hey, Check out my score " + name);
    intent.putExtra(Intent.EXTRA_TEXT, "My Result " + scoreMessage);
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }

}



/**
 *
 *
 * Displays the next question, rePlayAgain option and also the quiz summary
 *
 */
private void displayNextQuestionAndReplayAgainVisibilityMode(){
    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
    Button nextQuestionButton  = (Button) findViewById(R.id.submitQuestion);
    Button shareButton = (Button) findViewById(R.id.share_button);
    EditText nameField = (EditText) findViewById(R.id.name_text_field);
    CheckBox titleName1 = (CheckBox) findViewById(R.id.title_name1);
    CheckBox titleName2 = (CheckBox) findViewById(R.id.title_name2);

    if (questionModeIsOn) {

        playAgainButton.setVisibility(View.VISIBLE);
        nextQuestionButton.setVisibility(View.VISIBLE);
        shareButton.setVisibility(View.VISIBLE);
        nameField.setVisibility(View.VISIBLE);
        titleName1.setVisibility(View.VISIBLE);
        titleName2.setVisibility(View.VISIBLE);
        questionModeIsOn = false;


    } else {

        playAgainButton.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.VISIBLE);
        shareButton.setVisibility(View.INVISIBLE);
        nameField.setVisibility(View.INVISIBLE);
        titleName1.setVisibility(View.INVISIBLE);
        titleName2.setVisibility(View.INVISIBLE);
        questionModeIsOn = true;

    }

}
    /**
     *
     * changes question content visibility box
     *
     * @param visibility
     */
    private void toggleQuestionVisibility(int visibility) {
        TextView questionContent = (TextView) findViewById(R.id.MainQuestionGrid);
        questionContent.setVisibility(visibility);
    }



    /**
     *
     *
     * turns off question and answers and answerInfo box before summary is on
     *
     *
     */

    private void turnOffQuestionViewVisibility() {
        toggleQuestionVisibility(View.GONE);
        toggleAnswerInfoVisibility(View.GONE);
        toggleAnswerButtonsVisibility(View.GONE);
    }

    /**
     * changes AnswerInfo button visibility
     *
     * @param visibility
     */
    private void toggleAnswerInfoVisibility(int visibility) {
        TextView answerInfo = (TextView) findViewById(R.id.answerInfoDisplay);
        answerInfo.setVisibility(visibility);
    }

    /**
     * changes Answer buttons visibility
     *
     * @param visibility
     */
    private void toggleAnswerButtonsVisibility(int visibility) {
        Button button;
        for (int i = 1; i <= 4; i++) {
            int buttonResource = getResources().getIdentifier("answers" + i, "id", getPackageName());
            button = (Button) findViewById(buttonResource);
            button.setVisibility(visibility);
        }
    }

    /**
     * This method will check the answers and display toast
     *
     * @param view
     */
    public void answerHintQuestion(View view) {
        setButtonsEnable(false);
        boolean correct = checkAnswer(view);
        TextView answerInfo = (TextView) findViewById(R.id.answerInfoDisplay);
        TextView scoreBackGroundColor = (TextView) findViewById(R.id.Score_summary);
        answerInfo.setVisibility(View.VISIBLE);


        if (correct) {
            answerInfo.setText("Correct answer");
            answerInfo.setBackgroundColor(Color.parseColor("#ff9800"));
            scoreBackGroundColor.setBackgroundColor(Color.parseColor("#ff9800"));
            score++;
        } else {
            answerInfo.setText("Incorrect answer");
            answerInfo.setBackgroundColor(Color.parseColor("#d84315"));
            scoreBackGroundColor.setBackgroundColor(Color.parseColor("#d84315"));
        }


        //This takes care of displaying the score in the action bar.
            TextView scoreView = (TextView) findViewById(R.id.Score_summary);
            scoreView.setText(String.valueOf(score));




        Toast.makeText(this, "Your score " + score + " / " + questions.size(), Toast.LENGTH_SHORT).show();


    }


    /**
     * This method will check if the answer is correct
     *
     * @param view
     * @return
     */
    private boolean checkAnswer(View view) {
        String tag = (String) view.getTag();

        Integer intTag = Integer.parseInt(tag);
        if (intTag.equals(correctAnswer)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * resets variables values and views visibilities for new game
     *
     * @param view
     */
    public void PlayAgain(View view) {
        resetQuiz();
        initializeQuiz();
        toggleAnswerButtonsVisibility(View.VISIBLE);
        toggleAnswerInfoVisibility(View.INVISIBLE);
        toggleQuestionVisibility(View.VISIBLE);
        displayScore(View.GONE);
        displayNextQuestionAndReplayAgainVisibilityMode();


    }


}
