package com.example.project02_lastproject.hr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_lastproject.databinding.ItemRecvHrBinding;

import java.util.ArrayList;

public class HrFragmentAdapter extends RecyclerView.Adapter<HrFragmentAdapter.ViewHolder>{

    ArrayList<HrVO> list ;

    public HrFragmentAdapter(ArrayList<HrVO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvHrBinding binding;
        binding = ItemRecvHrBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvName.setText(list.get(position).getEmp_name());
        holder.binding.tvId.setText(list.get(position).getEmployee_id()+"");
        holder.binding.tvEmail.setText(list.get(position).getEmail());
        holder.binding.tvDepartmentName.setText(list.get(position).getDepartment_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRecvHrBinding binding;
        public ViewHolder(@NonNull ItemRecvHrBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
