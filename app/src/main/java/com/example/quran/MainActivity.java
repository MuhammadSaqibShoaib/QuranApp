package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] data;
    ListView listView;

    TextView txt_heading;
    EditText search_txt;
    Button searchBtn;

    VerseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        txt_heading = findViewById(R.id.txt_heading);
        search_txt = findViewById(R.id.num_txt);
        searchBtn = findViewById(R.id.search_btn);

        // getting data from previous activity
        Intent intent = getIntent();
        data = intent.getStringArrayExtra("data");
        txt_heading.setText(intent.getStringExtra("heading"));

        // taking refrence of listview
        listView = findViewById(R.id.MainList);

        adapter = new VerseAdapter(getApplicationContext(),data);
        listView.setAdapter(adapter);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Loaded", "Search button working");
                String txt = search_txt.getText().toString();
                Log.d("Loaded", "String text: "+txt);
                int position = Integer.parseInt(txt);
                Log.d("Loaded", "Position: "+position);
                if (position > 0 && position < data.length)
                    listView.setSelection(position);
                else{
                    Toast.makeText(getApplicationContext(),R.string.verse_error,Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}