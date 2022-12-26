package com.example.quran;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class VerseAdapter  extends BaseAdapter
{
    Context context;
    String[] Verses;
    LayoutInflater inflater;
    public VerseAdapter(Context context, String[] Verses){
        Log.d("Loaded", "CustomAdaptor: creating");
        this.context = context;
        this.Verses = Verses;
        //Log.d("Loaded", "VerseAdapter: "+this.eng_names[0]);
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return Verses.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        convertView = inflater.inflate(R.layout.verse_view,null);
        //Log.d("para", "reached");
        TextView verse_view = convertView.findViewById(R.id.verseView);
        verse_view.setText(Verses[position]);


        return convertView;
    }
}
