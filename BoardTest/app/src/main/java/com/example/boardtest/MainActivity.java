package com.example.boardtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_new_account, btn_login;

    EditText input_id, input_pw;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_new_account = findViewById(R.id.btn_new_account);
        btn_login = findViewById(R.id.btn_login);
        input_id = findViewById(R.id.input_id);
        input_pw = findViewById(R.id.input_pw);
        btn_new_account.setOnClickListener(v -> {
            intent = new Intent(MainActivity.this, NewAccount.class);
            startActivity(intent);
        });

        btn_login.setOnClickListener(v -> {
            intent = new Intent(MainActivity.this, Board.class);
            boolean isDuplicate = false;
            for (int i = 0; i < NewAccount.accountDTO.size(); i++) {
                if(input_id.getText().toString().equals(NewAccount.accountDTO.get(i).getUser_id()) &&
                        input_pw.getText().toString().equals(NewAccount.accountDTO.get(i).getUser_pw())) {
                    isDuplicate = true;
                    break;
                }
            }
            if(isDuplicate) {
            startActivity(intent);
            } else {
                Toast.makeText(this, "존재하지 않은 아이디이거나 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}