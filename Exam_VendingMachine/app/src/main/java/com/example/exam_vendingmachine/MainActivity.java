package com.example.exam_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //    TextView tv_name1, tv_name2, tv_name3, tv_name4, tv_cnt1, tv_cnt2, tv_cnt3, tv_cnt4;
//    Button btn_order1, btn_order2, btn_order3, btn_order4;

    ImageView iv;
    ArrayList<DrinkDTO> list = new ArrayList<>();
    ArrayList<ViewHolder> viewList = new ArrayList<>();
//    ArrayList<TextView> nameList = new ArrayList<>();
//    ArrayList<TextView> cntList = new ArrayList<>();


    //    int cola = 800, cider = 1000, fanta = 1200, plum = 1500;
//    int cntCola = 10, cntCider = 11, cntFanta = 12, cntPlum = 13;
    int user_money = 999999999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(new DrinkDTO("콜라", 800, 10));
        list.add(new DrinkDTO("사이다", 1000, 11));
        list.add(new DrinkDTO("환타", 1200, 12));
        list.add(new DrinkDTO("초록매실", 1500, 13));

        iv = findViewById(R.id.iv);
        viewList.add(new ViewHolder(findViewById(R.id.tv_name1), findViewById(R.id.tv_cnt1), findViewById(R.id.btn_order1)));
        viewList.add(new ViewHolder(findViewById(R.id.tv_name2), findViewById(R.id.tv_cnt2), findViewById(R.id.btn_order2)));
        viewList.add(new ViewHolder(findViewById(R.id.tv_name3), findViewById(R.id.tv_cnt3), findViewById(R.id.btn_order3)));
        viewList.add(new ViewHolder(findViewById(R.id.tv_name4), findViewById(R.id.tv_cnt4), findViewById(R.id.btn_order4)));

        for (int i = 0;  i < viewList.size(); i++) {
            final int idx = i;
            viewList.get(i).getBtn_order().setOnClickListener(v -> {
                iv.setImageResource(R.drawable.pepe);
                viewList.get(idx).getTv_cnt().setText("aaaaa");
            });

        }


//
//        nameList.add(findViewById(R.id.tv_name1));
//        nameList.add(findViewById(R.id.tv_name2));
//        nameList.add(findViewById(R.id.tv_name3));
//        nameList.add(findViewById(R.id.tv_name4));
//        cntList.add(findViewById(R.id.tv_cnt1));
//        cntList.add(findViewById(R.id.tv_cnt2));
//        cntList.add(findViewById(R.id.tv_cnt3));
//        cntList.add(findViewById(R.id.tv_cnt4));

//        btn_order1 = findViewById(R.id.btn_order1);
//        btn_order2 = findViewById(R.id.btn_order2);
//        btn_order3 = findViewById(R.id.btn_order3);
//        btn_order4 = findViewById(R.id.btn_order4);
//
//        btn_order1.setOnClickListener(new mbjOnClickListener(0));
//        btn_order2.setOnClickListener(new mbjOnClickListener(1));
//        btn_order3.setOnClickListener(new mbjOnClickListener(2));
//        btn_order4.setOnClickListener(new mbjOnClickListener(3));
    }

    @Override
    public void onClick(View v) {

    }

//    public class mbjOnClickListener implements View.OnClickListener {
//        private int index;
//
//        public mbjOnClickListener(int index) {
//            this.index = index;
//        }
//
//        @Override
//        public void onClick(View v) {
//            user_money -= list.get(index).getPrice();
//            list.get(index).setCnt(list.get(index).getCnt() - 1);
//            nameList.get(index).setText(list.get(index).getName() + "(" + list.get(index).getPrice() + ") 원");
//            cntList.get(index).setText(list.get(index).getCnt() + "개 남음");
//        }
//    }

}