package com.example.project01_mbjtalk.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_mbjtalk.databinding.ItemFriendRecvBinding;

import java.util.ArrayList;


public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {

    ItemFriendRecvBinding binding;
    ArrayList<FriendDTO> list;

    public FriendAdapter(ArrayList<FriendDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); // 리사이클러에서만 가능
        binding = ItemFriendRecvBinding.inflate(inflater, parent, false);
        return new FriendViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        holder.binding.imgvProfile.setImageResource(list.get(position).getResImgId());
        holder.binding.tvName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class FriendViewHolder extends RecyclerView.ViewHolder {
        ItemFriendRecvBinding binding;

        public FriendViewHolder(@NonNull ItemFriendRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
