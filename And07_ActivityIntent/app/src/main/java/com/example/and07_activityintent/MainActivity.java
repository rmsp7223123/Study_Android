package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String TAG = "수명주기";
    Button call_btn, search_btn, msg_btn, msg_btn2, int_btn, send_btn;
    EditText edt_call, edt_search, edt_msg, edt_msg2, edt_int;
//    현재는 oncreate내부에서만 대부분의 코드처리를 해도 무방
//    추후에 여러 화면 이나 Spring 연동 시 새로고침 등의 처리가 필요할 때는 수명 주기가 있다는 것을 생각 하고, 적절한 수명 주기를 이용 해야 함

    //    안드로이드도 Spring과 마찬가지로 Debugging을 잘하면 오류 찾는게 빠름
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        Intent intent = getIntent();
//        방금 LoginAcitivity에서 startActivity('intent')에 사용된 intent를 가져옴 (내부에 넣어둔(putExtra) 데이터를 빼오기 위해서)
        String strValue = intent.getStringExtra("strkey");
        int intValue = intent.getIntExtra("intkey", -1);
        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dtokey");
        ArrayList<LoginDTO> arrdto = (ArrayList<LoginDTO>) intent.getSerializableExtra("list");
//        객체의 타입을 주고 강제로 바꾸는 것 ==> 역 직렬화 ==> 내부에 있는 멤버를 사용하기 위해 Serializable => dto
//        Log.d(TAG, "onCreate: " + strValue);
//        Log.d(TAG, "onCreate: " + intValue);
//        Log.d(TAG, "onCreate: " + dto.getId());
//        Log.d(TAG, "onCreate: " + dto.getPw());
//        Log.d(TAG, "onCreate: " + arrdto.size());


    }

    @Override
    protected void onStart() {
        super.onStart();
        call_btn = findViewById(R.id.call_btn);
        search_btn = findViewById(R.id.search_btn);
        msg_btn = findViewById(R.id.msg_btn);
        msg_btn2 = findViewById(R.id.msg_btn2);
        int_btn = findViewById(R.id.int_btn);
        send_btn = findViewById(R.id.send_btn);
        edt_call = findViewById(R.id.edt_call);
        edt_search = findViewById(R.id.edt_search);
        edt_msg = findViewById(R.id.edt_msg);
        edt_msg2 = findViewById(R.id.edt_msg2);
        edt_int = findViewById(R.id.edt_int);


//        인터페이스를 함수로 넘겨야 할 때 함수로 메소드 지역만 만들어 냄, 람다식에서 인터페이스를 함수형 으로 쓸 때 인터페이스 내부 에는 메소드가 반드시 하나 여야만 함
//        명시적 : activity => activity.cclass 이동시 많이 사용
//        암시적, 묵시적 : activity => action(내가 없는 기능)을 사용할 때 많이 씀
        call_btn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/" + edt_call.getText().toString()));
            startActivity(intent);
        });

        search_btn.setOnClickListener(this::onClick);
        msg_btn.setOnClickListener(this::onClick);
        msg_btn2.setOnClickListener(this::onClick);
        int_btn.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.search_btn) {
            intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, edt_search.getText().toString());
            startActivity(intent);
        } else if (v.getId() == R.id.msg_btn) {
            intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + Uri.encode("010-5625-7223")));
            intent.putExtra("sms_body", edt_msg.getText().toString());
            startActivity(intent);
        } else if (v.getId() == R.id.msg_btn2) {
            intent = new Intent(MainActivity.this , TestActivity.class);
            intent.putExtra("strkey1",edt_msg2.getText().toString());
            startActivity(intent);
        } else if (v.getId() == R.id.int_btn) {
            intent = new Intent(MainActivity.this , TestActivity.class);
            intent.putExtra("intkey1", Integer.parseInt(edt_int.getText().toString()));
//            int intValue1 = intent.getIntExtra("intkey1",-1);
//            Log.d(TAG, "onClick: " + intValue1);
            startActivity(intent);
        } else if (v.getId() == R.id.send_btn) {
            intent = new Intent(MainActivity.this , TestActivity.class);

            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


}