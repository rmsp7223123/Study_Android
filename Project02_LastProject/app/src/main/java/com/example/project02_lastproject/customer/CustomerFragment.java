package com.example.project02_lastproject.customer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.databinding.FragmentCustomerBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CustomerFragment extends Fragment {

    FragmentCustomerBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCustomerBinding.inflate(inflater,container,false);
        select();
        binding.swipeCustomer.setOnRefreshListener(() -> {
            // interface내부에 별도의 파라미터가 없다면 공백으로 람다식 표현
            select();
            binding.swipeCustomer.setRefreshing(false);
        });

        binding.flbtnInsert.setOnClickListener(v -> {
            CustomerDialog dialog = new CustomerDialog(getContext(), null);
            dialog.show();
        });
        
        return binding.getRoot();
    }

    public void select() {
        CommonConn conn = new CommonConn("list.cu",getContext());
        conn.onExcute((isResult, data) -> {
            ArrayList<CustomerVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());
            Log.d("TAG", "select: "+list.size());
            binding.recvCustomer.setAdapter(new CustomerFragmentAdapter(list));
            binding.recvCustomer.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }
}