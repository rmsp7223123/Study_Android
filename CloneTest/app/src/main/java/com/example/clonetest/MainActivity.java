package com.example.clonetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.clonetest.databinding.ActivityMainBinding;
import com.example.clonetest.ui.login.LoginActivity;
import com.example.clonetest.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Intent intent;

    FragmentManager manager = getSupportFragmentManager();

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
        manager.beginTransaction().replace(R.id.container_linear, new LoginFragment()).commit();
    }
}