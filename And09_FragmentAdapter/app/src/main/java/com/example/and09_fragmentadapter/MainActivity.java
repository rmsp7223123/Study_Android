package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.and09_fragmentadapter.databinding.ActivityMainBinding;
import com.example.and09_fragmentadapter.melon.HomeFragment2;
import com.example.and09_fragmentadapter.melon.MelonFragment;

public class MainActivity extends AppCompatActivity {

    //    FrameLayout container_frame;
//
//    Button btn_menu1, btn_menu2, btn_adapter;
    ActivityMainBinding binding;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // getRoot => 디자인xml파일의 최상단의 레이아웃
//      container_frame = findViewById(R.id.container_frame); fragmentManager에서는 객체로 초기화 된 위젯이 필요하지 않음, 디자인파일에 id만 필요

        FragmentManager manager = getSupportFragmentManager(); // 초기화 식

        binding.btnMenu1.setOnClickListener(v -> {
//            트랜잭션 : Oracle 작업 최소 단위 , Commit & Rollback
            manager.beginTransaction().replace(R.id.container_frame, new HomeFragment(), "A").commit();
        });
        binding.btnMenu2.setOnClickListener(v -> {
            manager.beginTransaction().replace(R.id.container_frame, new SubFragment()).commit();

        });
        binding.btnAdapter.setOnClickListener(v -> {
            intent = new Intent(MainActivity.this, AdapterActivity.class);
            startActivity(intent);
        });
//        Fragment를 붙이기 위한 공간, Fragment, FragmentManager 3가지 요소가 필요함
    }


    public void changeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container_frame, new HomeFragment2()).commit();
    }
}