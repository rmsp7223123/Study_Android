package com.example.and09_fragmentadapter.recycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerFragment extends Fragment {
    RecyclerView recv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        recv = v.findViewById(R.id.recv);
        ArrayList<RecyclerDTO> list = getList();
        AdapterRecv adapter = new AdapterRecv(inflater, list);
        recv.setAdapter(adapter);
        recv.setLayoutManager(new LinearLayoutManager(getContext()));

        new NormalClass().testToast("ddd", getContext());
        return v;
    }

    ArrayList<RecyclerDTO> getList() {
        ArrayList<RecyclerDTO> list = new ArrayList<>();

        list.add(new RecyclerDTO(R.drawable.pepe1, 25, "남1", "문병준1", "주소1"));
        list.add(new RecyclerDTO(R.drawable.pepe2, 26, "남2", "문병준2", "주소2"));
        list.add(new RecyclerDTO(R.drawable.pepe3, 27, "남3", "문병준3", "주소3"));
        list.add(new RecyclerDTO(R.drawable.pepe4, 28, "남4", "문병준4", "주소4"));
        list.add(new RecyclerDTO(R.drawable.pepe5, 29, "남5", "문병준5", "주소5"));
        list.add(new RecyclerDTO(R.drawable.pepe6, 30, "남6", "문병준6", "주소6"));
        list.add(new RecyclerDTO(R.drawable.pepe7, 31, "남7", "문병준7", "주소7"));

        return list;
    }
}