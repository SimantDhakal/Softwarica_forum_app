package com.example.college_information_system.api_classes;

import com.example.college_information_system.SignUpResponse;
import com.example.college_information_system.modal.BlogModal;
import com.example.college_information_system.modal.CommentModal;
import com.example.college_information_system.modal.EventModal;
import com.example.college_information_system.modal.ForumModal;
import com.example.college_information_system.modal.UserModal;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Interface {

    @GET("blog/")
    Call<List<BlogModal>> getBlog();

    @GET("event/")
    Call<List<EventModal>> getEvent();

    @GET("forum/")
    Call<List<ForumModal>> getForum();

    //register user
    @POST("register/register_user")
    Call<Void> registerEmployee(@Body UserModal usersCUD);

    //for logging into the system
    @FormUrlEncoded
    @POST("register/login_user")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);

    @GET("register/me")
    Call<UserModal> getUserInfo(@Header("Authorization")String token);

    // comment data here
    @GET("comment/")
    Call<List<CommentModal>> loadComment(@Query("forumId") String id);

}
