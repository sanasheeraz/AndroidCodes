package com.example.demofragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment1 f1=(Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragmentOne);
        Fragment2 f2=(Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragmentTwo);
        Fragment3 f3=(Fragment3) getSupportFragmentManager().findFragmentById(R.id.fragmentThree);
        btnNext=findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}