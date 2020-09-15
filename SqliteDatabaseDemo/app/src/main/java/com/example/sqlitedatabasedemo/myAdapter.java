package com.example.sqlitedatabasedemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class myAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private ArrayList<Student> arrayList;

    public myAdapter(@NonNull Activity context, ArrayList<Student> arrayList) {
       super(context,R.layout.activity_my_list_view,arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_my_list_view,null,true);
        Student st=arrayList.get(position);
        TextView txtId=rowView.findViewById(R.id.txtId);
        TextView txtCourse=rowView.findViewById(R.id.txtCourse);
        TextView txtName=rowView.findViewById(R.id.txtName);
        TextView txtFees=rowView.findViewById(R.id.txtFees);

        txtId.setText(String.valueOf(st.getId()));
        txtName.setText(st.getName());
        txtCourse.setText(st.getCourse());
        txtFees.setText(String.valueOf(st.getFees()));

        return  rowView;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
