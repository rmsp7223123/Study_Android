package com.example.project01_mbjtalk.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_mbjtalk.R;
import com.example.project01_mbjtalk.databinding.FragmentChatBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatFragment extends Fragment {
    FragmentChatBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater,container,false);
//        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        binding.recvChat.setAdapter(new ChatAdapter(getlist()));
        binding.recvChat.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }


    ArrayList<ChatDTO> getlist() {
        Date date = new Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("MM월 dd일");
        String date1 = simpledate.format(date);
        ArrayList<ChatDTO> list = new ArrayList<>();
        list.add(new ChatDTO(R.drawable.pepe1, "이름1", "", "할말1", date1));
        list.add(new ChatDTO(R.drawable.pepe2, "이름1, 이름2", "", "할말2", date1));
        list.add(new ChatDTO(R.drawable.pepe3, "이름1, 이름3", "", "할말3", date1));
        list.add(new ChatDTO(R.drawable.pepe4, "이름1", "", "할말4", date1));
        list.add(new ChatDTO(R.drawable.pepe5, "이름1", "", "할말5", date1));
        list.add(new ChatDTO(R.drawable.pepe6, "이름1", "", "할말6", date1));
        list.add(new ChatDTO(R.drawable.pepe7, "이름1, 이름2, 이름4", "", "할말7", date1));
        list.add(new ChatDTO(R.drawable.pepe8, "이름1", "", "할말8", date1));
        list.add(new ChatDTO(R.drawable.pepe9, "이름1", "", "할말9", date1));
        list.add(new ChatDTO(R.drawable.pepe10, "이름1, 이름6, 이름7, 이름8", "", "할말10", date1));
        return list;
    }
}