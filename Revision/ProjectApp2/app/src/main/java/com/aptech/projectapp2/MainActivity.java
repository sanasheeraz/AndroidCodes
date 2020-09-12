package com.aptech.projectapp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4;
    EditText edName;
    Button btnNext,btnUpload;
    String result;
    Uri selectedImageUri;
    ImageView imgView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 200) {
                selectedImageUri=data.getData();
                if (null != selectedImageUri) {
                    imgView.setImageURI(selectedImageUri);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btnClick1);
        btn2=findViewById(R.id.btnClick2);
        btn3=findViewById(R.id.btnClick3);
        btn4=findViewById(R.id.btnClick4);
        edName=findViewById(R.id.edName);
        btnUpload=findViewById(R.id.btnUpload);
        imgView=findViewById(R.id.imgView);

        btnNext=findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=edName.getText().toString();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("UserName",result);
                startActivity(intent);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 200);
            }
        });


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btnClick1:
                Toast.makeText(MainActivity.this,"Button 1 Clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnClick2:
                Toast.makeText(MainActivity.this,"Button 2 Clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnClick3:
                Toast.makeText(MainActivity.this,"Button 3 Clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnClick4:
                Toast.makeText(MainActivity.this,"Button 4 Clicked",Toast.LENGTH_LONG).show();
                break;
        }


    }
}
