package com.example.sarina.projectexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarina.projectexample.db.DBManager;
import com.example.sarina.projectexample.modal.Employee;

/**
 * Created by Sarina on 12/18/2016.
 */

public class AddEditEmployeeActivity extends BaseActivity implements View.OnClickListener {
    EditText etName;
    EditText etAddress;
    EditText etPhone;
    Button btnSave;
    Employee mEmployee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
         mEmployee= (Employee) getIntent().getSerializableExtra(MainActivity.KEY_EMPLOYEE);
        init();
        if(mEmployee!=null){
            etName.setText(mEmployee.getName());
            etAddress.setText(mEmployee.getAddress());
            etPhone.setText(mEmployee.getPhone());
            btnSave.setText("Update");
        }
    }

    private void init(){
        etName=(EditText)findViewById(R.id.etName);
        etAddress=(EditText)findViewById(R.id.etAddress);
        etPhone=(EditText)findViewById(R.id.etPhone);
        btnSave=(Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(isFromValid()){
            String name=etName.getText().toString();
            String address=etAddress.getText().toString();
            String phone=etPhone.getText().toString();
            if(mEmployee==null) {
                manager.insertEmployee(name, address, phone);
            }else {
                Toast.makeText(AddEditEmployeeActivity.this,"Update operation",Toast.LENGTH_SHORT).show();
                manager.updateEmlpoyee(mEmployee.getId(),name,address,phone);
            }
            finish();
        }

    }


    private boolean isFromValid(){
        if(etName.getText().toString().trim().length()<1){
            etName.setError("Name can't be empty");
            return false;
        }
        if(etAddress.getText().toString().trim().length()<1){
            etAddress.setError("Address can't be empty");
            return false;
        }
        if(etPhone.getText().toString().trim().length()<1){
            etPhone.setError("Phone can't be empty");
            return false;
        }

        return true;

    }



}
