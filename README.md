



	# QuizApp
Android QuizApp
This is an Android app written in Java and the layout was written in XML, if you are interested to learn more about the Layouts please read here
https://developer.android.com/guide/topics/ui/declaring-layout
The applications should contain 5 main working files.
#1
activity_main.xml - it contains the main layout of the android application.
#2
colors.xml - in this file you basically can change the colors of the Action bar, Progress bar etc. If you are interested, you can play and read more here
https://developer.android.com/guide/topics/resources/more-resources
#3 MainActivity.java - This is where the magic happens. You should see the following imports.
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


#4
QuestionsFeeder.java - This is feeding the questions from the ArrayList.

#5
Question.java - The main question body, here the questions also get verified too



