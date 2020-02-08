package com.example.college_information_system.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.college_information_system.DetailForumActivity;
import com.example.college_information_system.R;
import com.example.college_information_system.modal.ForumModal;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.MyViewHolder>{

    Context context;
    List<ForumModal> teamModalClasses;

    public ForumAdapter(Context context, List<ForumModal> teamModalClasses) {
        this.context = context;
        this.teamModalClasses = teamModalClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_forum_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// getting data according to position
        final ForumModal ForumModal = teamModalClasses.get(position);

        holder.textView_title.setText(ForumModal.getForumTitle());
        holder.textView_source.setText(ForumModal.getPostedby());
        holder.textView_desc.setText(ForumModal.getForumDces());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set ground id to fetch data
                DetailForumActivity.id = ForumModal.getForumID();
                Intent intent = new Intent(context, DetailForumActivity.class);
                intent.putExtra("forum_title",ForumModal.getForumTitle());
                intent.putExtra("forum_desc",ForumModal.getForumDces());
                intent.putExtra("source",ForumModal.getPostedby());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_title,textView_source,textView_desc;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.txtTitle);
            textView_source = itemView.findViewById(R.id.txtSource);
            textView_desc = itemView.findViewById(R.id.txtDesc);
        }
    }
}