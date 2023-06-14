package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import kotlin.io.SerializableKt;

public class LoginActivity extends AppCompatActivity {

    EditText id, pw;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id = findViewById(R.id.id);
        pw = findViewById(R.id.pw);
        btn_login = findViewById(R.id.btn_login);

        Log.d("글자", id.getText() + "");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id.getText().toString().equals("admin") && pw.getText().toString().equals("admin1234")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("strkey", id.getText().toString() + "intent");
                    intent.putExtra("intkey", 10);
                    LoginDTO dto = new LoginDTO(id.getText().toString() + "1", pw.getText().toString() + "2");
                    intent.putExtra("dtokey", dto);
                    ArrayList<LoginDTO> arrdto = new ArrayList<>();
                    arrdto.add(new LoginDTO("a1", "b1"));
                    arrdto.add(new LoginDTO("a2", "b2"));
                    arrdto.add(new LoginDTO("a3", "b3"));
                    arrdto.add(new LoginDTO("a4", "b4"));
                    arrdto.add(new LoginDTO("a5", "b5"));
                    intent.putExtra("list",arrdto);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "성공", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "실패", Toast.LENGTH_SHORT).show();
                }

//                Intent를 이용한 화면 전환 => Intent객체(안드로이드의 4대 컴포넌트의 통신을 담당) Act=>"Intent" =>Act
//                Context(맥락, 상태정보 확인) : 현재 화면에 떠있는 객체인지 ?
//                ex) DAO, DTO, VO => 화면에 떠있는 객체가 아니기 때문에 그래픽 작업을 하면 오류가 발생함 => 일반 클래스
//                ex) Act, Fragment => 화면에 떠있는 객체이기 때문에 그래픽 작업을 할 수 있음.
//                                     하지만 화면에 떠있는지의 상태를 알려줄 수 있는게 필요함 => Context
//                => 일반클래스에서도 그래픽 처리가 가능하게 만드려면 Activity가 Context라는것을 파라미터로 보내줬을 때 가능함
            }
        });

    }

}