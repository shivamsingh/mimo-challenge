package com.example.mimo.ui.signup;

import com.example.mimo.entity.account.SignUpResponse;
import com.example.mimo.model.auth.AuthRepository;
import com.example.mimo.model.ResponseCallback;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class SignupPresenter implements SignUpContract.Presenter {

    private AuthRepository authRepository;
    @Nullable
    private SignUpContract.View signupView;

    @Inject
    public SignupPresenter(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }


    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
    }

    @Override
    public void signUp(String email, String password) {
        signupView.setLoadingIndicator(true);
        authRepository.signup(email, password, new ResponseCallback<SignUpResponse>() {
            @Override
            public void onSuccess(SignUpResponse signUpResponse) {
                signupView.setLoadingIndicator(false);
                signupView.showSignUpSuccessful();
            }

            @Override
            public void onFailure(String error) {
                signupView.setLoadingIndicator(false);
                signupView.showSignUpError(error);
            }
        });
    }

    @Override
    public void takeView(SignUpContract.View view) {
        signupView = view;
    }

    @Override
    public void dropView() {
        signupView = null;
    }
}
