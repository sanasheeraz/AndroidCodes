package com.example.sqlitedatabasedemo;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        final TextView txtId=rowView.findViewById(R.id.txtId);
        ImageView imgView=rowView.findViewById(R.id.imgView);
        TextView txtCourse=rowView.findViewById(R.id.txtCourse);
        TextView txtName=rowView.findViewById(R.id.txtName);
        TextView txtFees=rowView.findViewById(R.id.txtFees);
        final int abc=position;
        Button btnEdit=rowView.findViewById(R.id.btnEdit);
        Button btnDelete=rowView.findViewById(R.id.btnDelete);

        txtId.setText(String.valueOf(st.getId()));
        imgView.setImageBitmap(Utils.getImage(st.getStImage()));
        txtName.setText(st.getName());
        txtCourse.setText(st.getCourse());
        txtFees.setText(String.valueOf(st.getFees()));

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Update button click"+txtId.getText(), Toast.LENGTH_SHORT).show();
                if (context instanceof MainActivity2) {
                  ((MainActivity2) context).deleteCall(txtId.getText().toString(),abc);
                    notifyDataSetChanged();
                }
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof MainActivity2) {
                    ((MainActivity2) context).editCall(txtId.getText().toString(),abc);
                    notifyDataSetChanged();
                }
            }
        });

        return  rowView;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
