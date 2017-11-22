package com.example.mimo.model.profile;

import com.example.mimo.entity.profile.User;
import com.example.mimo.model.ResponseCallback;

public interface ProfileRepository {

    void profile(ResponseCallback<User> responseCallback);
}
