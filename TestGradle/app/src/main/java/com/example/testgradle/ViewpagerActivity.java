package com.example.testgradle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;

import com.example.testgradle.databinding.ActivityViewpagerBinding;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;

import java.util.Calendar;

public class ViewpagerActivity extends AppCompatActivity {

    ActivityViewpagerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewpagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }




}