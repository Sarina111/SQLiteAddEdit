package com.example.sarina.projectexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sarina.projectexample.adapter.EmployeeRVAdapter;
import com.example.sarina.projectexample.modal.Employee;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements OnRecylerViewClickListener, OnYesClickListener {

    RecyclerView mRecyclerView;
    public static final String KEY_EMPLOYEE = "employe";
    EmployeeRVAdapter mEmployeeRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Employee List");
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (manager != null) {
            Log.e("test", "i am here");
            ArrayList<Employee> employees = manager.fetchEmployeeList();
            mEmployeeRVAdapter = new EmployeeRVAdapter(this, employees);
            mEmployeeRVAdapter.setListener(this);
            mRecyclerView.setAdapter(mEmployeeRVAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragment_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuAdd) {
            Intent mIntent = new Intent(MainActivity.this, AddEditEmployeeActivity.class);
            startActivity(mIntent);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRecycleItemClick(Employee mEmployee, int pos) {
        Intent mIntent = new Intent(this, AddEditEmployeeActivity.class);
        mIntent.putExtra(KEY_EMPLOYEE, mEmployee);
        startActivity(mIntent);


    }

    @Override
    public void onRecycleViewItemLongClick(Employee mEmployee, int pos) {


        ConfirmDialog mConfirmDialog = new ConfirmDialog();
        Bundle mBundle=new Bundle();
        mBundle.putInt("id",mEmployee.getId());
        mBundle.putInt("pos",pos);
        mConfirmDialog.setArguments(mBundle);



        mConfirmDialog.setListener(this);
        mConfirmDialog.show(getSupportFragmentManager(),"Confirm Dialog");

    }

    @Override
    public void onYesClick(int id, int pos) {
        manager.deleteEmployee(id);
        mEmployeeRVAdapter.remove(pos);
    }
}
