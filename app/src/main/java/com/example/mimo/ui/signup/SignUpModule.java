package com.example.mimo.ui.signup;

import com.example.mimo.di.scope.ActivityScoped;
import com.example.mimo.di.scope.FragmentScoped;
import com.example.mimo.model.auth.AuthRepository;
import com.example.mimo.model.auth.remote.RemoteAuthRepository;
import com.example.mimo.ui.login.LoginContract;
import com.example.mimo.ui.login.LoginPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SignUpModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SignUpFragment signUpFragment();

    @ActivityScoped
    @Binds
    abstract SignUpContract.Presenter signupPresenter(SignupPresenter presenter);

    @ActivityScoped
    @Binds
    abstract AuthRepository authRepository(RemoteAuthRepository remoteAuthRepository);
}
