package com.ssnsp.myquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FinalResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuizResultAdapter quizResultAdapter;
    private Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

        btnRestart = findViewById(R.id.btnRestart);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Question> quizResults = new ArrayList<>();

        quizResultAdapter = new QuizResultAdapter(quizResults);
        recyclerView.setAdapter(quizResultAdapter);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalResultActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}