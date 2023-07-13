package com.example.project02_lastproject.hr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.customer.CustomerFragmentAdapter;
import com.example.project02_lastproject.customer.CustomerVO;
import com.example.project02_lastproject.databinding.FragmentHrBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class HrFragment extends Fragment {

    FragmentHrBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHrBinding.inflate(inflater,container,false);
        select();
        binding.swipeCustomer.setOnRefreshListener(() -> {
            // interface내부에 별도의 파라미터가 없다면 공백으로 람다식 표현
            select();
            binding.swipeCustomer.setRefreshing(false);
        });

        return binding.getRoot();
    }


    public void select() {
        CommonConn conn = new CommonConn("hr/list",getContext());
        conn.onExcute((isResult, data) -> {
            ArrayList<HrVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<HrVO>>(){}.getType());
            binding.recvHr.setAdapter(new HrFragmentAdapter(list));
            binding.recvHr.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }
}