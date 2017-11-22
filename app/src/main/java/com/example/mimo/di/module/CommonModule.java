package com.example.mimo.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.mimo.utils.Constant;
import com.example.mimo.utils.SharedPreferenceUtil;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class CommonModule {

    @Provides
    @Singleton
    protected SharedPreferences sharedPreferences(Application application) {
        return application.getSharedPreferences(Constant.APP_PREFS, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    protected SharedPreferenceUtil sharedPreferenceUtil(SharedPreferences sharedPreferences) {
        return SharedPreferenceUtil.getInstance(sharedPreferences);
    }

    @Provides
    @Singleton
    protected Picasso picasso(Application application, OkHttpClient client) {
        return new Picasso
                .Builder(application.getApplicationContext())
                .downloader(new OkHttp3Downloader(client))
                .build();
    }
}
