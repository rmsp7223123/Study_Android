package com.example.project02_lastproject.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.databinding.ItemRecvCustomerBinding;

import java.util.ArrayList;

public class CustomerFragmentAdapter extends RecyclerView.Adapter<CustomerFragmentAdapter.ViewHolder>{

    ArrayList<CustomerVO> list;

    Context context;

    public CustomerFragmentAdapter(ArrayList<CustomerVO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemRecvCustomerBinding binding;
        binding =ItemRecvCustomerBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvId.setText(list.get(position).getId()+"");
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.btnDelete.setOnClickListener(v -> {
            CommonConn conn = new CommonConn("delete.cu", context);
            conn.addParamMap("id", list.get(position).getId());
            conn.onExcute(new CommonConn.MbjCallback() {
                @Override
                public void onResult(boolean isResult, String data) {

                }
            });
        });
        holder.binding.btnUpdate.setOnClickListener(v -> {
            CustomerDialog dialog = new CustomerDialog(context, list.get(position)  );
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRecvCustomerBinding binding;
        public ViewHolder(@NonNull ItemRecvCustomerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
