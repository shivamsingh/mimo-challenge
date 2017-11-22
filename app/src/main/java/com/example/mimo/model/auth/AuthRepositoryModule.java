package com.example.mimo.model.auth;

import com.example.mimo.di.scope.ActivityScoped;
import com.example.mimo.network.account.AuthService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthRepositoryModule {

    @ActivityScoped
    @Provides
    AuthService authService(Retrofit retrofit) {
        return retrofit.create(AuthService.class);
    }
}
