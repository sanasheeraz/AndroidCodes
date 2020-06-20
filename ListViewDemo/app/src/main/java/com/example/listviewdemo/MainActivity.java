package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lstView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstView=findViewById(R.id.listView1);
        String[] languages={"PHP","Python","MVC","Kotlin","Java","PHP","Python","MVC","Kotlin","Java","PHP","Python","MVC","Kotlin","Java","PHP","Python","MVC","Kotlin","Java"};
        final ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);
        lstView.setAdapter(adapter);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String select=adapter.getItem(position).toString();
//                Toast.makeText(getApplicationContext(),select,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("language",select);
                startActivity(intent);
            }
        });
    }
}