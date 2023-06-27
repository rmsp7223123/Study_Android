package com.example.project01_mbjtalk.opentalk;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

//    FragmentStateAdapter <= 프래그먼트와 뷰페이저2 & 리사이클러뷰와 세트로 많이 사용되는 어댑터
public class FragmentAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> list;

    public FragmentAdapter(@NonNull Fragment fragment, ArrayList<Fragment> list) {
        super(fragment);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
