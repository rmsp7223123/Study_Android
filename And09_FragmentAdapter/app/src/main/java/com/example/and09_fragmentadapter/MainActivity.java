package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout container_frame;

    Button btn_menu1, btn_menu2, btn_adapter;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      container_frame = findViewById(R.id.container_frame); fragmentManager에서는 객체로 초기화 된 위젯이 필요하지 않음, 디자인파일에 id만 필요
        btn_menu1 = findViewById(R.id.btn_menu1);
        btn_menu2 = findViewById(R.id.btn_menu2);
        btn_adapter = findViewById(R.id.btn_adapter);

        FragmentManager manager = getSupportFragmentManager(); // 초기화 식

        btn_menu1.setOnClickListener(v -> {
//            트랜잭션 : Oracle 작업 최소 단위 , Commit & Rollback
            manager.beginTransaction().replace(R.id.container_frame, new HomeFragment(), "A").commit();
            Log.d("버튼1", btn_menu1.getText().toString());
        });
        btn_menu2.setOnClickListener(v -> {
            Log.d("버튼2", btn_menu2.getText().toString());
            manager.beginTransaction().replace(R.id.container_frame, new SubFragment()).commit();

        });
        btn_adapter.setOnClickListener(v -> {
            intent = new Intent(MainActivity.this , AdapterActivity.class);
            startActivity(intent);
        });
//        Fragment를 붙이기 위한 공간, Fragment, FragmentManager 3가지 요소가 필요함
    }
}