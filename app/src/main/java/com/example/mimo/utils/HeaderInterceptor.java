package com.example.mimo.utils;

import android.support.annotation.NonNull;

import com.example.mimo.entity.account.AccessToken;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    private final SharedPreferenceUtil sharedPreferenceUtil;

    public HeaderInterceptor(@NonNull SharedPreferenceUtil sharedPreferenceUtil) {
        this.sharedPreferenceUtil = sharedPreferenceUtil;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(
                chain.request()
                        .newBuilder()
                        .addHeader("Authorization", sharedPreferenceUtil.getAuthorization())
                        .build()
        );
    }
}
