package com.example.mimo.ui.login;

import android.content.Intent;
import android.os.Bundle;

import com.example.mimo.R;
import com.example.mimo.ui.base.BaseActivity;
import com.example.mimo.ui.home.HomeActivity;
import com.example.mimo.utils.ActivityUtils;
import com.example.mimo.utils.SharedPreferenceUtil;

import javax.inject.Inject;

import dagger.Lazy;

public class LoginActivity extends BaseActivity {

    @Inject
    Lazy<LoginFragment> loginFragmentLazy;
    @Inject
    SharedPreferenceUtil sharedPreferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (sharedPreferenceUtil.isLoggedIn()) {
            navigateHomeScreen();
            finish();
            return;
        }

        setContentView(R.layout.container_act);

        LoginFragment loginFragment =
                (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (loginFragment == null) {
            loginFragment = loginFragmentLazy.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), loginFragment, R.id.content_frame);
        }
    }

    private void navigateHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
