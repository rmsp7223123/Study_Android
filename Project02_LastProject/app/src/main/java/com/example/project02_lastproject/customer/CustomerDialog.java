package com.example.project02_lastproject.customer;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;

public class CustomerDialog extends Dialog {

    public CustomerDialog(@NonNull Context context, CustomerVO customerVO) {
        super(context);
        setContentView(R.layout.dialog_customer);

        EditText edt_name = findViewById(R.id.edt_name);
        EditText edt_phone = findViewById(R.id.edt_phone);
        EditText edt_email = findViewById(R.id.edt_email);
        Button btn_submit = findViewById(R.id.btn_submit);

        if (customerVO == null) {
            btn_submit.setOnClickListener(v -> {
                CommonConn conn = new CommonConn("insert.cu", context);
                conn.addParamMap("id", customerVO.getId());
                conn.addParamMap("name", edt_name.getText().toString());
                conn.addParamMap("phone", edt_phone.getText().toString());
                conn.addParamMap("email", edt_email.getText().toString());
                conn.onExcute(new CommonConn.MbjCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {

                    }
                });
                dismiss();
            });
        } else {
            btn_submit.setText("수정하기");
            edt_name.setText(customerVO.getName());
            edt_phone.setText(customerVO.getPhone());
            edt_email.setText(customerVO.getEmail());
            btn_submit.setOnClickListener(v -> {
                CommonConn conn = new CommonConn("insert.cu", context);
                conn.addParamMap("name", edt_name.getText().toString());
                conn.addParamMap("phone", edt_phone.getText().toString());
                conn.addParamMap("email", edt_email.getText().toString());
                conn.onExcute(new CommonConn.MbjCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {

                    }
                });
                dismiss();
            });
        }

    }
}
