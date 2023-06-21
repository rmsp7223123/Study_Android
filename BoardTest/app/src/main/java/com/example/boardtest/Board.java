package com.example.boardtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Board extends AppCompatActivity {

    Button btn_write;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        btn_write = findViewById(R.id.btn_write);
        btn_write.setOnClickListener(v -> {
            intent = new Intent(Board.this, BoardWrite.class);
            startActivity(intent);
        });
    }
}