package com.example.and00_springtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RetrofitClient rc = new RetrofitClient();
//        RetrofitInterface api = rc.getRetrofit().create(RetrofitInterface.class);

        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("param","값ㄴㅁㅇㄹ");
        paramMap.put("param1","값ㄴㅁㅇㄹ");
        paramMap.put("param2","값ㄴㅁㅇㄹ");

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("레트로핏");
        dialog.setMessage("확인용123123");
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.show();

        api.clientPostMethod("list.cu", paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("레트로핏", "응답이 왔음" + response.body());
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("레트로핏", "응답 없음, 실패");
            }
        });
    }
}