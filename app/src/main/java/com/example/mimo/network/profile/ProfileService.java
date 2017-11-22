package com.example.mimo.network.profile;

import com.example.mimo.entity.profile.User;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfileService {

    @GET("userinfo")
    Call<User> profile();
}
