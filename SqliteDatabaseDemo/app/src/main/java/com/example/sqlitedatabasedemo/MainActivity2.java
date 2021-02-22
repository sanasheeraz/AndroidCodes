package com.example.sqlitedatabasedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    DatabaseHelper myDb;
    myAdapter adapter;
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
            byte[] img=result.getBlob(result.getColumnIndex("St_Image"));
            student.add(new Student(id,name,course,fees,img));
//            names.add(result.getString(result.getColumnIndex("St_Name")));
        }
//        ArrayAdapter array=new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        //listView.setAdapter(array);
        adapter=new myAdapter(this,student);
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
    public void deleteCall(final String id,final int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);
        alertDialog.setMessage("Are You sure to delete the record");
        alertDialog.setTitle("Alert!");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean result=myDb.delete(Integer.parseInt(id));
                if(result)
                {
                    adapter.remove(adapter.getItem(position));
                    Toast.makeText(MainActivity2.this,"Data Deleted",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity2.this,"Data Not deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = alertDialog.create();
        dialog.show();

    }
    public void editCall(String id,int position){
        boolean result=myDb.delete(Integer.parseInt(id));
        if(result)
        {
            adapter.remove(adapter.getItem(position));
            Toast.makeText(MainActivity2.this,"Data Deleted",Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(MainActivity2.this,"Data Not deleted",Toast.LENGTH_LONG).show();
        }
    }
}