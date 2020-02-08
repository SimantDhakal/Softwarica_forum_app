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
import com.example.college_information_system.modal.EventModal;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder>{

    Context context;
    List<EventModal> teamModalClasses;

    public EventAdapter(Context context, List<EventModal> teamModalClasses) {
        this.context = context;
        this.teamModalClasses = teamModalClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_event_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// getting data according to position
        final EventModal EventModal = teamModalClasses.get(position);

        holder.textView_title.setText(EventModal.getEventTitle());
        holder.textView_source.setText(EventModal.getPostedby());
        holder.textView_desc.setText(EventModal.getEventDes());

        Glide.with(context)
                .load(EventModal.getEventImage())
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