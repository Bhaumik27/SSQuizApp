package com.ssnsp.myquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FinalResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuizResultAdapter quizResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Question> quizResults = new ArrayList<>();

        quizResultAdapter = new QuizResultAdapter(quizResults);
        recyclerView.setAdapter(quizResultAdapter);

    }
}