package com.example.and09_fragmentadapter.melon;

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

public class MelonAdapter extends RecyclerView.Adapter<MelonAdapter.ViewHolder2> {

    LayoutInflater inflater;

    public MelonAdapter(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    ArrayList<MelonDTO> list;


    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_melon, parent, false);
        return new ViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        holder.img_album.setImageResource(list.get(position).getImgRes());
        holder.tv_rank.setText(list.get(position).getRank() + "");
        holder.tv_singer.setText(list.get(position).getSinger());
        holder.tv_song.setText(list.get(position).getSong());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        ImageView img_album;
        TextView tv_rank, tv_song, tv_singer;
        Button btn_play;

        public ViewHolder2(@NonNull View v) {
            super(v);
            img_album = v.findViewById(R.id.img_album);
            tv_rank = v.findViewById(R.id.tv_rank);
            tv_song = v.findViewById(R.id.tv_song);
            tv_singer = v.findViewById(R.id.tv_singer);
        }

    }
}
