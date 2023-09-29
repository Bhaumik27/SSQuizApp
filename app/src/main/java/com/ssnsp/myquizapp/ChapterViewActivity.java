package com.ssnsp.myquizapp;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChapterViewActivity extends AppCompatActivity {
    ListView listview;
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

        Intent i = getIntent();
        String toolbars6_1 = i.getStringExtra("Std6_1");
        String toolbars6_2 = i.getStringExtra("Std6_2");

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this, R.layout.chapter_list_row,R.id.chapter_row, tutorials);
        listview.setAdapter(arr);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(ChapterViewActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
