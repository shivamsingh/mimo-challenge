package com.example.mimo.di.module;

import com.example.mimo.di.scope.ActivityScoped;
import com.example.mimo.model.profile.ProfileRepository;
import com.example.mimo.model.profile.ProfileRepositoryModule;
import com.example.mimo.ui.home.HomeActivity;
import com.example.mimo.ui.home.HomeModule;
import com.example.mimo.model.auth.AuthRepositoryModule;
import com.example.mimo.ui.login.LoginActivity;
import com.example.mimo.ui.login.LoginModule;
import com.example.mimo.ui.signup.SignUpActivity;
import com.example.mimo.ui.signup.SignUpModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {LoginModule.class, AuthRepositoryModule.class})
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {SignUpModule.class, AuthRepositoryModule.class})
    abstract SignUpActivity signUpActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {HomeModule.class, ProfileRepositoryModule.class})
    abstract HomeActivity homeActivity();
}
