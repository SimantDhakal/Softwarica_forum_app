package com.example.college_information_system.ui.gallery;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.college_information_system.R;
import com.example.college_information_system.adapter.ForumAdapter;
import com.example.college_information_system.api_classes.BaseURL;
import com.example.college_information_system.api_classes.Interface;
import com.example.college_information_system.modal.ForumModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    RecyclerView recyclerView_forum;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView_forum = root.findViewById(R.id.recyclerview_forum);
        getEvent();
        return root;
    }

    // event json
    public void getEvent(){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<ForumModal>> modalClassCall = retrofitApiInterface.getForum();

        modalClassCall.enqueue(new Callback<List<ForumModal>>() {
            @Override
            public void onResponse(Call<List<ForumModal>> call, Response<List<ForumModal>>
                    response) {

                ForumAdapter blogAdapter = new ForumAdapter
                        (getActivity(),response.body());
                // elevation design
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerView_forum.setLayoutManager(horizontalLayoutManager);
                recyclerView_forum.setHasFixedSize(true);
                recyclerView_forum.setAdapter(blogAdapter);
                blogAdapter.notifyDataSetChanged();

            }
            @Override
            public void onFailure(Call<List<ForumModal>> call, Throwable t) {
            }


        });
    }
}