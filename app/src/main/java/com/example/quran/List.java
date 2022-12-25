package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class List extends AppCompatActivity {
    String[] eng_surah_list;
    String[] arabic_surah_list;
    String[] eng_para_list;
    String[] arabic_para_list;
    ListView list;

    //ArrayAdapter<String> adapter;
    QDH qdh = new QDH();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();

        // getting list of parah
        arabic_para_list = qdh.ParahName;
        eng_para_list = qdh.englishParahName;
        Log.d("Loaded", arabic_para_list[0]);
        //getting lists of surah
        eng_surah_list = qdh.englishSurahNames;
        arabic_surah_list = qdh.urduSurahNames;
        Log.d("Loaded", arabic_surah_list[0]);
        //Log.d("Loaded", arabic_para_list[0]);

        //getting list view
        list = findViewById(R.id.list);
        //making adapter active

        CustomAdaptor adaptor = new CustomAdaptor(getApplicationContext(),eng_para_list,arabic_para_list);
        list.setAdapter(adaptor);
    }

    public void OnClickParah(){
        CustomAdaptor adaptor = new CustomAdaptor(getApplicationContext(),eng_para_list,arabic_para_list);
        list.setAdapter(adaptor);
    }
    public void OnClickSurah(){
        CustomAdaptor adaptor = new CustomAdaptor(getApplicationContext(),eng_surah_list,arabic_surah_list);
        list.setAdapter(adaptor);
    }
}