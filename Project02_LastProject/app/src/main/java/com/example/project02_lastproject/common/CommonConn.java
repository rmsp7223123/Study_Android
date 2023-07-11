package com.example.project02_lastproject.common;

import android.content.Context;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {

    private HashMap<String, Object> paramMap;

    private String mapping;

    private MbjCallback callback;

    private Context context;

    public CommonConn(String mapping, Context context) {
        this.mapping = mapping;
        this.context = context;
        this.paramMap = new HashMap<>();
    }

    public void addParamMap(String key, Object value) {
        if (key == null || value == null) {

        } else {
            paramMap.put(key, value);
        }
    }

    public void onExcute(MbjCallback callback) {
        this.callback = callback;
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        api.clientPostMethod(mapping,paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResult(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onResult(false, null);
            }
        });
    }

    public interface MbjCallback{
        public void onResult(boolean isResult, String data);
    }
}
