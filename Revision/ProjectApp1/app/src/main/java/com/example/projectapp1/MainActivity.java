package com.example.projectapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitBtn;
    EditText txtEdit;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitBtn=findViewById(R.id.btnSubmit);
        txtEdit=findViewById(R.id.edText);
        txtView=findViewById(R.id.txtMessage);
        submitBtn.setText("Ok");

//        View.OnClickListener btnClick=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "New Button Click", Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        submitBtn.setOnClickListener(btnClick);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result=txtEdit.getText().toString();
                txtView.setText(result);
                Toast.makeText(MainActivity.this, "New Button Click", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Demo(View view)
    {
        Toast.makeText(MainActivity.this,"Button Clicked",Toast.LENGTH_LONG).show();
    }
}
