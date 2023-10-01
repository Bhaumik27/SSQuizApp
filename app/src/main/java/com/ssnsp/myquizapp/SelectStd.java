package com.ssnsp.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ssnsp.myquizapp.R;

public class SelectStd extends AppCompatActivity {

    private Button btn6_1;
    private Button btn6_2;
    private Button btn7_1;
    private Button btn7_2;
    private Button btn8_1;
    private Button btn8_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_std);

        btn6_1 = findViewById(R.id.btn6_1);
        btn6_2 = findViewById(R.id.btn6_2);
        btn7_1 = findViewById(R.id.btn7_1);
        btn7_2 = findViewById(R.id.btn7_2);
        btn8_1 = findViewById(R.id.btn8_1);
        btn8_2 = findViewById(R.id.btn8_2);

        btn6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(SelectStd.this,SecondActivity.class);
                startActivity(intent);*/

                Intent intent = new Intent(SelectStd.this,ChapterViewActivity.class);
                intent.putExtra("std", "Std 6 Sem-1");
                startActivity(intent);
            }
        });
        btn6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(SelectStd.this,SecondActivity.class);
                startActivity(intent);*/

                Intent intent = new Intent(SelectStd.this,ChapterViewActivity.class);
                intent.putExtra("std", "Std 6 Sem-2");
                startActivity(intent);
            }
        });

        btn7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectStd.this,ChapterViewActivity.class);
                intent.putExtra("std", "Std 7 Sem-1");
                startActivity(intent);
            }
        });
        btn7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectStd.this,ChapterViewActivity.class);
                intent.putExtra("std", "Std 7 Sem-2");
                startActivity(intent);
            }
        });

        btn8_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectStd.this,ChapterViewActivity.class);
                intent.putExtra("std", "Std 8 Sem-1");
                startActivity(intent);
            }
        });
        btn8_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectStd.this,ChapterViewActivity.class);
                intent.putExtra("std", "Std 8 Sem-2");
                startActivity(intent);
            }
        });

    }
}