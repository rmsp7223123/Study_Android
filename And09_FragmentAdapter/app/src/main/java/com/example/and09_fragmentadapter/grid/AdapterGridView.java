package com.example.and09_fragmentadapter.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and09_fragmentadapter.R;

public class AdapterGridView extends BaseAdapter {

    LayoutInflater inflater;

    public AdapterGridView(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_gridv, parent, false);
        return convertView;
    }


    public class ViewHolder {//위젯용 DTO
        //item_listview에 있는 모든 위젯을 찾아 넣어둠
        ImageView imgv;
        TextView tv_name;

        View v;

        public ViewHolder(View v) {
            this.v = v;
            imgv = v.findViewById(R.id.imgv);
            tv_name = v.findViewById(R.id.tv1);
        }


    }
}
