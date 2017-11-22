package com.example.mimo.ui.home;


import android.support.annotation.NonNull;

import com.example.mimo.entity.profile.User;
import com.example.mimo.model.ResponseCallback;
import com.example.mimo.model.profile.ProfileRepository;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.Presenter {

    private ProfileRepository profileRepository;
    private HomeContract.View homeView;

    @Inject
    public HomePresenter(@NonNull ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
    }

    @Override
    public void loadProfile() {
        homeView.setLoadingIndicator(true);
        profileRepository.profile(new ResponseCallback<User>() {
            @Override
            public void onSuccess(User user) {
                homeView.setLoadingIndicator(false);
                homeView.showProfile(user);
            }

            @Override
            public void onFailure(String error) {
                homeView.setLoadingIndicator(false);
                homeView.showLoadProfileError(error);
            }
        });
    }

    @Override
    public void takeView(HomeContract.View view) {
        homeView = view;
    }

    @Override
    public void dropView() {
        homeView = null;
    }

    @Override
    public void logout() {
        homeView.logout();
    }
}
