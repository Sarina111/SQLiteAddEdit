package com.example.sarina.projectexample;

import com.example.sarina.projectexample.modal.Employee;

/**
 * Created by Sarina on 12/20/2016.
 */

public interface OnRecylerViewClickListener {
    void onRecycleItemClick(Employee mEmployee, int pos);
    void onRecycleViewItemLongClick(Employee mEmployee, int pos);
}
