package com.example.and00_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.and00_login.databinding.ActivityMainBinding;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonConn.MbjCallBack callBack = new CommonConn.MbjCallBack() {
            @Override
            public void onResult(boolean isResult, String data) {

            }
        };

        Log.d("확인용", "onCreate: " + callBack);

        binding.btnLogin.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(this, "login");
            conn.addParamMap("id", binding.edtId.getText().toString());
            conn.addParamMap("pw", binding.edtPw.getText().toString());
            conn.onExcute(callBack); // onExcute 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작동
        });
    }
//순우유 완듀완듀팡 / 이준병 한윗스 고기생잘

}