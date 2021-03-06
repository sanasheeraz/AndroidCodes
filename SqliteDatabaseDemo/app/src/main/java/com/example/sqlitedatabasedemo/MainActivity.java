package com.example.sqlitedatabasedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    EditText txtName,txtCourse,txtFees,txtId;
    Button btnAdd,btnUpdate,btnDelete,btnView,uploadImg;
    DatabaseHelper myDb;
    byte[] imgData;
    Uri ImageUri;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==200)
       {
           if(resultCode==RESULT_OK)
           {
               ImageUri=data.getData();
           }
       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb=new DatabaseHelper(this);
        txtId=findViewById(R.id.txtId);
        txtName=findViewById(R.id.txtName);
        txtCourse=findViewById(R.id.txtCourse);
        txtFees=findViewById(R.id.txtFees);
        btnAdd=findViewById(R.id.btnAdd);
        btnView=findViewById(R.id.btnView);
        btnDelete=findViewById(R.id.btnDelete);
        btnUpdate=findViewById(R.id.btnUpdate);
        uploadImg=findViewById(R.id.uploadImg);

        uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),200);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream input=getContentResolver().openInputStream(ImageUri);

                imgData=Utils.getBytes(input);
                boolean result=myDb.insertData(txtName.getText().toString(),txtCourse.getText().toString(),Integer.parseInt(txtFees.getText().toString()),imgData);
                if(result)
                {
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);

                startActivity(intent);
//                Cursor result=myDb.getAllData();
//                if(result.getCount()==0)
//                {
//                    showMessage("Error ","Nothing to display");
//                    return;
//                }
//                StringBuffer buffer=new StringBuffer();
//                while(result.moveToNext())
//                {
//                    buffer.append("Id : "+result.getString(0)+"\n");
//                    buffer.append("Name : "+result.getString(1)+"\n");
//                    buffer.append("Course : "+result.getString(2)+"\n");
//                    buffer.append("Fees : "+result.getString(3)+"\n\n");
//                }
//                showMessage("Student's Data",buffer.toString());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=myDb.updateData(Integer.parseInt(txtId.getText().toString()),txtName.getText().toString(),txtCourse.getText().toString(),Integer.parseInt(txtFees.getText().toString()));
                if(result)
                {
                    Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"Data Not Updated",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=myDb.delete(Integer.parseInt(txtId.getText().toString()));
                if(result)
                {
                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"Data Not deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(true);
        builder.setMessage(Message);
        builder.show();
    }
}