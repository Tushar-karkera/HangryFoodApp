package com.example.hangryapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterUserService {
    @POST("user")
    Call<UserResponse> saveUsers(@Body UserRequest userRequest);
}
