package com.example.and09_fragmentadapter.melon;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class MelonFragment extends Fragment {

    RecyclerView recyclerView, recv_melon;

    TextView tv_home, tv_newmusic, tv_chart, tv_musicvideo, tv_ticket;

    ImageView home_melon;
    LinearLayout container_linear;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_melon, container, false);
        ArrayList<MelonDTO> list = getlist();
        recyclerView = v.findViewById(R.id.recv_melon);
        tv_home = v.findViewById(R.id.tv_home);
        tv_newmusic = v.findViewById(R.id.tv_newmusic);
        tv_chart = v.findViewById(R.id.tv_chart);
        tv_musicvideo = v.findViewById(R.id.tv_musicvideo);
        tv_ticket = v.findViewById(R.id.tv_ticket);
        container_linear = v.findViewById(R.id.container_linear);
        home_melon = v.findViewById(R.id.home_melon);
        recv_melon = v.findViewById(R.id.recv_melon);

        FragmentManager manager = getParentFragmentManager();

        tv_home.setOnClickListener(v1 -> {
            changeColor(tv_home);
        });
        tv_newmusic.setOnClickListener(v1 -> {
            changeColor(tv_newmusic);
        });
        tv_chart.setOnClickListener(v1 -> {
            changeColor(tv_chart);
        });
        tv_musicvideo.setOnClickListener(v1 -> {
            changeColor(tv_musicvideo);
        });
        tv_ticket.setOnClickListener(v1 -> {
            changeColor(tv_ticket);
        });
        home_melon.setOnClickListener(v1 -> {
            manager.beginTransaction().replace(R.id.recv_melon, new HomeFragment2()).commit();
        });


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
        list.add(new MelonDTO(R.drawable.pepe1, 8, "노래제목8", "가수이름8"));
        list.add(new MelonDTO(R.drawable.pepe2, 9, "노래제목9", "가수이름9"));
        list.add(new MelonDTO(R.drawable.pepe3, 10, "노래제목10", "가수이름10"));
        return list;
    }

    public void changeColor(TextView tv) {
        tv_home.setTextColor(Color.parseColor("#000000"));
        tv_newmusic.setTextColor(Color.parseColor("#000000"));
        tv_chart.setTextColor(Color.parseColor("#000000"));
        tv_musicvideo.setTextColor(Color.parseColor("#000000"));
        tv_ticket.setTextColor(Color.parseColor("#000000"));
        tv.setTextColor(Color.parseColor("#56fc99"));
    }
}