package com.example.sarina.projectexample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sarina on 12/15/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_EMPLOYEE = "db_employee";
    private static int version = 1;

    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";
    public static final String TBL_EMPLOYEE = "tbl_employee";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TBL_EMPLOYEE + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " TEXT,"
            + ADDRESS + " TEXT,"
            + PHONE + " TEXT)";


    public DataBaseHelper(Context context) {
        super(context, DB_EMPLOYEE, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        //db.execSQL();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
