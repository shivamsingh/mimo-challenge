package com.example.mimo.di.module;

import com.example.mimo.entity.account.AccessToken;
import com.example.mimo.network.NetworkCredentials;
import com.example.mimo.utils.Constant;
import com.example.mimo.utils.HeaderInterceptor;
import com.example.mimo.utils.SharedPreferenceUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    NetworkCredentials networkCredentials() {
        return new NetworkCredentials(Constant.API_URL_BASE, Constant.CLIENT_ID, Constant.CONNECTION,
                Constant.GRANT_TYPE, Constant.SCOPE);
    }

    @Provides
    AccessToken accessToken(SharedPreferenceUtil sharedPreferenceUtil) {
        return new AccessToken(sharedPreferenceUtil.getAuthToken(),
                sharedPreferenceUtil.getAuthTokenType());
    }

    @Provides
    @Singleton
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient httpClient(SharedPreferenceUtil sharedPreferenceUtil) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(new HeaderInterceptor(sharedPreferenceUtil))
                .addInterceptor(logging)
                .build();
    }

    @Provides
    @Singleton
    protected Retrofit retrofit(Gson gson, OkHttpClient okHttpClient, NetworkCredentials networkCredentials) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(networkCredentials.getApiUrl())
                .client(okHttpClient)
                .build();
    }
}
