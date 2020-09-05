package com.example.project1firebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Employee> {
    public Activity context;
    public ArrayList<Employee> EmployeeList;

    public CustomAdapter(@NonNull Activity context, ArrayList<Employee> empList) {
        super(context, R.layout.activity_mylist_items);
        this.context = context;
        this.EmployeeList = empList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_mylist_items, null, true);

        TextView txtId = rowView.findViewById(R.id.txtId);
        TextView txtName = rowView.findViewById(R.id.txtName);
        TextView txtDesig = rowView.findViewById(R.id.txtDesig);
        TextView txtSalary = rowView.findViewById(R.id.txtSalary);

        Employee emp = EmployeeList.get(position);
        txtId.setText(String.valueOf(emp.getId()));
        txtName.setText(emp.getName());
        txtDesig.setText(emp.getDesgination());
        txtSalary.setText(String.valueOf(emp.getSalary()));

        return rowView;
    }

    @Override
    public int getCount() {
        return EmployeeList.size();
    }
}