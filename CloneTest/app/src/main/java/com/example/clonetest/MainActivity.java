package com.example.clonetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.clonetest.databinding.ActivityMainBinding;
import com.example.clonetest.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });
        binding.btnSetting.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }
}