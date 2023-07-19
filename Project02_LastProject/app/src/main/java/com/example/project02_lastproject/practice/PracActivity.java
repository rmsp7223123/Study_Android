package com.example.project02_lastproject.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.RetrofitClient;
import com.example.project02_lastproject.common.RetrofitInterface;
import com.example.project02_lastproject.databinding.ActivityPracBinding;

import java.util.HashMap;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PracActivity extends AppCompatActivity {

    ActivityPracBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPracBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSelect.setOnClickListener(view -> {
            commonExcute(binding.edtUrl.getText().toString(), new HashMap<>(), new CallbackMbj() {
                @Override
                public void onResult(String data) {
                    binding.tvResult.setText(data);
                }
            });
        });

        binding.btnInsert.setOnClickListener(view -> {
            HashMap<String, Object> test =new HashMap<>();
            test.put("col1", new Random().nextInt(100));
            test.put("col2", new Random().nextInt(100));
            commonExcute("retrofit/insert", test, data -> {
                binding.tvResult.setText(data);
            });
        });
    }


    public void commonExcute(String url, HashMap<String, Object> map, CallbackMbj callback){
        RetrofitInterface api = new RetrofitClient().retrofitLogin().create(RetrofitInterface.class);
        api.postLogin(url, map).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onResult(t.getMessage());
            }
        });
    }

    public interface CallbackMbj{
        public void onResult(String data);
    }
}