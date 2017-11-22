package com.example.mimo.ui.login;

import com.example.mimo.di.scope.ActivityScoped;
import com.example.mimo.di.scope.FragmentScoped;
import com.example.mimo.model.auth.AuthRepository;
import com.example.mimo.model.auth.remote.RemoteAuthRepository;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by shivam on 18/11/17.
 */

@Module
public abstract class LoginModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract LoginContract.Presenter loginPresenter(LoginPresenter presenter);

    @ActivityScoped
    @Binds
    abstract AuthRepository authRepository(RemoteAuthRepository remoteAuthRepository);
}
