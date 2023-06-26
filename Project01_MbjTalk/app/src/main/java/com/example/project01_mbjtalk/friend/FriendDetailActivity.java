package com.example.project01_mbjtalk.friend;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.project01_mbjtalk.R;
import com.example.project01_mbjtalk.databinding.ActivityFriendDetailBinding;

public class FriendDetailActivity extends AppCompatActivity {

    ActivityFriendDetailBinding binding;

    FriendDTO dto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFriendDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dto = (FriendDTO) getIntent().getSerializableExtra("dto");
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setStatusBarColor(Color.TRANSPARENT);
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding.imgvBackground.setImageResource(dto.getResImgId());
        binding.imgvProfile.setImageResource(dto.getResImgId());
        binding.tvName.setText(dto.getName());
        binding.tvMsg.setText(dto.getMsg());


        binding.imgvClose.setOnClickListener(v -> {
            finish();
        });

    }
}