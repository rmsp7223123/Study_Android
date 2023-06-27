package com.example.project01_mbjtalk.opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_mbjtalk.R;
import com.example.project01_mbjtalk.databinding.FragmentOpenTalkSub1Binding;

public class OpenTalkSub1Fragment extends Fragment {

    FragmentOpenTalkSub1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenTalkSub1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}