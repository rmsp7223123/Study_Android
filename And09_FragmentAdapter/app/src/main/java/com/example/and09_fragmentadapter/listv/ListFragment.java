package com.example.and09_fragmentadapter.listv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ArrayList<ListDTO> list = new ArrayList<>();

    ListView listv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        list.add(new ListDTO(R.drawable.pepe1, "이름1" , "메시지1"));
        list.add(new ListDTO(R.drawable.pepe2, "이름2" , "메시지2"));
        list.add(new ListDTO(R.drawable.pepe3, "이름3" , "메시지3"));
        list.add(new ListDTO(R.drawable.pepe4, "이름4" , "메시지4"));
        list.add(new ListDTO(R.drawable.pepe5, "이름5" , "메시지5"));
        list.add(new ListDTO(R.drawable.pepe6, "이름6" , "메시지6"));
        list.add(new ListDTO(R.drawable.pepe7, "이름7" , "메시지7"));


        listv = v.findViewById(R.id.listv);
        AdapterListView adapter = new AdapterListView(inflater , list   );
        listv.setAdapter(adapter);
        return v;
    }
}