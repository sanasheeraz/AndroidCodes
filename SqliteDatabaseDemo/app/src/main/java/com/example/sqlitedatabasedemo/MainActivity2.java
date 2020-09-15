package com.example.sqlitedatabasedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listView);
        myDb=new DatabaseHelper(this);
        //String[] country={"Pakistan","Russia","China"};
        Cursor result=myDb.getAllData();
//        ArrayList<String> names=new ArrayList<String>();
        ArrayList<Student> student=new ArrayList<Student>();
        if(result.getCount()==0)
        {
            showMessage("Error ","Nothing to display");
            return;
        }
        while(result.moveToNext())
        {
            int id=result.getInt(result.getColumnIndex("St_Id"));
            int fees=result.getInt(result.getColumnIndex("St_Fees"));

            String name=result.getString(result.getColumnIndex("St_Name"));
            String course=result.getString(result.getColumnIndex("St_Course"));
            student.add(new Student(id,name,course,fees));
//            names.add(result.getString(result.getColumnIndex("St_Name")));
        }
//        ArrayAdapter array=new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        //listView.setAdapter(array);
        myAdapter adapter=new myAdapter(this,student);
        listView.setAdapter(adapter);
    }
    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(true);
        builder.setMessage(Message);
        builder.show();
    }
}