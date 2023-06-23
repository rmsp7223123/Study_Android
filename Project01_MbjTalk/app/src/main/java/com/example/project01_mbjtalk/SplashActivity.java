package com.example.project01_mbjtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.project01_mbjtalk.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding; // 디자인 파일(xml)이 Binding객체가 생기는 것
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

//        ProgressDialog : 로딩중에 사용자가 어떤 동작을 하고 있는지 인지를 못한 경우에는 프로그램 오류나, 버그를 읫미하고 기다림을 멈춤
//        조작 X => 앱종료(로딩중이라는 것을 나타내기 위한 위젯을 사용)
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Mbj Talk");
        dialog.setMessage("로딩중 입니다");
        dialog.setCancelable(false);
        dialog.show();

//        Splash Screen : 데이터 로딩이나, 앱 실행 시, 유저에게 로고를 노출함으로써 각인효과를 주고 기다리는 시간을 조금 더 짧게 느끼게 함

//        Thread : Handler
//        안드로이드의 앱은 메인 프로세스가 진행되면서 모든 처리가 일어남

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000 * 2);
    }
}