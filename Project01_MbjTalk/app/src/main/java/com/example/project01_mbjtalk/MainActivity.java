package com.example.project01_mbjtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.project01_mbjtalk.databinding.ActivityMainBinding;
import com.example.project01_mbjtalk.friend.FriendFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActionBar actionBar;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        manager = getSupportFragmentManager();
        actionBar = getSupportActionBar();
        actionBar.setElevation(0f);
        actionBar.setTitle("친구목록");
        manager.beginTransaction().replace(R.id.container_frame, new FriendFragment()).commit();
    }
}