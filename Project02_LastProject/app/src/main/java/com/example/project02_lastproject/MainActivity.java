package com.example.project02_lastproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.customer.CustomerFragment;
import com.example.project02_lastproject.databinding.ActivityMainBinding;
import com.example.project02_lastproject.hr.HrFragment;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.container_frame, new CustomerFragment()).commit();

    binding.bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {

        FragmentManager manager = getSupportFragmentManager();
        @Override
        public boolean onItemSelect(int i) {
            if(i == 0 ) {
                manager.beginTransaction().replace(R.id.container_frame, new CustomerFragment()).commit();
            }else if (i == 1) {
                manager.beginTransaction().replace(R.id.container_frame, new HrFragment()).commit();
            }else if (i == 2) {

            }else {

            }
            return true;
        }
    });

    }
}