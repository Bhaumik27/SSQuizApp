package com.ssnsp.myquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FinalResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuizResultAdapter quizResultAdapter;
    private TextView correct_ans;
    private TextView wrong_ans;
    private TextView total_marks;
    private Button btnRestart;
    private List<Question> questionsList = new ArrayList<>();
    String correctans;
    private int currentQuestionIndex = 0;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

        Intent i = getIntent();
        questionsList = (List<Question>) i.getSerializableExtra("QuestionList");
        correctans = i.getSerializableExtra("CorrectCount").toString();

        btnRestart = findViewById(R.id.btnRestart);
        total_marks = findViewById(R.id.total_marks);
        correct_ans = findViewById(R.id.correct_ans);
        wrong_ans = findViewById(R.id.wrong_ans);
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //List<Question> quizResults = new ArrayList<>();
        quizResultAdapter = new QuizResultAdapter(questionsList,getApplicationContext());
        recyclerView.setAdapter(quizResultAdapter);

        correct_ans.setText("Correct Answer: " +correctans);
        totalQuestion();
        wrongAnswer();

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalResultActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    @SuppressLint("SetTextI18n")
    private void totalQuestion() {
        int quizResultItem = questionsList.size();
        total_marks.setText("Total Marks: "+String.valueOf(quizResultItem));
    }

    private void wrongAnswer() {
        int quizResultItem = questionsList.size();
        int totalmarks = quizResultItem;
        int correct_ans = Integer.valueOf(correctans);

        int Total = totalmarks - correct_ans;
        if(Total <= 10){
            wrong_ans.setText("Wrong Answer: 0"+String.valueOf(Total));
        }
    }
}