package com.example.and01_constlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    1. res하위에 id를 부여하거나 파일을 만들게 되면 모두 R.java라는 하나의 클래스에서 관리가 됨(리소스 Class)
//    2. layout에서 만든 모든 위젯(뷰)들은 자바 클래스로 존재한다. (객체)
//    클래스는 대문자로 시작(upper casing) : ImageView, Button
    ImageView imgv_mbj; // 전역 변수 선언 초기상태 (null)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        context는 화면에 보이는 기능을 사용할 때 화면에 보이는 클래스 인지를 판단
//        Activity의 경우 무조건 화면에 보이기 때문에 this를 써주면 됨
        ConstraintLayout layout = new ConstraintLayout(this);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );
        ConstraintLayout.LayoutParams tvParams = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );

        tvParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
        tvParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
        tvParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;


        layout.setLayoutParams(params);

        TextView tv = new TextView(this);
        tv.setText("글자 추가확인");
        tv.setLayoutParams(tvParams);
        layout.addView(tv);


        setContentView(layout); // <= R클래스로 존재하는 layout내부에 있는 모든것들을 java에서 사용할 수있게 연결
//        new로 초기화는 새로 인스턴스화
//        디자인 파일에 이미 존재하는 객체 ImageView를 내가 선언한 변수와 연결, 대입 (초기화 식)
//        태그에 있는것을 아이디를 찾을 때 썼던 자바스크립트 함수 ==>
//        imgv_mbj=findViewById(R.id.imgv_mbj); // @IdRes == R클래스에서 내용을 찾아 넣어주세요 ctrl + p
//
////        인터페이스 옵저버 패턴
//        imgv_mbj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "이미지뷰가 눌림(클릭)",Toast.LENGTH_SHORT).show();
//            }
//        });

//        Interface 사용 => 클래스의 설계도 개념 : Spring MVC interface->Serviceimp->Dao->....
//        옵저버 패턴 : 인터페이스는 내부에 만들어둔 메소드를 반드시 구현해야하는 속성이 있다 (abstract)
//        인터페이스를 파라미터로 입력받게 만들고, 특정한 처리가 일어나면 내부에 구현해놓은 메소드를 대신 실행

//        MbjOnClickListener onClickListener = new MbjOnClickListener() {
//            @Override
//            public void onClick(String data) {
//                Toast.makeText(MainActivity.this, "메소드 실행되었습니다. Mbj", Toast.LENGTH_SHORT).show();
//            }
//        };
//        메소드는 호출 되어야만 실행이 됨
//        onClickListener.onClick("데이터");

//        setOnclickListener(new MbjOnClickListener() {
//            @Override
//            public void onClick(String data) {
//
//            }
//        });
    }
//
//    public void setOnclickListener(MbjOnClickListener onClickListener) {
//
//    }

//    public interface MbjOnClickListener {
//        public void onClick(String data);
//
//    }
}