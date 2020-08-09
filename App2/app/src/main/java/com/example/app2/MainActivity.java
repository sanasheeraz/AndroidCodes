package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtxtDollar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxtDollar= findViewById(R.id.edDollar);
    }

    public void CnvrtRupee(View view)
    {
       Double dollar=Double.parseDouble(edtxtDollar.getText().toString());
       Double rupees=dollar*164.18;
       String message="Dollar "+dollar+" = "+rupees+" rupees";
       EditText edtxtRupee=findViewById(R.id.edRupeeAmount);
       edtxtRupee.setText(rupees.toString());
       //Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}