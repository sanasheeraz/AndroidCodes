package com.example.shareddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edId ,edName;
    Button saveBtn , displayBtn;
    TextView txtResult;
    SharedPreferences sharedPreferences;
    public static int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edId=findViewById(R.id.edId);
        edName=findViewById(R.id.edName);
        txtResult=findViewById(R.id.txtResult);

        saveBtn=findViewById(R.id.btnSave);
        displayBtn=findViewById(R.id.btnDisplay);
        sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();

                String IDKey="Id"+count;
                String NameKey="Name"+count;

                editor.putString(IDKey,edId.getText().toString());
                editor.putString(NameKey,edName.getText().toString());
                editor.commit();

                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                count++;
            }
        });

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=1;
                String result="";
                while(i<=count)
                {
                    String IdKey="Id"+i;
                    String NameKey="Name"+i;
                   result+="\nId : "+sharedPreferences.getString(IdKey,"")+" Name : "+sharedPreferences.getString(NameKey,"") ;
                    i++;
                }
//               String Id= sharedPreferences.getString("Id","");
//                String Name= sharedPreferences.getString("Name","");
txtResult.setText(result);
            }
        });

    }
}