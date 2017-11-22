package com.example.mimo.model.auth.remote;

import com.example.mimo.entity.account.AccessToken;
import com.example.mimo.entity.account.LoginRequest;
import com.example.mimo.entity.account.SignUpRequest;
import com.example.mimo.entity.account.SignUpResponse;
import com.example.mimo.model.auth.AuthRepository;
import com.example.mimo.model.ResponseCallback;
import com.example.mimo.model.remote.entity.RemoteResponseCallback;
import com.example.mimo.network.NetworkCredentials;
import com.example.mimo.network.account.AuthService;

import javax.inject.Inject;

public class RemoteAuthRepository implements AuthRepository {

    @Inject
    AuthService authService;
    @Inject
    NetworkCredentials networkCredentials;

    @Inject
    public RemoteAuthRepository() {
    }

    @Override
    public void login(String username, String password, ResponseCallback<AccessToken> responseCallback) {
        authService.login(loginRequest(username, password))
                .enqueue(new RemoteResponseCallback<>(responseCallback));
    }

    @Override
    public void signup(String email, String password, ResponseCallback<SignUpResponse> responseCallback) {
        authService.signUp(signupRequest(email, password))
                .enqueue(new RemoteResponseCallback<>(responseCallback));
    }

    private LoginRequest loginRequest(String username, String password) {
        return new LoginRequest(
                username, password, networkCredentials.getClientId(),
                networkCredentials.getConnection(), networkCredentials.getGrantType(),
                networkCredentials.getScope()
        );
    }

    private SignUpRequest signupRequest(String username, String password) {
        return new SignUpRequest(
                username, password, networkCredentials.getClientId(),
                networkCredentials.getConnection(), networkCredentials.getGrantType(),
                networkCredentials.getScope()
        );
    }
}
