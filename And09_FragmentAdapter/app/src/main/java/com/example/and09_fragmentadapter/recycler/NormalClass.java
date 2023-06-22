package com.example.and09_fragmentadapter.recycler;

import android.content.Context;
import android.widget.Toast;

public class NormalClass {
    public void testToast(String msg, Context context) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
