package com.mobintum.crmlite.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobintum.crmlite.R;
import com.mobintum.crmlite.models.Customer;

import java.util.List;

/**
 * Created by Rick on 07/05/16.
 * email: ricardo.centeno@mobintum.com
 */
public class CustomerRVAdapter extends RecyclerView.Adapter<CustomerRVAdapter.ViewHolder>{

    private List<Customer> customers;

    public CustomerRVAdapter(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_customer, parent, false);
        ViewHolder cvh = new ViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.txtName.setText(customer.getName());
        holder.txtRFC.setText(customer.getRfc());
        holder.txtNotes.setText(customer.getNotes());


    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtRFC, txtNotes;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtRFC = (TextView) itemView.findViewById(R.id.txtRFC);
            txtNotes = (TextView) itemView.findViewById(R.id.txtNotes);

        }
    }
}
