package com.example.and09_fragmentadapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


//Fragment에서 제일 중요한 메소드 : onCreateView

public class HomeFragment extends Fragment {

    EditText edt_text;

    Button btn_text;

    TextView tv_result;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        edt_text = v.findViewById(R.id.edt_text);
        btn_text = v.findViewById(R.id.btn_text);
        tv_result = v.findViewById(R.id.tv_result);

        btn_text.setOnClickListener(v1 -> {
            tv_result.setText(edt_text.getText().toString());
            edt_text.setText(null);
        });
        return v;
    }
}