package com.example.project01_sbntalk.exam;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.project01_sbntalk.databinding.ItemFriendRecvBinding;

public class MBJAdapter extends MBJAdapterParent.MbjAdapter<MBJAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder() {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends MBJAdapterParent.MbjViewHolder {

        protected ViewHolder(@NonNull View view) {
            super(view);
        }
    }
}
