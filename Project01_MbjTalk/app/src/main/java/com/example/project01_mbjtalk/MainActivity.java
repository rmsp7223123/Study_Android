package com.example.project01_mbjtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.project01_mbjtalk.chat.ChatFragment;
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

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            if (item.getItemId() == R.id.tab1) {
                fragment = new FriendFragment();
                actionBar.setTitle("친구");
            } else if (item.getItemId() == R.id.tab2) {
                actionBar.setTitle("채팅");
                manager.beginTransaction().replace(R.id.container_frame, new ChatFragment()).commit();
            } else if (item.getItemId() == R.id.tab3) {
                actionBar.setTitle("오픈채팅");
            } else if (item.getItemId() == R.id.tab4) {
                actionBar.setTitle("쇼핑");
            } else if (item.getItemId() == R.id.tab5) {
                actionBar.setTitle("더보기");
            } else {
                return false; // 메뉴가 바뀌는 처리를 취소
            }
            if (fragment == null) {
                Toast.makeText(this, "아직 메뉴가 준비되지 않았습니다.", Toast.LENGTH_SHORT).show();
            } else {
                manager.beginTransaction().replace(R.id.container_frame, fragment).commit();

            }
            return true;
        });
    }
}