package com.example.mimo.ui.home;

import com.example.mimo.di.scope.ActivityScoped;
import com.example.mimo.di.scope.FragmentScoped;
import com.example.mimo.model.profile.ProfileRepository;
import com.example.mimo.model.profile.remote.RemoteProfileRepository;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

    @ActivityScoped
    @Binds
    abstract HomeContract.Presenter presenter(HomePresenter presenter);

    @ActivityScoped
    @Binds
    abstract ProfileRepository profileRepository(RemoteProfileRepository remoteProfileRepository);
}
