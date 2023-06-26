package com.example.project01_mbjtalk.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_mbjtalk.databinding.ItemChatRecvBinding;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    ItemChatRecvBinding binding;

    ArrayList<ChatDTO> list;

    public ChatAdapter(ArrayList<ChatDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemChatRecvBinding.inflate(inflater, parent,false);
        return new ChatViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.binding.imgvChat.setImageResource(list.get(position).getImgRes());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.tvCnt.setText(list.get(position).getCnt());
        holder.binding.tvDate.setText(list.get(position).getDate());
        holder.binding.tvContent.setText(list.get(position).getMsg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        ItemChatRecvBinding binding;

        public ChatViewHolder(@NonNull ItemChatRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
