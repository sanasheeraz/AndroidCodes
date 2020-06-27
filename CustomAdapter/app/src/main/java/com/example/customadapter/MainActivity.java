package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lstView1);
        String[] MainText={"Asad Khan","Muhammad Abdullah","Hunain Ali","Hassan Khan","Ahmed"};
        String[] SubText={"03111111","03111111","03111111","03111111","03111111"};
        Integer[] Images={R.drawable.download1,R.drawable.download2,R.drawable.download3,R.drawable.download4,R.drawable.download5};

        myListAdapter myadapter=new myListAdapter(this,MainText,SubText,Images);
        listView.setAdapter(myadapter);
    }
}