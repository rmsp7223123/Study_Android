package com.example.project02_lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonConn.MbjCallback callback = new CommonConn.MbjCallback() {
            @Override
            public void onResult(boolean isResult, String data) {

            }
        };


        binding.btnLogin.setOnClickListener(v -> {
            CommonConn conn = new CommonConn("login", this);
            conn.addParamMap("id", binding.edtId.getText().toString());
            conn.addParamMap("pw", binding.edtPw.getText().toString());
            conn.onExcute(callback);
        });


    }
}