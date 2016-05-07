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
import android.widget.Toast;

import com.iangclifton.android.floatlabel.FloatLabel;
import com.mobintum.crmlite.R;
import com.mobintum.crmlite.fragments.RVCustomersFragment;
import com.mobintum.crmlite.models.Customer;

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
        View view=inflater.inflate(R.layout.dialog_add_customer, container, false);
        etName = (FloatLabel) view.findViewById(R.id.etName);
        etBusinessName = (FloatLabel) view.findViewById(R.id.etBusinessName);
        etRFC = (FloatLabel) view.findViewById(R.id.etRFC);
        etNotes = (FloatLabel) view.findViewById(R.id.etNotes);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

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
                dismiss();
                break;
            case R.id.btnSave:
                if(etName.getEditText().getText().toString().isEmpty())
                    etName.getEditText().setError("Campo Obligatorio");
                else {
                    save();
                }
                break;
        }

    }

    private void save(){

        String name = etName.getEditText().getText().toString();
        String businessName = etBusinessName.getEditText().getText().toString();
        String rfc = etRFC.getEditText().getText().toString();
        String notes = etNotes.getEditText().getText().toString();

        long id = Customer.insert(getContext(), new Customer(name, businessName, rfc, notes));

        if (id!=-1) {
            RVCustomersFragment rvCustomersFragment = (RVCustomersFragment) getActivity().getSupportFragmentManager().findFragmentByTag(RVCustomersFragment.TAG);
            rvCustomersFragment.refreshCustomers();
            Toast.makeText(getContext(), "Guardado Correctamente", Toast.LENGTH_SHORT).show();
            dismiss();
        }
        else
            Toast.makeText(getContext(),"Error al Guardar",Toast.LENGTH_SHORT).show();
    }
}
