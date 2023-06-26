package com.example.project01_mbjtalk.friend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_mbjtalk.MainActivity;
import com.example.project01_mbjtalk.databinding.ItemFriendRecvBinding;

import java.util.ArrayList;


public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {

    ItemFriendRecvBinding binding;
    ArrayList<FriendDTO> list;

    Intent intent;

    Context context;

    public FriendAdapter(ArrayList<FriendDTO> list, Context context) {
        this.list = list;
        this.context = context;
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
//        리사이클러뷰의 칸마다 데이터 연결이나 이벤트 연결을 하는 메소드
        holder.binding.imgvProfile.setImageResource(list.get(position).getResImgId());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.lnFriend.setOnClickListener(v -> {
            intent = new Intent(context, FriendDetailActivity.class);
            intent.putExtra("dto", list.get(position));
            context.startActivity(intent);
        });

        String[] dialogItems = {"즐겨찾기에 추가", "이름 변경", "숨김", "차단"};
        holder.binding.lnFriend.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(list.get(position).getName()); // 제목
            builder.setItems(dialogItems, ((dialog, idx) -> {
                if(dialogItems[idx].equals("차단")) {
                    list.remove(position);
                    notifyDataSetChanged();
//                    adapter에 있는 메소드 notifyDataSetChanged(); <= 내부에 있는 리스트가 바뀌면
//                    바뀌었다는것을 어댑터에 전달하고 어댑터는 내용을 다시 그림
                    dialog.dismiss(); // dialog를 안보이게 처리
                }
            }));

            builder.create().show();
            return true;
        });
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
