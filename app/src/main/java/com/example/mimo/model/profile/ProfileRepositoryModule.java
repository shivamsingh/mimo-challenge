package com.example.mimo.model.profile;

import com.example.mimo.di.scope.ActivityScoped;
import com.example.mimo.network.profile.ProfileService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ProfileRepositoryModule {

    @ActivityScoped
    @Provides
    ProfileService profileService(Retrofit retrofit) {
        return retrofit.create(ProfileService.class);
    }
}
