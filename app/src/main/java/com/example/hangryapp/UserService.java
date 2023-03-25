package com.example.hangryapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("user/verify")
    Call<UserResponse> saveUsers(@Body UserRequest userRequest);
}
