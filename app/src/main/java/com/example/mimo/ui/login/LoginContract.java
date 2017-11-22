package com.example.mimo.ui.login;

import com.example.mimo.ui.base.BasePresenter;
import com.example.mimo.ui.base.BaseView;
import com.example.mimo.entity.account.AccessToken;

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showLoginError(String message);

        void showLoginSuccessful(AccessToken accessToken);
    }

    interface Presenter extends BasePresenter {

        void login(String username, String password);

        void takeView(View view);

        void dropView();
    }
}
