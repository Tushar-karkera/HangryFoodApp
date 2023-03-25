package com.example.hangryapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);
        submit = findViewById(R.id.submit_login);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser(createRequest());
            }
        });

    }

    public UserRequest createRequest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName(username.getText().toString());
        userRequest.setPassword(password.getText().toString());

        return userRequest;
    }

    public void saveUser(UserRequest userRequest){
        Call<UserResponse> userResponseCall = ApiClient.getUserService().saveUsers(userRequest);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    if(response.body().getResponse().equals("true")){
                        Toast.makeText(login.this, "successfully logged in "+response.body().getResponse(), Toast.LENGTH_SHORT).show();
                        Intent dashboard = new Intent(login.this,dashboard_redesigned.class);
                        dashboard.putExtra("userName",username.getText().toString());
                        startActivity(dashboard);
                        finish();
                    }else{
                        Toast.makeText(login.this, "failed to logged in "+response.body().getResponse(), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(login.this, "request failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(login.this, "request failed "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }
}