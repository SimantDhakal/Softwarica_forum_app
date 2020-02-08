package com.example.college_information_system;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.example.college_information_system.adapter.CommentAdapter;
import com.example.college_information_system.api_classes.BaseURL;
import com.example.college_information_system.api_classes.Interface;
import com.example.college_information_system.modal.CommentModal;
import com.example.college_information_system.modal.ForumModal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailForumActivity extends AppCompatActivity {

    public static String id = null;
    public String forumID = "5e3e756eed6b022434b4cd4f";
    TextView textView_title, textView_desc;
    RecyclerView recyclerView_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_forum);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(getApplicationContext(), "Id is " + id, Toast.LENGTH_LONG).show();

        Bundle val = getIntent().getExtras();
        String _title = val.getString("forum_title");
        String _desc = val.getString("forum_desc");

        textView_title = findViewById(R.id.txt_forum_title);
        textView_desc = findViewById(R.id.txt_desc);

        textView_title.setText(_title);
        textView_desc.setText(_desc);
        recyclerView_comment = findViewById(R.id.recyclerview_comment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getComment(id.toString());

    }

    public void getComment(String forumID){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<CommentModal>> modalClassCall = retrofitApiInterface.loadComment(id);

        modalClassCall.enqueue(new Callback<List<CommentModal>>() {
            @Override
            public void onResponse(Call<List<CommentModal>> call, Response<List<CommentModal>>
                    response) {
                System.out.println("Api not get : "+response.body());
                CommentAdapter recyclerviewAdapter = new CommentAdapter
                        (getApplicationContext(),response.body());
                // elevation design
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerView_comment.setLayoutManager(horizontalLayoutManager);
                recyclerView_comment.setHasFixedSize(true);
                recyclerView_comment.setItemAnimator(new DefaultItemAnimator());
                recyclerView_comment.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<CommentModal>> call, Throwable t) {
            }

        });
    }

}
