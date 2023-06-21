package com.example.and09_fragmentadapter.listv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class AdapterListView extends BaseAdapter {
//    어댑터는 일반 클래스 + 기능이 있는정도 (반드시 화면에 보인다는 맥락이 없음 => LayoutInflater, Toast등의 기능 제한)
//    어댑터는 LayoutInflater가 기본적으로 필요한데, 해당하는 객체를 상위(나를 사용하는 지역)에서 받아 와야함.

    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public AdapterListView(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }


    @Override
    public int getCount() {


//        몇개의 아이템이 반복되는지, 총 리스트의 개수를 의미
        return list.size();
    }

    @Override
    public Object getItem(int position) {
//        목록을 보여줄 때 사용된 Object(DTO)가 있다면 해당하는 DTO를 리턴하기위한 메소드
        return position;
    }

    @Override
    public long getItemId(int position) {
//        아이템을 유일하게 식별 할 수 있는 값, position자체가 유일하기 때문에 그대로 return을 바꿔줌
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater를 이용해서 칸마다의 아이템을 붙이는 처리를 해줘야 함
        convertView = inflater.inflate(R.layout.item_listview, parent, false);
        ImageView img_profile = convertView.findViewById(R.id.imgv);
        img_profile.setImageResource(list.get(position).getImgRes());
        return convertView;
    }
}
