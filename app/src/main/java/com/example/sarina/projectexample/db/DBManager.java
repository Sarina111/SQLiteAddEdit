package com.example.sarina.projectexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sarina.projectexample.modal.Employee;

import java.util.ArrayList;

/**
 * Created by Sarina on 12/15/2016.
 */

public class DBManager {

    private static DBManager DB_MANAGER;
    private Context context;
    private SQLiteDatabase mSQLiteDatabase;

    private DBManager(Context context) {
        DataBaseHelper mDataBaseHelper = new DataBaseHelper(context);
        this.context = context;
        mSQLiteDatabase = mDataBaseHelper.getWritableDatabase();


    }

    public static DBManager NewInstance(Context context) {
        if (DB_MANAGER == null) {
            DB_MANAGER = new DBManager(context);
        }
        return DB_MANAGER;

    }

    public void insertEmployee(String name, String address, String phone) {

        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.NAME, name);
        cv.put(DataBaseHelper.ADDRESS, address);
        cv.put(DataBaseHelper.PHONE, phone);
        mSQLiteDatabase.insert(DataBaseHelper.TBL_EMPLOYEE, null, cv);

        // another option
       /* String query="insert into tbl_contact(contact_name,contact-address,contact_gender)values("+name+","+address","+gender";
        mSQLiteDatabase.rawQuery(query,null);*/

    }


    public ArrayList<Employee> fetchEmployeeList() {
        String query = "SELECT * FROM " + DataBaseHelper.TBL_EMPLOYEE;
        ArrayList<Employee> employees = new ArrayList<>();
        Cursor mCursor = mSQLiteDatabase.rawQuery(query, null);
        while (mCursor.moveToNext()) {

            String name = mCursor.getString(mCursor.getColumnIndex(DataBaseHelper.NAME));
            String address = mCursor.getString(mCursor.getColumnIndex(DataBaseHelper.ADDRESS));
            String phone = mCursor.getString(mCursor.getColumnIndex(DataBaseHelper.PHONE));
            int id = mCursor.getInt(mCursor.getColumnIndex("id"));
            Employee mEmployee = new Employee(name, address, phone);
            mEmployee.setId(id);
            employees.add(mEmployee);
        }

        return employees;
    }


    public void updateEmlpoyee(int id, String name, String address, String phone) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.NAME, name);
        cv.put(DataBaseHelper.ADDRESS, address);
        cv.put(DataBaseHelper.PHONE, phone);
        String where = " id = ?";
        mSQLiteDatabase.update(DataBaseHelper.TBL_EMPLOYEE, cv, where, new String[]{id + ""});
       /* String query = "Update " + DataBaseHelper.TBL_EMPLOYEE
                + " set " + DataBaseHelper.NAME + " = " + name
                + " where id = " + id;

        mSQLiteDatabase.rawQuery(query,null);*/


    }

    public void deleteEmployee(int id) {
        String where = " id = ?";
        mSQLiteDatabase.delete(DataBaseHelper.TBL_EMPLOYEE, where, new String[]{id + ""});
    }
}
