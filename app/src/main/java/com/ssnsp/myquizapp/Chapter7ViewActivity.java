package com.ssnsp.myquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Chapter7ViewActivity extends AppCompatActivity {
    ListView listview;
    Toolbar toolbar;
    String tutorials[]
            = { "1. Algorithms", "2. Data Structures",
            "3. Languages", "4. Interview Corner",
            "5. GATE", "6. ISRO CS",
            "7. UGC NET CS", "8. CS Subjects",
            "9. Web Technologies" };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_view_activity);
        listview = findViewById(R.id.chapterlist);
        toolbar = findViewById(R.id.toolbar);

        Intent i = getIntent();
        String toolbarstd = i.getStringExtra("std");
        toolbar.setTitle(toolbarstd);

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this, R.layout.chapter_list_row,R.id.chapter_row, tutorials);
        listview.setAdapter(arr);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(Chapter7ViewActivity.this, std7.class);
                startActivity(intent);
            }
        });
    }
}
