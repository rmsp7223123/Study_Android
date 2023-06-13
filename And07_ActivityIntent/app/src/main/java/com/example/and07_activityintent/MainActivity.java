package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    final String TAG = "수명주기";
//    현재는 oncreate내부에서만 대부분의 코드처리를 해도 무방
//    추후에 여러 화면 이나 Spring 연동 시 새로고침 등의 처리가 필요할 때는 수명 주기가 있다는 것을 생각 하고, 적절한 수명 주기를 이용 해야 함

//    안드로이드도 Spring과 마찬가지로 Debugging을 잘하면 오류 찾는게 빠름
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}