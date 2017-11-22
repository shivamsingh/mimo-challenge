package com.example.mimo.ui.login;

import com.example.mimo.di.scope.ActivityScoped;
import com.example.mimo.entity.account.AccessToken;
import com.example.mimo.model.auth.AuthRepository;
import com.example.mimo.model.ResponseCallback;

import javax.annotation.Nullable;
import javax.inject.Inject;

@ActivityScoped
public class LoginPresenter implements LoginContract.Presenter {

    private AuthRepository authRepository;
    @Nullable
    private LoginContract.View loginView;

    @Inject
    public LoginPresenter(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
    }

    @Override
    public void login(String username, String password) {
        loginView.setLoadingIndicator(true);
        authRepository.login(username, password, new ResponseCallback<AccessToken>() {
            @Override
            public void onSuccess(AccessToken accessToken) {
                loginView.setLoadingIndicator(false);
                loginView.showLoginSuccessful(accessToken);
            }

            @Override
            public void onFailure(String error) {
                loginView.setLoadingIndicator(false);
                loginView.showLoginError(error);
            }
        });
    }

    @Override
    public void takeView(LoginContract.View view) {
        loginView = view;
    }

    @Override
    public void dropView() {
        loginView = null;
    }
}
