package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class List extends AppCompatActivity {
    String[] eng_surah_list;
    String[] arabic_surah_list;
    String[] eng_para_list;
    String[] arabic_para_list;
    ListView list;
    CustomAdaptor adaptor;
    Button para_btn, surah_btn;
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
        para_btn = findViewById(R.id.para_button);
        surah_btn = findViewById(R.id.surah_btn);
        //making adapter active

        adaptor = new CustomAdaptor(getApplicationContext(),eng_para_list,arabic_para_list);
        list.setAdapter(adaptor);

        // listeners
        para_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickParah();
            }
        });

        surah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickSurah();
            }
        });
    }

    public void OnClickParah(){
        Log.d("Loaded", "OnClickParah: ");
        adaptor.SetData(eng_para_list,arabic_para_list);
        adaptor.notifyDataSetChanged();
    }
    public void OnClickSurah(){
        Log.d("Loaded", "OnClickSurah: ");
        adaptor.SetData(eng_surah_list,arabic_surah_list);
        adaptor.notifyDataSetChanged();
    }
}