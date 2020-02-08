package com.example.college_information_system;

import com.example.college_information_system.api_classes.BaseURL;
import com.example.college_information_system.api_classes.Interface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    boolean isSuccess = false;

    public boolean checkuser(String email, String password) {

        Interface Interface = BaseURL.getInstance().create(Interface.class);
        Call<SignUpResponse> usersCall = Interface.checkUser(email, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {
                BaseURL.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}