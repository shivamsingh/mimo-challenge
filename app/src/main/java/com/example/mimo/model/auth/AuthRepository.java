package com.example.mimo.model.auth;

import com.example.mimo.entity.account.AccessToken;
import com.example.mimo.entity.account.SignUpResponse;
import com.example.mimo.model.ResponseCallback;

public interface AuthRepository {
    void login(String username, String password, ResponseCallback<AccessToken> responseCallback);

    void signup(String email, String password, ResponseCallback<SignUpResponse> responseCallback);
}
