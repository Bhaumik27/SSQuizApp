package com.ssnsp.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ssnsp.myquizapp.R;

public class SelectStd extends AppCompatActivity {

    private Button btn6_1;
    private Button btn7_1;
    private Button btn8_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_std);

        btn6_1 = findViewById(R.id.btn6_1);
        btn7_1 = findViewById(R.id.btn7_1);
        btn8_1 = findViewById(R.id.btn8_1);

        btn6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(SelectStd.this,SecondActivity.class);
                startActivity(intent);*/

                Intent intent = new Intent(SelectStd.this,ChapterViewActivity.class);
                startActivity(intent);
            }
        });

        btn7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectStd.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        btn8_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectStd.this,SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}