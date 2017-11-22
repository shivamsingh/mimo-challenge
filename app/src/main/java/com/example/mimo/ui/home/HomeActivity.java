package com.example.mimo.ui.home;

import android.os.Bundle;

import com.example.mimo.R;
import com.example.mimo.ui.base.BaseActivity;
import com.example.mimo.ui.signup.SignUpFragment;
import com.example.mimo.utils.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;

public class HomeActivity extends BaseActivity {

    @Inject
    Lazy<HomeFragment> homeFragmentLazy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_act);

        HomeFragment homeFragment =
                (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (homeFragment == null) {
            homeFragment = homeFragmentLazy.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), homeFragment, R.id.content_frame);
        }
    }
}
