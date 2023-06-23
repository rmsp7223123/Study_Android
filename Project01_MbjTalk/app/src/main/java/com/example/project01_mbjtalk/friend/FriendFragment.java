package com.example.project01_mbjtalk.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_mbjtalk.R;
import com.example.project01_mbjtalk.databinding.FragmentFriendBinding;

import java.util.ArrayList;

public class FriendFragment extends Fragment {

    FragmentFriendBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFriendBinding.inflate(inflater, container, false);
//        View v = inflater.inflate(R.layout.fragment_friend, container, false);
        binding.recvFriend.setAdapter(new FriendAdapter(getlist()));
        binding.recvFriend.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public ArrayList<FriendDTO> getlist() {
        ArrayList<FriendDTO> list = new ArrayList<>();
        list.add(new FriendDTO(R.drawable.pepe1 , "이름1", ""));
        list.add(new FriendDTO(R.drawable.pepe2 , "이름2", ""));
        list.add(new FriendDTO(R.drawable.pepe3 , "이름3", ""));
        list.add(new FriendDTO(R.drawable.pepe4 , "이름4", ""));
        list.add(new FriendDTO(R.drawable.pepe5 , "이름5", ""));
        list.add(new FriendDTO(R.drawable.pepe6 , "이름6", ""));
        list.add(new FriendDTO(R.drawable.pepe7 , "이름7", ""));
        list.add(new FriendDTO(R.drawable.pepe8 , "이름8", ""));
        list.add(new FriendDTO(R.drawable.pepe9 , "이름9", ""));
        list.add(new FriendDTO(R.drawable.pepe10 , "이름10", ""));
        return list;
    }
}