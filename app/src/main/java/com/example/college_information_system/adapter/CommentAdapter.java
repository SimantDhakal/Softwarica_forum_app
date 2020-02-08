package com.example.college_information_system.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.college_information_system.R;
import com.example.college_information_system.modal.CommentModal;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder>{

    Context context;
    List<CommentModal> teamModalClasses;

    public CommentAdapter(Context context, List<CommentModal> teamModalClasses) {
        this.context = context;
        this.teamModalClasses = teamModalClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comment,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// getting data according to position
        final CommentModal CommentModal = teamModalClasses.get(position);

        holder.txt_email.setText(CommentModal.getEmail());
        holder.txt_comment.setText(CommentModal.getComment());
    }

    @Override
    public int getItemCount() {
        return teamModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_email,txt_comment;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt_email = itemView.findViewById(R.id.email);
            txt_comment = itemView.findViewById(R.id.comment);
        }
    }
}