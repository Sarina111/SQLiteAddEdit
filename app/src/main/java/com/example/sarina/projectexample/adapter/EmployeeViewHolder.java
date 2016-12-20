package com.example.sarina.projectexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sarina.projectexample.R;

/**
 * Created by Sarina on 12/18/2016.
 */

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    TextView txtName;
    TextView txtAddress;
    TextView txtPhone;
    public EmployeeViewHolder(View itemView) {
        super(itemView);
        txtAddress=(TextView)itemView.findViewById(R.id.txtAddres);
        txtName=(TextView)itemView.findViewById(R.id.txtName);
        txtPhone=(TextView)itemView.findViewById(R.id.phone);
    }
}
