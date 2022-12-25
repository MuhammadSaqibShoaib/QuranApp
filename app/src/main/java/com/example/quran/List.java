package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class List extends AppCompatActivity {
    String[] surah_list;
    String[] para_list;
    ListView list;
    ArrayAdapter<String> adapter;
    QDH qdh = new QDH();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();

        // getting list of parah

        para_list = qdh.ParahName;
        Log.d("Loaded", para_list[0]);

        //getting list view
        list = findViewById(R.id.list);
        //making adapter active
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, para_list);
        list.setAdapter(adapter);
    }
}