package com.example.and00_springtoand;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    
    public Retrofit getRetrofit() {
            Retrofit retrofit = new Retrofit.Builder()
            //baseUrl ( http:/192.168.0.87/middle/ ) : Spring에서 프로젝트까지의 경로
            .baseUrl("http:/192.168.0.87/middle/")
            //ScalarsConverterFactory : 단일 String(Json)형태로 데이터가 공유될 때 사용하는 객체
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();
        return retrofit;
//    GitHubService service = retrofit.create(GitHubService.class);
    }
}
