package com.example.project1firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    EditText edId,edName,edDesig,edSalary;
    ListView lstView;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<Employee> empList;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edId=findViewById(R.id.edId);
        edName=findViewById(R.id.edName);
        edDesig=findViewById(R.id.edDesignation);
        edSalary=findViewById(R.id.edSalary);

        lstView=findViewById(R.id.lstView);
        empList=new ArrayList<Employee>();

        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Employee");

    }
    public void InsertData(View view)
    {
        int id=Integer.parseInt(edId.getText().toString());
        String name=edName.getText().toString();
        String designation=edDesig.getText().toString();
        int salary=Integer.parseInt(edSalary.getText().toString());

        final Employee employee=new Employee(id,name,designation,salary);

        myRef.child(edId.getText().toString()).setValue(employee).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity2.this,employee.getName()+" added successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void GetData(View view)
    {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Employee emp = postSnapshot.getValue(Employee.class);
                    empList.add(emp);
                }
                adapter=new CustomAdapter(MainActivity2.this,empList);
                lstView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}