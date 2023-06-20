package com.example.and08_layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //    인플레이션 과정의 작업을 해주는 객체 (레이아웃인플레이터 : 메모리에 디자인 파일을 올려줌)
    LayoutInflater inflater;
    LinearLayout container_linear;
    FrameLayout container_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 내부적으로 inflater 객체가 이미 인플레이션 과정을 자동으로 해줌
        container_linear = findViewById(R.id.container_linear);
        container_frame = findViewById(R.id.container_frame);
        inflater = getLayoutInflater();
        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View vLinear = inflater.inflate(R.layout.sub_layout1, container_linear, true);
        View vFrame = inflater.inflate(R.layout.sub_layout2, container_frame, true);
//        attachToRoot : 1. 지금바로 붙이겠음 2. 내 리소스를 현재 화면의 리소스에 붙일건지
//        코드부를 별도로 가지고 있는, 액티비티와 유사하게 디자인파일(xml), 코드파일(java)를 별도로 가지고 붙이는 처리를 알아서하는
//        Fragment라는 것을 쓰기 때문에 attachToRoot를 true로 쓰지 않음
        Button btn_sub1 = vLinear.findViewById(R.id.sub1);
        Button btn_sub2 = vFrame.findViewById(R.id.sub2);
        Button btn1 = findViewById(R.id.btn_1);

        btn1.setOnClickListener(v -> {
            container_linear.removeView(btn1);
            inflater.inflate(R.layout.sub_layout1, container_linear, true);
        });

        btn_sub1.setOnClickListener(v -> {
            Toast.makeText(this, "서브1에 있는 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
            container_linear.removeAllViews();
            container_linear.addView(btn1);
        });
        btn_sub2.setOnClickListener(v -> {
            Toast.makeText(this, "서브2에 있는 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
            container_frame.removeAllViews();
        });
    }



}