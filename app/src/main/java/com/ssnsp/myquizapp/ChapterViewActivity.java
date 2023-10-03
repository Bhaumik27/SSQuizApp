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

import java.util.HashMap;
import java.util.Map;

public class ChapterViewActivity extends AppCompatActivity {
    ListView listView;
    Toolbar toolbar;

    String tutorials[]
            = { "1. ઈતિહાસ જાણવાના સ્ત્રોત",
            "2. આદિમાનવના સ્થાયી જીવનની શરૂઆત",
            "3. પ્રાચીન નગરો અને ગ્રંથો",
            "4. ભારતની પ્રારંભિક રાજ્યવ્યવસ્થા"};

    // Define a mapping between list elements and their corresponding classes
    private Map<String, Class<?>> classMapping = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_view_activity);
        listView = findViewById(R.id.chapterlist);
        toolbar = findViewById(R.id.toolbar);

        // Populate the mapping with class names
        classMapping.put("1. ઈતિહાસ જાણવાના સ્ત્રોત", SecondActivity.class);
        classMapping.put("2. આદિમાનવના સ્થાયી જીવનની શરૂઆત", std6_ch2.class);
        classMapping.put("3. પ્રાચીન નગરો અને ગ્રંથો", std6_ch3.class);
        classMapping.put("4. ભારતની પ્રારંભિક રાજ્યવ્યવસ્થા", std6_ch4.class);

        Intent i = getIntent();
        String toolbarText = i.getStringExtra("std");
        toolbar.setTitle(toolbarText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.chapter_list_row, R.id.chapter_row, tutorials);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text
                String selectedItem = tutorials[position];

                // Get the corresponding class from the mapping
                Class<?> targetClass = classMapping.get(selectedItem);

                if (targetClass != null) {
                    // Launch the selected class
                    Intent intent = new Intent(ChapterViewActivity.this, targetClass);
                    startActivity(intent);
                }
            }
        });
    }
}
