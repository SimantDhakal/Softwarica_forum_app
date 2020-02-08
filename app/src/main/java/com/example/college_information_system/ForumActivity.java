package com.example.college_information_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.college_information_system.adapter.ForumAdapter;
import com.example.college_information_system.api_classes.BaseURL;
import com.example.college_information_system.api_classes.Interface;
import com.example.college_information_system.modal.ForumModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumActivity extends AppCompatActivity {

    RecyclerView recyclerViewForum;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        recyclerViewForum = findViewById(R.id.recyclerview_forum);
        getForum();
    }

    // event json
    public void getForum(){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<ForumModal>> modalClassCall = retrofitApiInterface.getForum();

        modalClassCall.enqueue(new Callback<List<ForumModal>>() {
            @Override
            public void onResponse(Call<List<ForumModal>> call, Response<List<ForumModal>>
                    response) {

                ForumAdapter blogAdapter = new ForumAdapter
                        (getApplicationContext(),response.body());
                // elevation design
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerViewForum.setLayoutManager(horizontalLayoutManager);
                recyclerViewForum.setHasFixedSize(true);
                recyclerViewForum.setAdapter(blogAdapter);
                blogAdapter.notifyDataSetChanged();

            }
            @Override
            public void onFailure(Call<List<ForumModal>> call, Throwable t) {
            }


        });
    }
    
}
