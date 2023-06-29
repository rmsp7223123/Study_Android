package com.example.project01_sbntalk.exam;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class MBJAdapterParent {

    public abstract static class MbjAdapter<MVH extends MbjViewHolder> {
        public abstract MVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

        public abstract void onBindViewHolder();

        public abstract int getItemCount();
    }

    public abstract static class MbjViewHolder {
        @NonNull
//        상수의 규칙
//        1. 상수를 선언과 동시에 값 할당 ==> 초기화 해놓는 방법
//        2. 생성자를 이용해서 초기화 하는 방법
        final View view;

        protected MbjViewHolder(@NonNull View view) {
            this.view = view;
        }
    }
}
