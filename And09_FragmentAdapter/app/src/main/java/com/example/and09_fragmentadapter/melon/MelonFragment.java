package com.example.and09_fragmentadapter.melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class MelonFragment extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_melon, container, false);
        ArrayList<MelonDTO> list = getlist();
        recyclerView = v.findViewById(R.id.recv_melon);
        MelonAdapter adapter = new MelonAdapter(inflater, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }


    ArrayList<MelonDTO> getlist() {
        ArrayList<MelonDTO> list = new ArrayList<>();
        list.add(new MelonDTO(R.drawable.chart_img1, 1, "노래제목1", "가수이름1"));
        list.add(new MelonDTO(R.drawable.chart_img2, 2, "노래제목2", "가수이름2"));
        list.add(new MelonDTO(R.drawable.chart_img3, 3, "노래제목3", "가수이름3"));
        list.add(new MelonDTO(R.drawable.chart_img4, 4, "노래제목4", "가수이름4"));
        list.add(new MelonDTO(R.drawable.chart_img5, 5, "노래제목5", "가수이름5"));
        list.add(new MelonDTO(R.drawable.chart_img6, 6, "노래제목6", "가수이름6"));
        list.add(new MelonDTO(R.drawable.chart_img7, 7, "노래제목7", "가수이름7"));
        return list;
    }
}