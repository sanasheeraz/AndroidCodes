package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EdUser;
    EditText EdPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdUser=findViewById(R.id.edUserName);
        EdPassword=findViewById(R.id.edPassword);
    }
    public void OpenActivity(View view)
    {
        String userName=EdUser.getText().toString();
        String password=EdPassword.getText().toString();
        if(userName.equals("Admin")&& password.equals("123"))
        {
            Intent intent=new Intent(this,LogInActivity.class);
            startActivity(intent);
        }else
        {
            Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }

}