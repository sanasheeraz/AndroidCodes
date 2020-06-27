package com.example.customadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.customadapter.R;

public class myListAdapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] MainText;
    private final String[] SubText;
    private final Integer[] Images;

    public myListAdapter(Activity context, String[] mainText, String[] subText, Integer[] images) {
        super(context, R.layout.activity_my_list_view, mainText);
        this.context = context;
        this.MainText = mainText;
        this.SubText = subText;
        this.Images = images;
    }
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_my_list_view,null,true);
        TextView textView1=rowView.findViewById(R.id.MainText);
        TextView textView2=rowView.findViewById(R.id.SubText);
        ImageView imageView=rowView.findViewById(R.id.img);

        textView1.setText(MainText[position]);
        textView2.setText(SubText[position]);
        imageView.setImageResource(Images[position]);
        return  rowView;
    }
}
