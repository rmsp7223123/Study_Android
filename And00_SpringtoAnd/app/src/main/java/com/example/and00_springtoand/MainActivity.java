package com.example.and00_springtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitClient rc = new RetrofitClient();
        RetrofitInterface api = rc.getRetrofit().create(RetrofitInterface.class);


//        api.getCuList().enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.d("레트로핏", "onResponse: ");
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.d("레트로핏", "onResponse: ");
//            }
//        });

        api.getCu().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("레트로핏", "onResponse: ");
                //String to Object(CustomerVO) 'Gson'
                Gson gson = new Gson();
                CustomerVO vo = gson.fromJson(response.body(), CustomerVO.class);
                Log.d("레트로핏", "onResponse: " + vo);
                Log.d("레트로핏", "onResponse: " + vo.getEmail());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("레트로핏", "onResponse: ");
            }
        });

        api.getCuList().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                ArrayList<CustomerVO> list = new Gson().fromJson(
                        result, new TypeToken<ArrayList<CustomerVO>>(){}.getType()
                );
                Log.d("레트로핏", "onResponse: " + list.size());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}