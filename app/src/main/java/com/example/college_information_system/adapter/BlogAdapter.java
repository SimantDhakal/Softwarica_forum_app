package com.example.college_information_system.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.college_information_system.R;
import com.example.college_information_system.modal.BlogModal;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.MyViewHolder>{

    Context context;
    List<BlogModal> teamModalClasses;

    public BlogAdapter(Context context, List<BlogModal> teamModalClasses) {
        this.context = context;
        this.teamModalClasses = teamModalClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_blog_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// getting data according to position
        final BlogModal BlogModal = teamModalClasses.get(position);

        holder.textView_title.setText(BlogModal.getBlogTitle());
        holder.textView_source.setText(BlogModal.getPostedby());
        holder.textView_desc.setText(BlogModal.getBlogDes());

        Glide.with(context)
                .load(BlogModal.getBlogImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView_blogImage);
    }

    @Override
    public int getItemCount() {
        return teamModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_title,textView_source,textView_desc;
        ImageView imageView_blogImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.txtTitle);
            textView_source = itemView.findViewById(R.id.txtSource);
            imageView_blogImage = itemView.findViewById(R.id.blogImage);
            textView_desc = itemView.findViewById(R.id.txtDesc);
        }
    }
}