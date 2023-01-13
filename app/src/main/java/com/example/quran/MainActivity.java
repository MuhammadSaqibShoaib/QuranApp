package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] data;
    ListView listView;
    VerseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        // getting data from previous activity
        Intent intent = getIntent();
        data = intent.getStringArrayExtra("data");

        // taking refrence of listview
        listView = findViewById(R.id.MainList);

        adapter = new VerseAdapter(getApplicationContext(),data);
        listView.setAdapter(adapter);
        listView.smoothScrollToPosition(5);

    }
}