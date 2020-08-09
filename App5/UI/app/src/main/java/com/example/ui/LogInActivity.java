package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        button=findViewById(R.id.btnSubmit);
        editText=findViewById(R.id.edText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity();
            }
        });


    }
    public void OpenActivity()
    {
        Intent intent=new Intent(this,MainActivity3.class);
        intent.putExtra("text",editText.getText().toString());
        startActivity(intent);
    }
}