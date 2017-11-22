package com.example.mimo.ui.signup;

import com.example.mimo.ui.base.BasePresenter;
import com.example.mimo.ui.base.BaseView;

public interface SignUpContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showSignUpError(String message);

        void showSignUpSuccessful();
    }

    interface Presenter extends BasePresenter {

        void signUp(String email, String password);

        void takeView(SignUpContract.View view);

        void dropView();
    }
}
