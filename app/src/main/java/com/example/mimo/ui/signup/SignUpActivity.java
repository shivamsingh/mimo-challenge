package com.example.mimo.ui.signup;

import android.os.Bundle;

import com.example.mimo.R;
import com.example.mimo.ui.base.BaseActivity;
import com.example.mimo.utils.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;

public class SignUpActivity extends BaseActivity {

    @Inject
    Lazy<SignUpFragment> signUpFragmentLazy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_act);

        SignUpFragment signUpFragment =
                (SignUpFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (signUpFragment == null) {
            signUpFragment = signUpFragmentLazy.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), signUpFragment, R.id.content_frame);
        }
    }
}
