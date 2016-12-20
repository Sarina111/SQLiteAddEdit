package com.example.sarina.projectexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sarina.projectexample.db.DBManager;

/**
 * Created by Sarina on 12/18/2016.
 */

public class BaseActivity extends AppCompatActivity {
    DBManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager=DBManager.NewInstance(this);
    }
}
