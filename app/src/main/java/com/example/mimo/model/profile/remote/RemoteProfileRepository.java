package com.example.mimo.model.profile.remote;

import com.example.mimo.entity.profile.User;
import com.example.mimo.model.ResponseCallback;
import com.example.mimo.model.remote.entity.RemoteResponseCallback;
import com.example.mimo.model.profile.ProfileRepository;
import com.example.mimo.network.profile.ProfileService;

import javax.inject.Inject;


public class RemoteProfileRepository implements ProfileRepository {

    ProfileService profileService;

    @Inject
    public RemoteProfileRepository(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public void profile(ResponseCallback<User> responseCallback) {
        profileService.profile().enqueue(new RemoteResponseCallback<>(responseCallback));
    }
}
