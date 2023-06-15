package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
final String TAG = "가가";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent  intent = getIntent();
        String strValue1 = intent.getStringExtra("strkey1");
        DTO dto = (DTO) intent.getSerializableExtra("send");
        int intValue1 = intent.getIntExtra("intkey1",-1);
        ArrayList<DTO> arrdto1 = (ArrayList<DTO>) intent.getSerializableExtra("arrdto1");
        Log.d(TAG, "onClick: " + strValue1);
        Log.d(TAG, "onCreate: " + intValue1);
     //   Log.d(TAG, "onCreate: " + dto.getStr1()+dto.getInt1());
        Log.d(TAG, "onCreate: "+arrdto1.get(0).getStr1()+arrdto1.get(0).getInt1());

    }
}