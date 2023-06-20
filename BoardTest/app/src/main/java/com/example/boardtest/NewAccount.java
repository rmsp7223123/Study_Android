package com.example.boardtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NewAccount extends AppCompatActivity {

    public static ArrayList<AccountDTO> accountDTO = new ArrayList<>();
    EditText edt_input_userid, edt_input_userpw, edt_input_userpw_check, edt_input_email, edt_input_name;
    Button btn_account_commit, btn_account_cancel;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        edt_input_userid = findViewById(R.id.edt_input_userid);
        edt_input_userpw = findViewById(R.id.edt_input_userpw);
        edt_input_userpw_check = findViewById(R.id.edt_input_userpw_check);
        edt_input_email = findViewById(R.id.edt_input_email);
        edt_input_name = findViewById(R.id.edt_input_name);
        btn_account_commit = findViewById(R.id.btn_account_commit);
        btn_account_cancel = findViewById(R.id.btn_account_cancel);

        btn_account_commit.setOnClickListener(v -> {
            intent = new Intent(NewAccount.this , MainActivity.class);
            String userId = edt_input_userid.getText().toString();

            boolean isDuplicate = false;
            for (int i = 0; i < accountDTO.size(); i++) {
                AccountDTO account = accountDTO.get(i);
                if(account.getUser_id().equals(userId)) {
                    isDuplicate = true;
                    break;
                }
            }

            if(!isDuplicate && edt_input_userpw.getText().toString().equals(edt_input_userpw_check.getText().toString())){
            accountDTO.add(new AccountDTO(userId, edt_input_userpw.getText().toString(),
                    edt_input_name.getText().toString(), edt_input_email.getText().toString()));
            startActivity(intent);
            } else if (!edt_input_userpw.getText().toString().equals(edt_input_userpw_check.getText().toString())){
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "중복된 id입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_account_cancel.setOnClickListener(v -> {
            intent = new Intent(NewAccount.this, MainActivity.class);
            startActivity(intent);
        });
    }
}