package com.example.mimo.ui.home;

import com.example.mimo.entity.profile.User;
import com.example.mimo.ui.base.BasePresenter;
import com.example.mimo.ui.base.BaseView;
import com.example.mimo.ui.login.LoginContract;

public interface HomeContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showProfile(User user);

        void showLoadProfileError(String error);

        void logout();
    }

    interface Presenter extends BasePresenter {

        void loadProfile();

        void takeView(View view);

        void dropView();

        void logout();
    }
}
