package com.aptech.projectapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtResult=findViewById(R.id.txtResult);

        String data=getIntent().getExtras().getString("UserName");

        txtResult.setText(data);
    }
}
