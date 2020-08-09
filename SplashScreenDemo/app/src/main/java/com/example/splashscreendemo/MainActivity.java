package com.example.splashscreendemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread timer=new Thread()
        {
            public void run()
            {
                try {
                    sleep(5000);
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }finally {
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }

            }
        };
        timer.start();
    }
}