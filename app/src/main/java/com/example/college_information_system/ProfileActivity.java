package com.example.college_information_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.college_information_system.api_classes.BaseURL;
import com.example.college_information_system.api_classes.Interface;
import com.example.college_information_system.modal.UserModal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    TextView txtFirstName, txtSecondName, txtEmail, txtPhone, txtAddress;
    UserModal userModal;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        
        txtFirstName = findViewById(R.id.txtFirstName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtAddress = findViewById(R.id.etAddress);
        reqUser();
    }

    private void reqUser(){
        Interface interfaces = BaseURL.getInstance().create(Interface.class);
        Call<UserModal> userCall = interfaces.getUserInfo(BaseURL.token);
        Toast.makeText(getApplicationContext(), "" + BaseURL.token, Toast.LENGTH_SHORT).show();
        userCall.enqueue(new Callback<UserModal>() {
            @Override
            public void onResponse(Call<UserModal> call, Response<UserModal> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                userModal = response.body();
                txtFirstName.setText(response.body().getFname());
                txtEmail.setText(response.body().getEmail());
                txtAddress.setText(response.body().getAddress());
                txtPhone.setText(response.body().getPhone());
            }

            @Override
            public void onFailure(Call<UserModal> call, Throwable t) {
                Log.d("My message", "onFaliure" + t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}