package com.example.sarina.projectexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Sarina on 12/20/2016.
 */

public class ConfirmDialog extends DialogFragment implements View.OnClickListener {
    int id;
    int pos;
    Button btnYes;
    Button btnNo;
    private OnYesClickListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.confirm_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNo = (Button) view.findViewById(R.id.btnNO);
        btnYes = (Button) view.findViewById(R.id.btnYes);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        id=getArguments().getInt("id");
        pos=getArguments().getInt("pos");
    }

    public void setListener(OnYesClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnNO) {
            dismiss();

        } else {
            if (mListener != null) {
                dismiss();
                mListener.onYesClick(id,pos);
            }

        }

    }
}
