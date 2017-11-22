package com.example.mimo.di;

import android.app.Application;

import com.example.mimo.MimoApplication;
import com.example.mimo.di.module.ActivityBindingModule;
import com.example.mimo.di.module.ApplicationModule;
import com.example.mimo.di.module.CommonModule;
import com.example.mimo.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        CommonModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(MimoApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
