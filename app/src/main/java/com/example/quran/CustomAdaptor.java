package com.example.quran;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintSet;

public class CustomAdaptor extends BaseAdapter {
    Context context;
    String[] eng_names;
    String[] arabic_names;
    LayoutInflater inflater;
    public CustomAdaptor(Context context, String[] eng_names, String[] arabic_names){
        Log.d("Loaded", "CustomAdaptor: creating");
        this.context = context;
        this.eng_names = eng_names;
        this.arabic_names = arabic_names;
        Log.d("Loaded", "CustomAdaptor: "+this.eng_names[0]);
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return eng_names.length;
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


        convertView = inflater.inflate(R.layout.list_view,null);
        Log.d("para", "reached");
        TextView eng_name = convertView.findViewById(R.id.eng_name);
        TextView arabic_name = convertView.findViewById(R.id.arabic_name);
        eng_name.setText(eng_names[position]);
        arabic_name.setText(arabic_names[position]);

        return convertView;
    }
}
