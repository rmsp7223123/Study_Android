package com.example.and05_etclayoutscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Attr;

public class MainActivity extends AppCompatActivity {

    TextView tv_text;
    Button btn;

    HorizontalScrollView horizon_scroll;
    ScrollView scv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scv = findViewById(R.id.scv);
        tv_text = findViewById(R.id.tv_text);
        btn = findViewById(R.id.btn);
        horizon_scroll = findViewById(R.id.horizon_scroll);

        for (int i = 0; i < 50; i++) {
            for(int j = 0; j< 20; j++ ) {
                tv_text.append("안녕하세요");
            }
            tv_text.append("안녕하세요2"+i+"\n");
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("스크롤", "getScrollY :" + scv.getScrollY());
                scv.scrollTo(0,scv.getScrollY()+100);
                horizon_scroll.smoothScrollTo(horizon_scroll.getScrollX()+100, 0);
            }
        });
    }
}