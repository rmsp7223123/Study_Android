package com.example.and09_fragmentadapter.recycler;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

//2. extends로 AdapterClass를 상속받음
public class AdapterRecv extends RecyclerView.Adapter<AdapterRecv.MbjViewHolder> {

    LayoutInflater inflater;

    ArrayList<RecyclerDTO> list;

    public AdapterRecv(LayoutInflater inflater, ArrayList<RecyclerDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public MbjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//  레이아웃을 붙이고 (View) 해당하는 타입으로 ViewHolder를 만들어내는 과정의 메소드
        View v = inflater.inflate(R.layout.item_recv, parent, false);
        return new MbjViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MbjViewHolder holder, int position) {
//  ViewHolder와 Data 연결(디자인 <=>ArrayList)
        holder.imgv_profile.setImageResource(list.get(position).getImgRes());
        holder.tv_address.setText(list.get(position).getAddress());
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_age.setText(list.get(position).getAge() + "");
        holder.tv_gender.setText(list.get(position).getGender());
    }

    @Override
    public int getItemCount() {
        // 총 아이템의 개수
        return list.size();
    }

    //1. InnerClass로 ViewHolder를 먼저 만듦
    public class MbjViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_profile;
        TextView tv_gender, tv_name, tv_age, tv_address;
        Button btn_detail;

        public MbjViewHolder(@NonNull View v) {
            super(v);
            imgv_profile = v.findViewById(R.id.imgv_profile);
            tv_gender = v.findViewById(R.id.tv_gender);
            tv_name = v.findViewById(R.id.tv_name);
            tv_age = v.findViewById(R.id.tv_age);
            tv_address = v.findViewById(R.id.tv_address);
            btn_detail = v.findViewById(R.id.btn_detail);
        }
    }
}
