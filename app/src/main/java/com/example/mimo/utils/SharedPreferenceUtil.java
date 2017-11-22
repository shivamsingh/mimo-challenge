package com.example.mimo.utils;

import android.content.SharedPreferences;

public class SharedPreferenceUtil {

    private static final String AUTH_ACCESS_TOKEN = "auth_access_token";
    private static final String AUTH_TOKEN_TYPE = "auth_token_type";

    private static SharedPreferenceUtil mInstance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPreferenceUtil(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
    }

    public static SharedPreferenceUtil getInstance(SharedPreferences sharedPreferences) {
        if (null == mInstance) {
            mInstance = new SharedPreferenceUtil(sharedPreferences);
        }
        return mInstance;
    }

    public void reset() {
        editor.clear().commit();
    }

    public boolean isLoggedIn() {
        return !getAuthToken().equals("");
    }

    public String getAuthToken() {
        return sharedPreferences.getString(AUTH_ACCESS_TOKEN, "");
    }

    public void setAuthToken(String authToken) {
        editor.putString(AUTH_ACCESS_TOKEN, authToken).commit();
    }

    public void clearAuthToken() {
        setAuthToken("");
    }

    public String getAuthTokenType() {
        return sharedPreferences.getString(AUTH_TOKEN_TYPE, "");
    }

    public void setAuthTokenType(String authTokenType) {
        editor.putString(AUTH_TOKEN_TYPE, authTokenType).commit();
    }

    public String getAuthorization() {
        return getAuthTokenType() + " " + getAuthToken();
    }
}
