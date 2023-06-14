package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class TestActivity extends AppCompatActivity {
final String TAG = "가가";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent  intent = getIntent();
        String strValue1 = intent.getStringExtra("strkey1");
        int intValue1 = intent.getIntExtra("intkey1",-1);
        Log.d(TAG, "onClick: " + strValue1);
        Log.d(TAG, "onCreate: " + intValue1);
    }
}