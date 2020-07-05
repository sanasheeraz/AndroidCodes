package com.example.activitylifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setText(getResources().getString(R.string.btn_logIn));
        Log.d("Life Cycle", "On Create Invoked");
    }

    protected void onStart()
    {
        super.onStart();
        Log.d("Life Cycle","On Start Invoked");
    }

    protected void onResume()
    {
        super.onResume();
        Log.d("Life Cycle","On Resume Invoked");
    }
    protected void onPause()
    {
        super.onPause();
        Log.d("Life Cycle","On Pause Invoked");
    }
    protected void onStop()
    {
        super.onStop();
        Log.d("Life Cycle","On Stop Invoked");
    }
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Life Cycle","On Destroy Invoked");
    }
}