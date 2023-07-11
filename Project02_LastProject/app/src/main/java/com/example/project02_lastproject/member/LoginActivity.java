package com.example.project02_lastproject.member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

// login?id=dev1&pw=dev1

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(v -> {
            login();
        });
    }


    public void login() {
        if (binding.edtId.getText().toString().length() < 1 || binding.edtPw.getText().toString().length() < 1) {
            Toast.makeText(this, "아이디, 비밀번호 입력 안함", Toast.LENGTH_SHORT).show();
            return;
        }
        CommonConn conn = new CommonConn("login", this);
        conn.addParamMap("id", binding.edtId.getText().toString());
        conn.addParamMap("pw", binding.edtPw.getText().toString());
        conn.onExcute((isResult, data) -> {
            if (isResult) {
                AndMembersVO vo = new Gson().fromJson(data, AndMembersVO.class);
                if (vo == null) {
                    Toast.makeText(this, "아이디 또는 비밀번호 확인", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}