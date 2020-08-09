package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        EditText edtxt=findViewById(R.id.edName);
        String name=edtxt.getText().toString();
        //String message="Welcome "+name;
        //Toast.makeText(MainActivity.this,"Welcome "+name,Toast.LENGTH_LONG).show();
        TextView txt=findViewById(R.id.txtResult);
        txt.setText("Welcome "+name+" ! ");
    }
}