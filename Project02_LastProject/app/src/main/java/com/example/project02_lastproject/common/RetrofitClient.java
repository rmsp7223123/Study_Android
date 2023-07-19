package com.example.project02_lastproject.common;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.87/middle/")
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        return retrofit;
    }

    public Retrofit retrofitLogin(){
        return new Retrofit.Builder()
                .baseUrl("http:/localhost/middle/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }
}
