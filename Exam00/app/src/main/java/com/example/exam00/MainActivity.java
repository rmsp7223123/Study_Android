package com.example.exam00;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = findViewById(R.id.tv_1);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        CalcDAO dao = new CalcDAO();
        tv1.setText(dao.getSum(4, 5) + "");
        btn1.setText(dao.getSum(2, 3) + "");

        btn2.setOnClickListener(new MbjOnClick());
    }


    public class MbjOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Log.d("123123213", "onClick: " + "dfadfdsafsadf");
        }
    }


}