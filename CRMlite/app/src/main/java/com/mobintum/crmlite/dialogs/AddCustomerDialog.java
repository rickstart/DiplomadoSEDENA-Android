package com.mobintum.crmlite.dialogs;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.iangclifton.android.floatlabel.FloatLabel;
import com.mobintum.crmlite.R;

/**
 * Created by Rick on 07/05/16.
 * email: ricardo.centeno@mobintum.com
 */
public class AddCustomerDialog extends DialogFragment implements View.OnClickListener{

    public static final String TAG = "AddCustomerDialog";
    private FloatLabel etName, etBusinessName, etRFC,etNotes;
    private Button btnCancel, btnSave;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dialog_add_customer,container,false);
        etName = (FloatLabel) view.findViewById(R.id.etName);
        etBusinessName = (FloatLabel) view.findViewById(R.id.etBusinessName);
        etRFC = (FloatLabel) view.findViewById(R.id.etRFC);
        etNotes = (FloatLabel) view.findViewById(R.id.etNotes);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnSave = (Button) view.findViewById(R.id.btnSave);
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCancel:
                break;
            case R.id.btnSave:
                save();
                break;
        }

    }

    private boolean save(){
        return false;
    }
}
