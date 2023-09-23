package com.ssnsp.myquizapp;

import android.os.Bundle;
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

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this, R.layout.chapter_list_row,R.id.chapter_row, tutorials);
        listview.setAdapter(arr);
    }
}
