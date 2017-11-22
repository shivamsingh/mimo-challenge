package com.example.mimo.network.account;

import com.example.mimo.entity.account.LoginRequest;
import com.example.mimo.entity.account.AccessToken;
import com.example.mimo.entity.account.SignUpRequest;
import com.example.mimo.entity.account.SignUpResponse;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by shivam on 19/11/17.
 */

public interface AuthService {

    @POST("oauth/ro")
    Call<AccessToken> login(@Body LoginRequest loginRequest);

    @POST("dbconnections/signup")
    Call<SignUpResponse> signUp(@Body SignUpRequest signUpRequest);
}
