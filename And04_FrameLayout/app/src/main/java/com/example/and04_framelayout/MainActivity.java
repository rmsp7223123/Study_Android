package com.example.and04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btn_change, btn_change2;
//    ImageView imgv1, imgv2, imgv3;

    ArrayList<ImageView> imageList = new ArrayList<>();

    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
//        res하위에 있는 모든것들은 R이라는 클래스로 묶임
        btn_change = findViewById(R.id.btn_change);
        btn_change2 = findViewById(R.id.btn_change2);
//        imgv1 = findViewById(R.id.imgv1);
//        imgv2 = findViewById(R.id.imgv2);
//        imgv3 = findViewById(R.id.imgv3);

        imageList.add(findViewById(R.id.imgv1));
        imageList.add(findViewById(R.id.imgv2));
        imageList.add(findViewById(R.id.imgv3));

//        if(imgv1 == null || imgv2 == null || imgv3 == null || btn_change == null) {
//            Log.d("NullCheck", "null이 섞여있음");
//        } else {
//            Log.d("NullCheck", "null이 없음 초기화 완료");
//        }

//        1. 직접 인터페이스를 인스턴스화하여 파라미터로 넘기는 방법
//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("버튼", "버튼이 눌림");
//            }
//        };

//        2. 인터페이스를 초기화 할 수 있는 new 생성자로 파라미터를 넘기는 방법
//        btn_change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("버튼", "버튼이눌림");
//            }
//        });

//        btn_change.setOnClickListener(this);

        
//        4. 자바의 인터페이스 단점을 보완 => lamda (람다식, 함수형으로 new나 불필요한 코드를 생략하고 사용하는 방법)
//        인터페이스의 abstract메소드가 1개의 경우만 사용가능(인터페이스의 내부 구조를 모르면 사용이 불가능)
        
//        btn_change.setOnClickListener(v->{ // 인터페이스가 주는 파라미터를 (v) 써주고 메소드 지역을 -> 가르킴 {}
//            Log.d("버튼", "감지");
//        });


        btn_change2.setOnClickListener(this);
        btn_change.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                flag ++;
//                if (flag == 1) {
//                    imgv3.setVisibility(View.GONE);
//                    imgv1.setVisibility(View.VISIBLE);
//                    imgv2.setVisibility(View.VISIBLE);
//
//                } else if ( flag == 2) {
//                    imgv2.setVisibility(View.GONE);
//                    imgv3.setVisibility(View.GONE);
//                    imgv1.setVisibility(View.VISIBLE);
//                } else {
//                    imgv1.setVisibility(View.GONE);
//                    imgv2.setVisibility(View.GONE);
//                    imgv3.setVisibility(View.VISIBLE);
//                    flag = 0;
//                }

                flag --;
                if (flag == -1) {
                    flag = 2;
                }
                changeImage();
                Log.d("로그", "변수 Flag : " + flag);
            }
        });
    }

//    3. 인터페이스를 상속받는 방법
//    SpringMVC의 경우에 DAO 또는 Service가 반드시 구현 해야만 하는 메소드의 형태를 만들어서 설계도 개념 으로 사용
//    Android <- 다형성을 이용한 방법 : View.OnClickListener <= onClick이라는 메소드를 반드시 가지고있음
//                                      View.OnClickListener 라는 것을 상속 받은 Class는 == ViewOnClickListener와 같다가 성립
    @Override
    public void onClick(View v) {
        flag ++;
        Log.d("버튼", "인터페이스 상속받아서 버튼 눌림을 감지");
//        imgv3.setVisibility(View.GONE);
//        if(flag == 1) {
//            imgv1.setVisibility(View.VISIBLE);
//            imgv2.setVisibility(View.VISIBLE);
//            imgv3.setVisibility(View.GONE);
//        }
//        else if (flag == 2) {
//            imgv1.setVisibility(View.VISIBLE);
//            imgv2.setVisibility(View.GONE);
//            imgv3.setVisibility(View.GONE);
//        }
//        else {
//            imgv1.setVisibility(View.GONE);
//            imgv2.setVisibility(View.GONE);
//            imgv3.setVisibility(View.VISIBLE);
//            flag = 0;
//        }
        for (int i = 0; i <imageList.size() ; i++) {
            imageList.get(i).setVisibility(View.GONE);
        }
        if (flag == imageList.size()) {
            flag  = 0;
        }
        imageList.get(flag).setVisibility(View.VISIBLE);
    }

    public void changeImage() {
        for(int i = 0; i<imageList.size(); i++) {
            imageList.get(i).setVisibility(View.GONE);
        }
        imageList.get(flag).setVisibility(View.VISIBLE);
    }
}