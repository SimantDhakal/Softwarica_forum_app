package com.example.college_information_system.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.college_information_system.R;
import com.example.college_information_system.ViewPagerAdapter;
import com.example.college_information_system.adapter.BlogAdapter;
import com.example.college_information_system.adapter.EventAdapter;
import com.example.college_information_system.api_classes.BaseURL;
import com.example.college_information_system.api_classes.Interface;
import com.example.college_information_system.modal.BlogModal;
import com.example.college_information_system.modal.EventModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    RecyclerView recyclerViewBlog, recyclerViewEvent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewBlog = root.findViewById(R.id.recyclerview_blog);
        recyclerViewEvent = root.findViewById(R.id.recyclerview_event);
        
        viewPager = (ViewPager) root.findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout) root.findViewById(R.id.SliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // call functions
        getBlog();
        getEvent();

        return root;
    }

    // news json
    public void getBlog(){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<BlogModal>> modalClassCall = retrofitApiInterface.getBlog();

        modalClassCall.enqueue(new Callback<List<BlogModal>>() {
            @Override
            public void onResponse(Call<List<BlogModal>> call, Response<List<BlogModal>>
                    response) {

                System.out.println("Blog " + response.body());
                BlogAdapter blogAdapter = new BlogAdapter(getActivity(),response.body());
                // elevation design
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerViewBlog.setLayoutManager(horizontalLayoutManager);
                recyclerViewBlog.setHasFixedSize(true);
                recyclerViewBlog.setAdapter(blogAdapter);
                blogAdapter.notifyDataSetChanged();

            }
            @Override
            public void onFailure(Call<List<BlogModal>> call, Throwable t) {
            }


        });
    }

    // event json
    public void getEvent(){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<EventModal>> modalClassCall = retrofitApiInterface.getEvent();

        modalClassCall.enqueue(new Callback<List<EventModal>>() {
            @Override
            public void onResponse(Call<List<EventModal>> call, Response<List<EventModal>>
                    response) {

                EventAdapter blogAdapter = new EventAdapter
                        (getActivity(),response.body());
                // elevation design
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerViewEvent.setLayoutManager(horizontalLayoutManager);
                recyclerViewEvent.setHasFixedSize(true);
                recyclerViewEvent.setAdapter(blogAdapter);
                blogAdapter.notifyDataSetChanged();

            }
            @Override
            public void onFailure(Call<List<EventModal>> call, Throwable t) {
            }


        });
    }

}