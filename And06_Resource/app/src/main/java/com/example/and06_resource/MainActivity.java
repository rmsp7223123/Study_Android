package com.example.and06_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        Log.d("Values/String 값 : " , + R.string.mbj_version + ""); // id(메모리 번지수)
        Log.d("Values/String 값 : " , getString(R.string.mbj_version)); // 실제 값 출력



    }
}